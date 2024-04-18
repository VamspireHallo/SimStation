package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.awt.*;
import java.util.Iterator;

public class PrisonerView extends SimulationView {
    public PrisonerView(Model model) {
        super(model);
    }
    private final Color COLOR_COOPERATE = Color.GREEN;
    private final Color COLOR_RANDOMLY_COOPERATE = Color.YELLOW;
    private final Color COLOR_CHEAT = Color.RED;
    private final Color COLOR_TIT4TAT = Color.BLUE;
    protected void drawAgents(Graphics gc) {
        Simulation simulation = (Simulation) model;
        Iterator<Agent> it = simulation.agents.iterator();

        double cellWidth = ((double)getWidth())/ Simulation.SIZE;
        double cellHeight = ((double)getHeight())/ Simulation.SIZE;

        while (it.hasNext()) {
            Prisoner a = (Prisoner)it.next();
            if (a.getStrategyAsInt() == 0) {
                gc.setColor(COLOR_CHEAT);
            }
            else if (a.getStrategyAsInt() == 1) {
                    gc.setColor(COLOR_COOPERATE);
                }
            else if (a.getStrategyAsInt() == 2) {
                    gc.setColor(COLOR_RANDOMLY_COOPERATE);
                }
            else {
                gc.setColor(COLOR_TIT4TAT);
            }
            int agentSize = (int) Math.min(cellWidth, cellHeight) * 5;
            gc.fillOval((int)(a.getXc() *cellWidth), (int)(a.getYc() *cellHeight), agentSize, agentSize);
        }
    }
}
