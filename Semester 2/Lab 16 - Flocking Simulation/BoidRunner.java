import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        for(Boid boid: flock) {
            boid.update();
            boid.draw(page);
        }
    }

    public void run() {
        for(int i = 0; i < 1; i++) {
            flock.add(new Boid());
        }
        while(true) {
            for(Boid boid : flock){
                boid.position.xvalue++;
                boid.position.yvalue++;
                try {
                    Thread.sleep( 5 );
                } catch( InterruptedException ex ){}
            }
            repaint();
        }
    }
}
