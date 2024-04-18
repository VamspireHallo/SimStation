package flocking;

import mvc.*;
import plague.*;
import simstation.*;

import java.awt.*;

public class FlockingView extends SimulationView {
    public FlockingView(Model model) {
        super(model);
    }
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        setBG(Color.DARK_GRAY);
    }
}
