package flocking;
import mvc.*;
import simstation.*;

import java.util.Iterator;

public class FlockingSimulation extends Simulation {

    public String[] stats() {
        int[] speeds = new int[Bird.MAX_SPEED];
        Iterator<Agent> agentIterator = agentIterator();
        while (agentIterator.hasNext()) {
            speeds[((Bird) agentIterator.next()).getSpeed() - 1]++;
        }
        String[] stats = new String[Bird.MAX_SPEED];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stats.length; ++i) {
            builder.append("#Birds @ speed ");
            builder.append(i + 1);
            builder.append(" = ");
            builder.append(speeds[i]);
            stats[i] = builder.toString();
            builder.setLength(0);
        }
        return stats;
    }

    public void populate() {
        for (int i = 0; i < 50; ++i) {
            addAgent(new Bird());
        }
    }

}
