import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Boid {
    Vector position;
    Vector velocity;
    Vector acceleration;
    
    public Boid() {
        this.position = new Vector();
        this.velocity = new Vector((double)(Math.random()*10-5),(double)Math.random()*10-5);
        this.acceleration = new Vector();
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)BoidRunner.WIDTH/2, (int)BoidRunner.HEIGHT/2, 10, 10);
    }
    
    void update() {
        this.position.add(this.velocity);
        this.velocity.add(this.acceleration);
    }
}
