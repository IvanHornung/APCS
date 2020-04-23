package app;

public class Vector {
    public double xvalue;
    public double yvalue;
    
    public Vector() {
        this.xvalue = Math.random()-0.5;
        this.yvalue = Math.random()-0.5;
    }
    
    public Vector(double xvalue, double yvalue) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
    }
    
    public double getXValue() { return this.xvalue; }
    public double getYValue() { return this.yvalue; }
        
    public void setXValue(double newValue) { this.xvalue = newValue; }
    public void setYValue(double newValue) { this.yvalue = newValue; }
    
    void add(Vector parent) {
        this.xvalue += parent.getXValue();
        this.yvalue += parent.getYValue();
    }

    void subtract(Vector parent) {
        this.xvalue -= parent.getXValue();
        this.yvalue -= parent.getYValue();
    }

    void divide(double denominator) {
        this.xvalue /= denominator;
        this.yvalue /= denominator;
    }
}