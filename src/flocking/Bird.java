package flocking;
import simstation.*;
import mvc.*;

import java.util.List;

public class Bird extends Agent{

    public static final int MAX_SPEED = 5;
    private double speed;
    public Bird() {
        super();
        speed = Utilities.rng.nextInt(MAX_SPEED)+1;
    }

    @Override
    public void update() {
        Bird randNeighbor = (Bird) sim.getNeighbor(this, 5);

        this.speed = randNeighbor.speed;
        this.heading = randNeighbor.heading;

        int steps = Utilities.rng.nextInt(10) + 1;

        move(steps);
    }
    public synchronized int getSpeed(){
        return (int)speed;
    }
}
