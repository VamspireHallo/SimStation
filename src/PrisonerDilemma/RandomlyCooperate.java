package PrisonerDilemma;

import simstation.*;
import mvc.*;
public class RandomlyCooperate implements Strategy {
    public boolean decide(boolean partnerCheated) {
        int random = Utilities.rng.nextInt(100)%2;
        if (random==0) {
            return true;
        }
        return false;
    }
}
