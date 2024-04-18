package PrisonerDilemma;
import simstation.*;
import mvc.*;
public class Cheat implements Strategy {
    public boolean decide(boolean partnerCheated) {
        return false;
    }
}
