package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.awt.*;
import java.util.Iterator;
public class PrisonerView extends SimulationView {
    public PrisonerView(Model m) {
        super(m);
        this.setBackground(Color.GRAY);
    }

    private final Color COLOR_COOPERATE = Color.GREEN;
    private final Color COLOR_RANDOMLY_COOPERATE = Color.YELLOW;
    private final Color COLOR_CHEAT = Color.RED;
    private final Color COLOR_TIT4TAT = Color.BLUE;



    protected void drawAgents(Graphics gc) {
        PrisonerSimulation ps = (PrisonerSimulation) model;
        Iterator<Agent> it = ps.agentIterator();

        double cellWidth = ((double)getWidth())/ Simulation.SIZE;
        double cellHeight = ((double)getHeight())/ Simulation.SIZE;

        int centerOffset = 5;
        gc.setColor(Color.WHITE);
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
            gc.fillRect((int)(a.getXc() *cellWidth), (int)(a.getYc() *cellHeight), (int)cellWidth, (int)cellHeight);
        }
    }
}
