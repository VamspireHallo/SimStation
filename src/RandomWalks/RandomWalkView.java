package RandomWalks;

import mvc.*;
import simstation.*;

import java.awt.*;

public class RandomWalkView extends SimulationView {
    public RandomWalkView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        setBG(Color.DARK_GRAY);
    }
}
