package app;

import java.awt.*;
import java.util.ArrayList;

public class Boid {
    Vector position;
    Vector velocity;
    Vector acceleration;
    
    public Boid() {
        this.position = new Vector((double)BoidRunner.WIDTH/2,(double)BoidRunner.HEIGHT/2);
        this.velocity = new Vector();
        this.acceleration = new Vector();
    }

    void align(ArrayList<Boid> flock) {
        int perception = 100;
        Vector average = new Vector(0,0);
        for(Boid boid : flock) {
            double dist = distance(this.position.xvalue, this.position.yvalue, boid.position.xvalue, boid.position.yvalue);
            average.add(boid.velocity);
        }
        average.divide((double)flock.size());
    }


    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)this.position.getXValue(),(int)this.position.getYValue(), 30, 30);
    }
    
    void update() {
        this.position.add(this.velocity);
        this.velocity.add(this.acceleration);
    }

    double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }
}