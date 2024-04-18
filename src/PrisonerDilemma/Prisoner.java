package PrisonerDilemma;

import mvc.*;
import simstation.*;

public class Prisoner extends Agent {
    private static final int RADIUS = 20;
    private int fitness = 0;
    private int vindictiveness = 0;
    // when global vindictiveness is 0, punishing cheaters is disabled
    private boolean partnerCheated = false;
    // switch this to a table to compare against all previous agents
    private Strategy s;
    private int strategyAsInt;
    public Prisoner(Strategy s, int i, String name) {
        super(name);
        this.s = s;
        this.strategyAsInt = i;
        // add random vindictiveness capped at global maximum
    }

    public boolean cooperate() {
        return s.decide(partnerCheated);
        // consults the prisoner's strategy
        // returns true if cooperate
        // returns false if cheat
    }

    public void update() {
        // find partner
        Prisoner partner = (Prisoner)sim.getNeighbor(this, RADIUS);
        // play a game with partner, update fitness and partnerCheated
        // allow the user to change the parameters of the problem?
        boolean myChoice = cooperate();
        boolean partnerChoice;
        if (partner != null && partner.s != null) {
            partnerChoice = partner.cooperate();
            if (myChoice && myChoice == partnerChoice) {
                // both cooperated
                updateFitness(3);
                partner.updateFitness(3);
                partnerCheated = false;
                partner.partnerCheated = false;
            } else if (!myChoice && myChoice == partnerChoice) {
                // both cheated
                updateFitness(1);
                partner.updateFitness(1);
                partnerCheated = true;
                partner.partnerCheated = true;
            } else if (myChoice && myChoice != partnerChoice) {
                // I cooperated, my partner cheated
                updateFitness(0);
                partner.updateFitness(5);
                partnerCheated = true;
                partner.partnerCheated = false;
            } else {
                // I cheated, my partner cooperated
                updateFitness(5);
                partner.updateFitness(0);
                partnerCheated = false;
                partner.partnerCheated = true;
            }
        }
        heading = Heading.random();
        move(5);
    }

    private void updateFitness(int amt) {
        fitness = fitness + amt;
    }

    public int getFitness() { return fitness; }

    public int getStrategyAsInt() {
        return strategyAsInt; }
    public Strategy getStrategy() {
        return s; }
}
