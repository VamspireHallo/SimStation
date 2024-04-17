package plague;

import mvc.*;
import simstation.*;

public class PlaguePanel extends SimulationPanel{
    public PlaguePanel(AppFactory factory) {
        super(factory);
    }

    public static void main(String[] args) {
        AppFactory factory = new PlagueFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
