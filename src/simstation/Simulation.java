package simstation;

import java.util.*;
import mvc.*;

public abstract class Simulation extends Model {

    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    public final static int SIZE = 200;
    public List<Agent> agents = new ArrayList<>();
    private int width = 400;
    private int height = 400;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    // etc.
    public void start() {
        stop();
        startTimer();
        populate();
        for (var agent : agents) {
            new Thread(agent).start();
        }
        changed();
    }
    public void suspend() {
        for (Agent a : agents) {
            a.suspend();
        }
        stopTimer();
        changed();
    }
    public void resume() {
        for (Agent a : agents) {
            a.resume();
        }
        startTimer();
        changed();
    }
    public void stop() {
        for (Agent a : agents) {
            a.stop();
        }
        agents.clear();
        changed();
    }
    public abstract String[] stats();

    public abstract void populate();

    public Agent getNeighbor(Agent agent, double radius) {
        for (int agentsSize = agents.size(), i = Utilities.rng.nextInt(0, agentsSize);
             i < agentsSize;
             i = (i + 1) % agentsSize) {

            Agent a = agents.get(i);
            int deltaX = agent.getXc() - a.getXc();
            int deltaY = agent.getYc() - a.getYc();
            int distSq = deltaX * deltaX + deltaY * deltaY;
            if (distSq <= (radius*radius)) {
                return a;
            }
        }
        return null;
    }
    protected void addAgent(Agent agent) {
        agent.setSim(this);
        this.agents.add(agent);
    }
    public void addAgent(Agent agent)
    {
        this.agents.add(agent);
    }

    public List<Agent> getAgents() {
        return agents;
    }
}