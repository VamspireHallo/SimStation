package simstation;
import mvc.*;

import java.awt.*;
import java.util.Iterator;

public class SimulationView extends View {
    public SimulationView(Model model) {
        super(model);
    }

    protected void drawAgents(Graphics gc, Agent agent) {
        gc.setColor(Color.WHITE);
        gc.fillOval(agent.getXc(), agent.getYc(), 10, 10);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Simulation sim = (Simulation) model;

        gc.fillRect(0,0, getWidth(), getHeight());
        for (Agent agent : sim.agents) {
            drawAgents(gc, agent);
        }


        gc.setColor(oldColor);
    }


}
