package plague;
import simstation.*;
import mvc.*;

import java.awt.*;
import java.util.Iterator;

public class PlagueView extends SimulationView {
    public PlagueView(Model model) {
        super(model);
    }

    protected void drawAgents(Graphics gc) {
        Simulation simulation = (Simulation) model;
        Iterator<Agent> it = simulation.agents.iterator();

        double cellWidth = ((double)getWidth())/ Simulation.SIZE;
        double cellHeight = ((double)getHeight())/ Simulation.SIZE;

        setBG(Color.LIGHT_GRAY);

        while (it.hasNext()) {
            Host a = (Host)it.next();
            if (a.setInfected())
            {
                gc.setColor(Color.RED);
            }
            else{
                gc.setColor(Color.GREEN);
            }
            int agentSize = (int) Math.min(cellWidth, cellHeight) * 5;
            gc.fillOval((int)(a.getXc() *cellWidth), (int)(a.getYc() *cellHeight), agentSize, agentSize);
        }
    }
}
