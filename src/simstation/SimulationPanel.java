package simstation;

import mvc.*;
import javax.swing.*;

public class SimulationPanel extends AppPanel {
    private JButton START, SUSPEND, RESUME, STOP, STATS;

    public SimulationPanel(AppFactory factory) {
        super(factory);

        START = new JButton("Start");
        START.addActionListener(this);
        controlPanels.add(START);
        
        SUSPEND = new JButton("Suspend");
        SUSPEND.addActionListener(this);
        controlPanels.add(SUSPEND);
        
        RESUME = new JButton("Resume");
        RESUME.addActionListener(this);
        controlPanels.add(RESUME);
        
        STOP = new JButton("Stop");
        STOP.addActionListener(this);
        controlPanels.add(STOP);

        STATS = new JButton("Stats");
        STATS.addActionListener(this);
        controlPanels.add(STATS);
    }
}
