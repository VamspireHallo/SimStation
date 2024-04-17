package simstation;
import mvc.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Agent implements Serializable, Runnable{
    protected String name;
    protected Heading heading;
    public int xc;
    protected int yc;
    protected boolean suspended = false;
    protected boolean stopped = false;
    protected Thread myThread;
    protected Simulation sim;



    public Agent(String name) {
        this.name = name;
    }

    public Agent() {
        heading = Heading.random();
        xc = Utilities.rng.nextInt();
        yc = Utilities.rng.nextInt();

    }

    // Setup for operations below
    public void run(){
        myThread = Thread.currentThread();
        while(!stopped) {
            try{
                update();
                Thread.sleep(100);
                isSuspended();

            }
            catch(InterruptedException e){
                Utilities.error(e);
            }
        }
        notify();
    }
    public synchronized void start(){
        myThread = new Thread(this);
        myThread.start();
    }
    public synchronized void suspend(){
        suspended = true;
    }
    private synchronized void isSuspended(){
        try{
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        }
        catch (InterruptedException e) {
            Utilities.error(e);
        }
    }
    public synchronized void resume(){
        suspended = false;
        notify();
    }
    public synchronized void stop(){
        stopped = true;
    }
    public abstract void update();
    public synchronized void move(int steps) {
        switch (heading) {
            case NORTH:
                for (int i = 0; i < steps; i++) {
                    if (yc < 0) {
                        yc = simstation.Simulation.SIZE - 1;
                    } else {
                        yc--;
                    }
                    notify();
                }

            case EAST:
                for (int i = 0; i < steps; i++) {
                    if (xc > simstation.Simulation.SIZE - 1) {
                        xc = 0;
                    } else {
                        xc++;
                    }
                    notify();
                }

            case SOUTH:
                for (int i = 0; i < steps; i++) {
                    if (yc > simstation.Simulation.SIZE - 1) {
                        yc = 0;
                    } else {
                        yc++;
                    }
                    notify();
                }

            case WEST:
                for (int i = 0; i < steps; i++) {
                    if (xc < 0) {
                        xc = simstation.Simulation.SIZE - 1;
                    } else {
                        xc--;
                    }
                    notify();
                }
        }
    }

    public synchronized int getXc() {
        return xc;
    }

    public synchronized int getYc() {
        return yc;
    }


}
