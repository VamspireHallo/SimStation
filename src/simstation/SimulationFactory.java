package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView((Simulation) model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }

    @Override
    public abstract String getTitle();

    @Override
    public String[] getHelp() {
        return new String[] {
                "Start populates the simulation with agents",
                "Suspend pauses the simulation",
                "Resume recommences the simulation",
                "Stop halts the agents in the simulation",
                "Stats showcases the data of the simulation"
        };
    }

    @Override
    public String about() {
        return "SimStation Simulator version 1.0. Copyright 2024 by Group 12. SJSU";
    }
}
