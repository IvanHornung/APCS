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

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for(Boid boid: flock) {
            boid.draw(page);
        }
    }

    public void run() {
        while(true) {
            for(Boid boid : flock){
                boid.flock(flock);
                boid.update();
            }
            try {
                Thread.sleep(5);
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