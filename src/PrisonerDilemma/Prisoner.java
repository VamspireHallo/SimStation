package PrisonerDilemma;

import mvc.*;
import simstation.*;

import java.util.concurrent.atomic.AtomicInteger;

public class Prisoner extends Agent {
    private AtomicInteger fitness = new AtomicInteger(0);
    private boolean partnerCheated = false;
    private final Strategy strategy;
    protected Prisoner myPrisoner;

    public Prisoner(String name, Strategy.Type type) {
        super(name);
        strategy = Strategy.makeStrategy(type, this);
        this.heading = Heading.random();
    }

    @Override
    public void update() {
        // Prisoner walks around randomly
        heading = Heading.random();
        move(Utilities.rng.nextInt(10) + 1);

        var partner = ((Prisoner) sim.getNeighbor(this, 10));
        if (partner == null)
            return;

        boolean thisCoop = this.cooperate();
        boolean partnerCoop = partner.cooperate();

        if (thisCoop && partnerCoop) {
            this.updateFitness(1);
            partner.updateFitness(1);
        } else if (thisCoop && !partnerCoop) {
            partner.updateFitness(5);
        } else if (!thisCoop && partnerCoop) {
            this.updateFitness(5);
        } else if (!thisCoop && !partnerCoop) {
            this.updateFitness(3);
            partner.updateFitness(3);
        }

        partnerCheated = !partnerCoop;
    }

    public Strategy getStrategy() {
        return strategy;
    }


    public int getFitness() {
        return fitness.get();
    }

    public void updateFitness(int amt) {
        fitness.addAndGet(amt);
    }


    public boolean cooperate() {
        return strategy.cooperate();
    }

    public boolean hasPartnerCheated() {
        return partnerCheated;
    }
}
