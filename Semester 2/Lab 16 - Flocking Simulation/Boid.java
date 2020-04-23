import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Boid {
    Vector position;
    Vector velocity;
    Vector acceleration;
    
    public Boid() {
        this.position = new Vector((double)BoidRunner.WIDTH/2,(double)BoidRunner.HEIGHT/2);
        this.velocity = new Vector();
        this.acceleration = new Vector();
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)this.position.getXValue(),(int)this.position.getYValue(), 30, 30);
    }
    
    void update() {
        this.position.addVector(this.velocity);
        this.velocity.addVector(this.acceleration);
    }
}