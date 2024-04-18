package RandomWalks;
import mvc.*;
import simstation.*;

class RandomWalkFactory extends SimulationFactory {
    public Model makeModel() {
        return new RandomWalkSimulation();
    }
    public String getTitle() {
        return "Random Walks Simulator";
    }
    public View makeView(Model model) {
        return new SimulationView(model);
    }
}
