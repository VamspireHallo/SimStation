package simstation;
import mvc.*;
import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable{
    protected String name;
    protected Heading heading;
    protected int xc;
    protected int yc;
    protected boolean suspended = false;
    protected boolean stopped = false;
    protected Thread myThread;

    public Agent(String name) {
        this.name = name;
    }

    // Setup for operations below
    public void run(){}
    public void start(){}
    public void suspend(){}
    public void resume(){}
    public void stop(){}
    public abstract void update();
    public void move(int steps){}

}
