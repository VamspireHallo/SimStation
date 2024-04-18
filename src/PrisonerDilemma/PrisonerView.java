package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.awt.*;
import java.util.Iterator;

public class PrisonerView extends SimulationView {
    public PrisonerView(Model model) {
        super(model);
    }
    protected void drawAgents(Graphics gc) {
        Simulation simulation = (Simulation) model;
        Iterator<Agent> it = simulation.agents.iterator();

        double cellWidth = ((double)getWidth())/ Simulation.SIZE;
        double cellHeight = ((double)getHeight())/ Simulation.SIZE;

        while (it.hasNext()) {
            Prisoner a = (Prisoner)it.next();
            if (a.getStrategyAsInt() == 0)
                {gc.setColor(Color.RED);}
            else if (a.getStrategyAsInt() == 1)
                {gc.setColor(Color.GREEN);}
            else if (a.getStrategyAsInt() == 2)
                {gc.setColor(Color.YELLOW);}
            else {gc.setColor(Color.BLUE);}
            gc.fillRect((int)(a.getXc() *cellWidth), (int)(a.getYc() *cellHeight), (int)cellWidth, (int)cellHeight);
        }
    }
}
