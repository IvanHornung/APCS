package app;

import java.awt.*;
import java.util.ArrayList;

public class Boid {
    Vector position;
    Vector velocity;
    Vector acceleration;
    double maxForce = 1;
    
    public Boid() {
        this.position = new Vector((double)(Math.random()*BoidRunner.WIDTH),(double)(Math.random()*BoidRunner.HEIGHT));
        double angle = Math.random()*360;
        double radius = Math.random()*2+2; //2-4
        this.velocity = new Vector((radius * Math.cos(angle)), (radius * Math.sin(angle)));
        this.acceleration = new Vector(0,0);
    }

    Vector align(ArrayList<Boid> flock) {
        int perceptionRadius = 50;
        int total = 0;
        Vector steering = new Vector(0,0);
        for(Boid boid : flock) {
            double dist = distance(this.position.xvalue, this.position.yvalue, boid.position.xvalue, boid.position.yvalue);
            if(boid != this && dist < perceptionRadius) {
                steering.add(boid.velocity);
                total++;
            }
        }
        if(total > 0) {
            steering.divide((double)total);
            steering.subtract(this.velocity);
            steering.limit(this.maxForce);
        }
        return steering;
    }

    void flock(ArrayList<Boid> flock) {
        Vector alignment = this.align(flock);
        this.acceleration = alignment;
    }

    
    void update() {
        this.position.add(this.velocity);
        this.velocity.add(this.acceleration);
    }

    void edges() {
        if(this.position.xvalue > BoidRunner.WIDTH)
            this.position.xvalue = 0;
        else if(this.position.xvalue < 0)
            this.position.xvalue = BoidRunner.WIDTH;
        
        if(this.position.yvalue > BoidRunner.HEIGHT)
            this.position.yvalue = 0;
        else if(this.position.yvalue < 0)
            this.position.yvalue = BoidRunner.HEIGHT;
    }

    double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int)this.position.getXValue(),(int)this.position.getYValue(), 15, 15);
    }
}