package flocking;
import mvc.*;
import simstation.*;

public class FlockingSimulation extends Simulation {
    @Override
    public String[] stats() {
        int[] speeds = new int[(int)Bird.MAX_SPEED];

        String[] stats = new String[(int)Bird.MAX_SPEED];
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
            addAgent(new Bird("#Bird " + i));
        }
    }

}
