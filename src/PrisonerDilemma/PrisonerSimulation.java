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

    public Iterator<Agent> agentIterator() {
        List<Agent> agents = getAgents(); // Retrieve the list of agents from the simulation
        return agents.iterator(); // Return an iterator over the list of agents
    }

    @Override
    public String[] stats() {
        float totalFitnessCooperate = 0.0f;
        int countCooperate = 0;
        float totalFitnessCheat = 0.0f;
        int countCheat = 0;
        float totalFitnessRandomCooperate = 0.0f;
        int countRandomCooperate = 0;
        float totalFitnessTit4Tat = 0.0f;
        int countTit4Tat = 0;

        for (Agent agent : getAgents()) {
            Prisoner prisoner = (Prisoner) agent;
            Strategy strategy = prisoner.getStrategy();
            float fitness = prisoner.getFitness();

            if (strategy instanceof Cooperate) {
                totalFitnessCooperate += fitness;
                countCooperate++;
            } else if (strategy instanceof Cheat) {
                totalFitnessCheat += fitness;
                countCheat++;
            } else if (strategy instanceof RandomlyCooperate) {
                totalFitnessRandomCooperate += fitness;
                countRandomCooperate++;
            } else if (strategy instanceof Tit4Tat) {
                totalFitnessTit4Tat += fitness;
                countTit4Tat++;
            }
        }

        // Calculate average fitness for each strategy type
        float avgFitnessCooperate = (countCooperate > 0) ? totalFitnessCooperate / countCooperate : 0.0f;
        float avgFitnessCheat = (countCheat > 0) ? totalFitnessCheat / countCheat : 0.0f;
        float avgFitnessRandomCooperate = (countRandomCooperate > 0) ? totalFitnessRandomCooperate / countRandomCooperate : 0.0f;
        float avgFitnessTit4Tat = (countTit4Tat > 0) ? totalFitnessTit4Tat / countTit4Tat : 0.0f;

        return new String[] {
                "Average Cooperate Fitness: " + avgFitnessCooperate,
                "Average Cheat Fitness: " + avgFitnessCheat,
                "Average Randomly Cooperate Fitness: " + avgFitnessRandomCooperate,
                "Average Tit4Tat Fitness: " + avgFitnessTit4Tat
        };
    }
}
