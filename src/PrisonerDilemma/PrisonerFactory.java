package PrisonerDilemma;
import mvc.*;
import simstation.*;
public class PrisonerFactory extends SimulationFactory {

    @Override
    public Model makeModel() { return new PrisonerSimulation(); }

    @Override
    public View makeView(Model model) {
        return new PrisonerView((PrisonerSimulation)model);
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma Tournament";
    }

}
