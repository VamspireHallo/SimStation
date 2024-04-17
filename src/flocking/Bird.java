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
        speed = Utilities.rng.nextInt(1,5) + 1;
    }

    public void update() {
        List<Agent> neighbors = sim.getAllNeighbors(this, 20);
        if (!neighbors.isEmpty()){
            double averageSpeed = 0;
            double averageX = 0;
            double averageY = 0;

            for (Agent neighbor : neighbors) {
                Bird bird = (Bird) neighbor;
                averageSpeed += bird.speed;
                averageX += bird.xc;
                averageY += bird.yc;
            }

            averageSpeed /= neighbors.size();
            averageX /= neighbors.size();
            averageY /= neighbors.size();

            // Adjust speed based on average speed of neighbors
            speed = (1 - 0.1) * speed + 0.1 * averageSpeed;
        }
        move((int)speed);
    }

    public synchronized int getSpeed(){
        return (int)speed;
    }
}
