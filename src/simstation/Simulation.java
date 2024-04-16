package simstation;

import java.util.*;
import mvc.*;

public abstract class Simulation extends Model {

    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    public final static int SIZE = 200;
    public List<Agent> agents = new ArrayList<>();

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    // etc.
    public void start() {
        startTimer();
        agents.clear();
        populate();
        for (Agent a : agents) {
            a.start();
        }
        notify();
    }
    public void suspend() {
        stopTimer();
        for (Agent a : agents) {
            a.suspend();
        }
        notify();
    }
    public void resume() {
        startTimer();
        for (Agent a : agents) {
            a.resume();
        }
        notify();
    }
    public void stop() {
        for (Agent a : agents) {
            a.start();
        }
        notify();
    }
    public abstract String[] stats();

    public abstract void populate();

}