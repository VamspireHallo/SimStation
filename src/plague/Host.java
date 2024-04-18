package plague;

import mvc.*;
import simstation.*;

public class Host extends Agent {
    private boolean infected;
    public Host(String name, boolean infection){
        super();
        infected = infection;
        heading = Heading.random();
    }

    public boolean infect(int rate){
        this.infected = true;
        return Utilities.rng.nextInt(100) < rate;
    }
    public boolean resist(int rate){
        return Utilities.rng.nextInt(100) < rate;
    }


    public boolean setInfected(){
        return infected;
    }
    @Override
    public void update() {
        Host neighbor = (Host)sim.getNeighbor(this, 20);

        if (neighbor != null && neighbor.infected && !this.infected){
            infected = infect(PlagueSimulation.VIRULENCE);
            boolean resist = resist(PlagueSimulation.RESISTANCE);

            if (resist){
                infected = false ;
            }
        }

        heading = Heading.random();
        move(3);
    }
}
