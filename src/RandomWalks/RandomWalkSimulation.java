package RandomWalks;
import flocking.Bird;
import mvc.*;
import plague.Host;
import simstation.*;

public class RandomWalkSimulation extends Simulation {

    @Override
    public String[] stats()
    {
        int[] speeds = new int[5];

        String[] stats = new String[5];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stats.length; ++i) {
            builder.append("Drunk Speed ");
            builder.append(i + 1);
            builder.append(" = ");
            builder.append(speeds[i]);
            stats[i] = builder.toString();
            builder.setLength(0);
        }
        return stats;




    }

    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}
