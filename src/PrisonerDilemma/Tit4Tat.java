package PrisonerDilemma;

import simstation.*;
import mvc.*;
public class Tit4Tat extends Strategy {
    public Tit4Tat(Prisoner myPrisoner) {
        super(myPrisoner);
    }

    @Override
    public boolean cooperate() {
        return !myPrisoner.hasPartnerCheated();
    }
}
