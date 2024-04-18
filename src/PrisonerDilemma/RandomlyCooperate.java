package PrisonerDilemma;

import simstation.*;
import mvc.*;
public class RandomlyCooperate extends Strategy {
    public RandomlyCooperate(Prisoner myPrisoner) { super(myPrisoner); }

    @Override
    public boolean cooperate() {
        return Utilities.rng.nextDouble() < 0.5;
    }
}
