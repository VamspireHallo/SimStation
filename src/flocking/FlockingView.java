package flocking;

import mvc.*;
import plague.Host;
import plague.PlagueSimulation;
import simstation.*;

import java.awt.*;

public class FlockingView extends SimulationView {
    public FlockingView(Model model) {
        super(model);
    }
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        gc.setColor(Color.WHITE);
        setBackground(Color.WHITE);
    }
}
