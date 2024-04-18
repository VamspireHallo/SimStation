package PrisonerDilemma;

import mvc.*;
import simstation.*;

public class PrisonerPanel extends SimulationPanel{
    public PrisonerPanel(AppFactory factory) {
        super(factory);
    }
    public static void main(String[] args) {
        AppFactory factory = new PrisonerFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
