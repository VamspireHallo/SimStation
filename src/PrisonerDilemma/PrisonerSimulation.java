package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.util.Iterator;
import java.util.List;

public class PrisonerSimulation extends Simulation {

    public static final int COMMUNITY_SIZE = 40;

    @Override
    public void populate() {
        for (int i = 0; i < COMMUNITY_SIZE; i++) {
            for (Strategy.Type type : Strategy.Type.VALUES) {
                String name = "prisoner" + i + "-" + type.name().toLowerCase();
                addAgent(new Prisoner(name, type));
            }
        }
    }

    @Override
    public String[] stats() {
        double[] fitness = new double[4];
        Iterator<Agent> agentIterator = agentIterator();
        while (agentIterator.hasNext()) {
            Prisoner p = (Prisoner) agentIterator.next();
            fitness[p.getStrategyAsInt()] = fitness[p.getStrategyAsInt()] + p.getFitness();
        }
        String[] stats = new String[4];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stats.length; ++i) {
            builder.append("Average Fitness of Strategy [");
            if (i == 0) {
                builder.append("Cheat");
            } else if (i == 1) {
                builder.append("Cooperate");
            } else if (i == 2) {
                builder.append("Randomly Cooperate");
            } else {
                builder.append("Tit4Tat");
            }
            builder.append("] = ");
            builder.append(fitness[i]/(COMMUNITYSIZE/4));
            stats[i] = builder.toString();
            builder.setLength(0);
        }
        return stats;
    }
}
