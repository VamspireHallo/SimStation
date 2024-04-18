package plague;
import simstation.*;
import mvc.*;

import java.util.Iterator;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public int infected;
    // Constructor
    public PlagueSimulation() {
        super();
    }

    // Override populate method to create initial population
    @Override
    public void populate() {
        infected = 0;
        for(int i = 0; i < 50; i++)
            addAgent(new Host("Host " + i, false));
        initialize();
    }

    // Method to infect some initial hosts
    private void initialize(){
        Iterator<Agent> it = agentIterator();
        while(it.hasNext()){
            if (infected < 1){
                ((Host)it.next()).infect(1);
                infected++;
            }
            else {it.next();}
        }
    }


    public String[] stats() {
        int totalHosts = agents.size();
        int infectedHosts = 0;
        for (Agent agent : agents) {
            Host host = (Host) agent;
            if (host.setInfected()) {
                infectedHosts++;
            }
        }
        double percentageInfected = (double) infectedHosts / totalHosts * 100;
        return new String[]{"#agents = " + infectedHosts,
                "clock: " + getClock(),
                "% infected: " + percentageInfected};
    }
}
