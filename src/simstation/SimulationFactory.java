package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory {

    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Start")
            return new StartCommand(model);
        if (type == "Suspend")
            return new SuspendCommand(model);
        if (type == "Resume")
            return new ResumeCommand(model);
        if (type == "Stop")
            return new StopCommand(model);
        if (type == "Stats")
            return new StatsCommand(model);
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
