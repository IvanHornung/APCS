package app;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BoidRunner extends JPanel {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    ArrayList<Boid> flock = new ArrayList<Boid>();

    public BoidRunner() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        
        for(int i = 0; i < 200; i++)
            flock.add(new Boid());

    }

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        Graphics2D g = (Graphics2D) page;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(Boid boid: flock) {
            boid.draw(g);
        }
    }

    public void run() {
        while(true) {
            for(Boid boid : flock){
                boid.edges();
                boid.flock(flock);
                boid.update();
            }
            try {
                Thread.sleep(10);
            } catch( InterruptedException ex ){}
            this.repaint();
        }
    }

    void labelConfigure(JLabel label) {
        //labelConfigure(new JLabel("(" + boid.position.getXValue() + ", " + boid.position.getYValue() +")"));
        this.setLayout(new FlowLayout());
        this.add(label);
        label.setFont(new Font("Courier New", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setVisible(true);
        label.setVisible(false);
    }

}