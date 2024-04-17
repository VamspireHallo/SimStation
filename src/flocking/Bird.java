package flocking;
import simstation.*;
import mvc.*;

import java.util.List;

public class Bird extends Agent{
    public double speed;
    public static final double MAX_SPEED = 5;
    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public void update() {
        Bird neighbor = (Bird) sim.getNeighbor(this, 5);

        this.speed = neighbor.speed;
        this.heading = neighbor.heading;

        int steps = Utilities.rng.nextInt(10) + 1;
        move((int)steps);
    }

    public synchronized int getSpeed(){
        return (int)speed;
    }
}
