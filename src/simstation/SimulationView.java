package simstation;
import mvc.*;

import java.awt.*;
import java.util.Iterator;

public class SimulationView extends View {
    protected Color agentColor = Color.WHITE;
    protected Color backgroundColor = Color.DARK_GRAY;

    public SimulationView(Model model) {
        super(model);
        this.setBackground(backgroundColor);
    }

    public void setBG (Color color) {
        backgroundColor = color;
        this.setBackground(backgroundColor);
    }

    protected void drawAgents(Graphics gc) {
        try {
            Simulation simulation = (Simulation) model;
            Iterator<Agent> it = simulation.agents.iterator();
            gc.setColor(agentColor);

            double cellWidth = ((double)getWidth())/ Simulation.SIZE;
            double cellHeight = ((double)getHeight())/ Simulation.SIZE;

            while (it.hasNext()) {
                Agent a = it.next();
                int x = (int) (a.getXc() * cellWidth);
                int y = (int) (a.getYc() * cellHeight);
                int agentSize = (int) Math.min(cellWidth, cellHeight) * 5;
                gc.fillOval(x, y, agentSize, agentSize);
            }
        } catch (ClassCastException e) {
            Utilities.error(e);
        }
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();

        gc.setColor(backgroundColor);
        gc.fillRect(0,0, getWidth(), getHeight());
        drawAgents(gc);

        gc.setColor(oldColor);
    }

}
