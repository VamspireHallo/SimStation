package plague;
import simstation.*;
import mvc.*;

import java.awt.*;

public class PlagueView extends SimulationView {
    public PlagueView(Model model) {
        super(model);
    }

    protected void drawHosts(Graphics gc, Host host, Agent agent) {
        Color color;
        if (host.isInfected()) {
            color = Color.RED;
        } else {
            color = Color.GREEN;
        }
        gc.setColor(color);
        int x = agent.getXc();
        int y = agent.getYc();
        gc.fillOval(x, y, 10, 10);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        var sim = (PlagueSimulation) model;
        for (Agent agent : sim.getAgents()) {
            Host plague = (Host) agent;
            Color color;
            if (plague.isInfected()) {
                color = Color.RED; // infected color
            } else {
                color = Color.GREEN; // No infect color
            }
            gc.setColor(color);
            int x = agent.getXc();
            int y = agent.getYc();
            gc.fillOval(x, y, 10, 10);
        }
    }
}
