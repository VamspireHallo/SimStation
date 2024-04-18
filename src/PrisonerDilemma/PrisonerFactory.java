package PrisonerDilemma;

import mvc.*;
import simstation.*;
public class PrisonerFactory extends SimulationFactory{
    public Model makeModel() {
        return new PrisonerSimulation();
    }
    public String getTitle() {
        return "Prisoner's Dilemma Tournament Simulator";
    }
    public View makeView(Model model) {
        return new PrisonerView(model);
    }
}
