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

        double cellWidth = ((double) getWidth()) / Simulation.SIZE;
        double cellHeight = ((double) getHeight()) / Simulation.SIZE;

        while (it.hasNext()) {
            Prisoner a = (Prisoner) it.next();
            Color agentColor = getColorForStrategy(a.getStrategy());
            gc.setColor(agentColor);
            gc.fillRect((int) (a.getXc() * cellWidth), (int) (a.getYc() * cellHeight), (int) cellWidth, (int) cellHeight);
        }
    }

    private Color getColorForStrategy(Strategy strategy) {
        if (strategy instanceof Cheat) {
            return COLOR_CHEAT;
        } else if (strategy instanceof Cooperate) {
            return COLOR_COOPERATE;
        } else if (strategy instanceof RandomlyCooperate) {
            return COLOR_RANDOMLY_COOPERATE;
        } else if (strategy instanceof Tit4Tat) {
            return COLOR_TIT4TAT;
        } else {
            // Default color if strategy type is unrecognized
            return Color.WHITE;
        }
    }
}
