package plague;
import simstation.*;
import java.util.Random;

public class Host extends Agent {
    private boolean infected;
    private int resistance;

    // Constructor
    public Host(String name) {
        super(name);
        this.infected = false;
        this.resistance = 0; // Initial resistance level
    }

    // Getter and setter methods for infected and resistance properties
    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    // Override update method to simulate host behavior
    @Override
    public void update() {
        if (infected) {
            spreadInfection();
        }
    }

    // Method to spread infection to neighboring hosts
    private void spreadInfection() {
        PlagueSimulation simulation = (PlagueSimulation) getSim();
        Random random = new Random();
        for (Agent neighbor : simulation.getNeighbor(this)) {
            Host neighborHost = (Host) neighbor;
            if (!neighborHost.isInfected() && random.nextInt(100) < PlagueSimulation.VIRULENCE) {
                if (random.nextInt(100) < PlagueSimulation.RESISTANCE) {
                    neighborHost.setInfected(true);
                }
            }
        }
    }
}
