package plague;
import simstation.*;
import mvc.*;

import java.awt.*;

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
    }

    protected void drawHosts(Graphics gc, Host host) {
        if (host.isInfected()) {
            gc.setColor(Color.RED);
        } else {
            gc.setColor(Color.GREEN);
        }
        gc.fillOval(host.xc, host.yc, 10, 10);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        PlagueSimulation sim = (PlagueSimulation) model;

        for (Agent agent : sim.agents) {
            drawHosts(gc, (Host) agent);
        }

        gc.setColor(oldColor);
    }
}
