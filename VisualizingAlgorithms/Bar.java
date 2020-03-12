import java.awt.*;
public class Bar {
    private int size;
    private int width;
    private Color color;
    private int x, y;
    
    public Bar(int s){
        size = (s+1)*10;
        width = (int)(VisualizingAlgorithms.WIDTH/VisualizingAlgorithms.nodes.length);
        color = new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) );
        
        x = (int)((VisualizingAlgorithms.WIDTH*s)/VisualizingAlgorithms.nodes.length);
        y = (int)(VisualizingAlgorithms.HEIGHT/2);
    }
    
    public void setCoord(int x) {
    }
    
    public int getSize() {
        return size;
    }
    
     public void draw( Graphics page )
    {
        page.setColor( color );
        page.fillRect( x, y, width, size );
    }
}
