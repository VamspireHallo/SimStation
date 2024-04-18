package PrisonerDilemma;
import mvc.*;
public abstract class Strategy {
    protected final Prisoner myPrisoner;
    public Strategy(Prisoner myPrisoner) { this.myPrisoner = myPrisoner; }

    public abstract boolean cooperate();

    public enum Type {
        COOPERATE, CHEAT, RANDOMLY_COOPERATE, TIT4TAT,;
        public static final Type[] VALUES = values();
    }

    public static Strategy makeStrategy(Type type, Prisoner forPrisoner) {
        return switch (type) {
            case COOPERATE -> new Cooperate(forPrisoner);
            case CHEAT -> new Cheat(forPrisoner);
            case RANDOMLY_COOPERATE -> new RandomlyCooperate(forPrisoner);
            case TIT4TAT -> new Tit4Tat(forPrisoner);
        };
    }

}
