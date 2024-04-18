package simstation;

import mvc.*;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {

    protected String name;
    protected Heading heading;
    protected int xc;
    protected int yc;
    protected boolean suspended;
    protected boolean stopped;
    protected Thread myThread;
    protected Simulation sim;

    private static final int SLEEP_MS = 25;

    public Agent(String name) {
        this.name = name;
    }

    public Agent() {
        //super();
        suspended = false;
        stopped = false;
        myThread = null;

        // randomly initialize position and heading
        heading = Heading.random();
        xc = Utilities.rng.nextInt(Simulation.SIZE);
        yc = Utilities.rng.nextInt(Simulation.SIZE);
    }

    @Override
    public void run() {
        myThread = Thread.currentThread();
        onStart();
        while (!stopped) {
            try {
                update();
                Thread.sleep(SLEEP_MS);
                checkSuspended();
            } catch (InterruptedException e) {
                Utilities.error(e);
            }
        }
        onExit();
        sim.changed();
    }

    public synchronized void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        suspended = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public abstract void update(); // child classes should flush this out

    public synchronized void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (heading) {
                case NORTH:
                    yc = (yc - 1 + Simulation.SIZE) % Simulation.SIZE; // Move north (decrease y-coordinate)
                    break;
                case SOUTH:
                    yc = (yc + 1) % Simulation.SIZE; // Move south (increase y-coordinate)
                    break;
                case EAST:
                    xc = (xc + 1) % Simulation.SIZE; // Move east (increase x-coordinate)
                    break;
                case WEST:
                    xc = (xc - 1 + Simulation.SIZE) % Simulation.SIZE; // Move west (decrease x-coordinate)
                    break;
            }

            if (sim != null) {
                sim.changed(); // Notify simulation of changes
            }
        }
    }

    public void setWorld(Simulation world) {
        this.sim = world;
    }

    public void onStart() {
    }

    public void onInterrupted() {
    }

    public void onExit() {
    }

    private synchronized void checkSuspended() {
        try {
            while (!stopped && suspended) {
                onInterrupted();
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            Utilities.error(e);
        }
    }

    public synchronized double getXc() {
        return xc;
    }

    public synchronized double getYc() {
        return yc;
    }
}
