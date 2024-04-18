package plague;
import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 5; // % chance of infection
    public static int RESISTANCE = 25; // % chance of resisting infection

    // Constructor
    public PlagueSimulation() {
        super();
    }

    // Override populate method to create initial population
    @Override
    public void populate() {
        addAgent(new Host("Plague 0" , true));
        for(int i = 1; i < 100; i++)
            addAgent(new Host("Plague " + i, false));



    }

    // Method to infect some initial hosts
    private void infectInitialHosts() {

        int numInfected = 0;
        for (int i = 0; i < numInfected; i++) {
            addAgent(new Host("Plague " + i, false));
        }
    }

    // Override stats method to calculate and display statistics

    public String[] stats() {
        int totalHosts = agents.size();
        int infectedHosts = 0;
        for (Agent agent : agents) {
            Host host = (Host) agent;
            if (host.isInfected()) {
                infectedHosts++;
            }
        }
        double percentageInfected = (double) infectedHosts / totalHosts * 100;
        return new String[]{"Infected Hosts: " + infectedHosts,
                "Total Hosts: " + totalHosts,
                "Percentage Infected: " + (percentageInfected) + "%"};
    }
}
