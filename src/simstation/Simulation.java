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

    public Agent getNeighbor(Agent agent, double radius) {
        int start = Utilities.rng.nextInt(agents.size());
        for (int i = 0; i < agents.size(); ++i){
            Agent current = agents.get((start + i)%agents.size());
            if (Math.sqrt(Math.pow(current.xc-agent.xc, 2) + Math.pow(current.yc-agent.yc, 2)) < radius){
                return current;
            }
        }

        return null;
    }
    public List<Agent> getAllNeighbors(Agent agent, double radius) {
        LinkedList<Agent> result = new LinkedList<>();
        for (Agent current : agents){
            if (Math.sqrt(Math.pow(current.xc-agent.xc, 2) + Math.pow(current.yc-agent.yc, 2)) < radius){
                result.add(current);
            }
        }
        return result;
    }
    public void addAgent(Agent agent)
    {
        this.agents.add(agent);
    }

}