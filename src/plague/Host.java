package plague;

import mvc.*;
import simstation.*;

class Host extends Agent {
    private boolean infected;

    public Host(String name, boolean _infected) {
        super(name);

        //this.setXc(Utilities.rng.nextInt(350));
        //this.setYc(Utilities.rng.nextInt(475));
        heading = Heading.random();
        infected = _infected;
    }

    public void update() {
        Host randNeighbor = (Host) sim.getNeighbor(this, 1);
        if (randNeighbor != null && !randNeighbor.isInfected())
        {
            boolean infect = Utilities.rng.nextInt(101) < PlagueSimulation.VIRULENCE;
            boolean resist = Utilities.rng.nextInt(101) < PlagueSimulation.RESISTANCE;

            //if both not hit keep true
            if (infect && !resist)
            {
                randNeighbor.setInfected(true);
            }
        }

        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

    }

    // allowed to have getters/setters?
    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

}
