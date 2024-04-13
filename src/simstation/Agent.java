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
    }
    public synchronized void stop(){
        stopped = true;
    }
    public abstract void update();
    public synchronized void move(int steps){

    }

}
