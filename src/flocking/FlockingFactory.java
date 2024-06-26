package flocking;
import mvc.*;
import simstation.*;
public class FlockingFactory extends SimulationFactory{
    public Model makeModel() {
        return new FlockingSimulation();
    }
    public String getTitle() {
        return "Flocking Simulator";
    }
    public View makeView(Model model) {
        return new SimulationView(model);
    }
}
