package flocking;
import mvc.*;
import simstation.*;
public class FlockingFactory extends SimulationFactory{
    @Override
    public Model makeModel() {
        return new FlockingSimulation();
    }

    @Override
    public String getTitle() {
        return "Flocking Simulator";
    }
}
