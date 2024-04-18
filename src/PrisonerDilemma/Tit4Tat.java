package PrisonerDilemma;

import simstation.*;
import mvc.*;
public class Tit4Tat implements Strategy{
    public boolean decide(boolean partnerCheated) {
        if (partnerCheated == false) {
            return true;
        }
        return false;
    }
}
