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

    public Agent() {
        heading = Heading.parse();
        xc = Utilities.rng.nextInt();
        xy = Utilities.rng.nextInt();

    }

    // Setup for operations below
    public void run(){}
    public void start(){}
    public void suspend(){
        suspended = true;
    }
    public void resume(){
        suspended = false;
    }
    public void stop(){
        stopped = true;
    }
    public abstract void update();
    public void move(int steps){}

}
