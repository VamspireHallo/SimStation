package flocking;
import mvc.*;
import simstation.SimulationPanel;

public class FlockingPanel extends AppPanel{
    public FlockingPanel(AppFactory factory) {
        super(factory);
    }
    public static void main(String[] args) {
        AppFactory factory = new FlockingFactory();
        SimulationPanel panel = new SimulationPanel(factory);
        panel.display();
    }
}
