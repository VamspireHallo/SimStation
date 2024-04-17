package PrisonerDilemma;

import simstation.Agent;

public class Prisoner extends Agent {
    protected int fitness = 0;
    protected boolean cheated;

    public Prisoner(String name) {
        super(name);
    }

    public boolean cooperate()
    {
        return false;
    }
    @Override
    public void update() {

    }

    public void updateFitness(int amt)
    {

    }
}
