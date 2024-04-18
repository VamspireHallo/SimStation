package PrisonerDilemma;

import mvc.*;
import simstation.*;
class Prisoner extends Agent {
    private static final int RADIUS = 20;
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy s;
    private int strategyAsInt;
    public Prisoner(Strategy s, int i) {
        super();
        this.s = s;
        this.strategyAsInt = i;
    }

    public boolean cooperate() {
        return s.decide(partnerCheated);
    }

    public void update() {
        Prisoner partner = (Prisoner)sim.getNeighbor(this, RADIUS);
        boolean p1Choice = cooperate();
        boolean p2Choice;
        if (partner != null && partner.s != null) {
            p2Choice = partner.cooperate();
            determineFitness(p1Choice, p2Choice, partner);
        }
        heading = Heading.random();
        move(5);
    }
    private void determineFitness(boolean prisoner1, boolean prisoner2, Prisoner partner) {

        if (prisoner1 && prisoner1 == prisoner2) { // both cooperated
            updateFitness(3);
            partner.updateFitness(3);
            partnerCheated = false;
            partner.partnerCheated = false;
        }
        else if (!prisoner1 && prisoner1 == prisoner2) { // both cheated
            updateFitness(1);
            partner.updateFitness(1);
            partnerCheated = true;
            partner.partnerCheated = true;
        }
        else if (prisoner1 && prisoner1 != prisoner2) { // cooperated but partner cheated
            updateFitness(0);
            partner.updateFitness(5);
            partnerCheated = true;
            partner.partnerCheated = false;
        }
        else {                                        // cheated but partner cooperated
            updateFitness(5);
            partner.updateFitness(0);
            partnerCheated = false;
            partner.partnerCheated = true;
        }
    }

    private void updateFitness(int amt) {
        fitness = fitness + amt;
    }

    public int getFitness() { return fitness; }

    public int getStrategyAsInt() {return strategyAsInt; }
}
