package plague;
import mvc.Utilities;
import simstation.*;
import java.util.Random;

public class Host extends Agent {
    private boolean infected;
    private int resistance;
    private Simulation sim;

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
        Host neighbor = (Host) sim.getNeighbor(this, 1);
        if (neighbor != null && !neighbor.isInfected())
        {
            boolean infect = Utilities.rng.nextInt(101) < PlagueSimulation.VIRULENCE;
            boolean resist = Utilities.rng.nextInt(101) < PlagueSimulation.RESISTANCE;

            //if both not hit keep true
            if (infect && !resist)
            {
                neighbor.setInfected(true);
            }
        }

        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}
