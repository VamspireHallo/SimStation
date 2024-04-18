package PrisonerDilemma;
import simstation.*;
import mvc.*;
public class Cooperate extends Strategy {
    public Cooperate(Prisoner myPrisoner) { super(myPrisoner); }

    @Override
    public boolean cooperate() {
        return true;
    }
}
