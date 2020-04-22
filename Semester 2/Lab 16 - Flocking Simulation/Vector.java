public class Vector {
    double xvalue;
    double yvalue;
    
    public Vector() {
        this.xvalue = Math.random()*1200;
        this.yvalue = Math.random()*600;
    }
    
    public Vector(double xvalue, double yvalue) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
    }
    
    public double getXValue() { return xvalue; }
    public double getYValue() { return yvalue; }
        
    public void setXValue(double newValue) { this.xvalue = newValue; }
    public void setYValue(double newValue) { this.yvalue = newValue; }
    
    void add(Vector parent) {
        this.xvalue += parent.getXValue();
        this.yvalue += parent.getYValue();
    }
}
