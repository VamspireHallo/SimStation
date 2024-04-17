package plague;
import simstation.*;
import mvc.Utilities;
import java.util.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    // Constructor
    public PlagueSimulation() {
        super();
    }

    // Override populate method to create initial population
    @Override
    public void populate() {
        for (int i = 0; i < 50; i++) {
            Host host = new Host("Host_" + i);
            agents.add(host);
        }
        // Infect some initial hosts
        infectInitialHosts();
    }

    // Method to infect some initial hosts
    private void infectInitialHosts() {
        Random random = new Random();
        int numInfected = agents.size() / 10; // Infect 10% of initial population
        for (int i = 0; i < numInfected; i++) {
            int index = random.nextInt(agents.size());
            Host host = (Host) agents.get(index);
            host.setInfected(true);
        }
    }

    // Override stats method to calculate and display statistics
    @Override
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
        return new String[]{"Infected Hosts: " + infectedHosts, "Total Hosts: " + totalHosts,
                "Percentage Infected: " + (percentageInfected) + "%"};
    }
}
