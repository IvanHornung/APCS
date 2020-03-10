//Holm
//Lab 4 - House
//Learn to use the DrawingTool and SketchPad class
//Here's my house, with a little bit of 3D action :)

import gpdraw.*;
import java.awt.Color;
public class Lab4_House
{
    
    private DrawingTool myPencil;
    private SketchPad myPaper;
    
    public Lab4_House()
    {
        myPaper = new SketchPad( 1600, 800 );
        myPencil = new DrawingTool( myPaper );
    }
    
    public void draw()
    {
        //Floor
        myPencil.up();
        myPencil.move (-800,-300);
        myPencil.down();
        myPencil.setDirection(0); //213.7
        myPencil.setWidth(5);
        myPencil.setColor( new Color( 0, 0, 0) );
        myPencil.forward ( 1600 );
        myPencil.up();
        
        //Left Wall
        myPencil.move (-550,-300);
        myPencil.down();
        myPencil.turnRight(90);
        myPencil.forward (300);
        myPencil.up();
        
        //Right Wall
        myPencil.move (550,-300);
        myPencil.down();
        myPencil.turnRight(-105.3);
        myPencil.forward (500);
        myPencil.up();
        
        //Middle Line L
        myPencil.move (-100,-300);
        myPencil.down();
        myPencil.turnRight(127.55);
        myPencil.forward (500);
        myPencil.up();
        
        //Middle Line R
        myPencil.move (200,-300);
        myPencil.down();
        myPencil.turnRight(211);
        myPencil.forward (500);
        myPencil.up();
        
        //Garage Roof Parallel
        myPencil.move (-575,0);
        myPencil.down();
        myPencil.setDirection(0);
        myPencil.forward (475);
        myPencil.up();
        
        //Garage Roof Angle
        myPencil.move (-450,50);
        myPencil.down();
        myPencil.move (-575,0);
        myPencil.forward (30);
        myPencil.up();
        
        //Room Border Above garage
        myPencil.move (-275, 125);
        myPencil.down();
        myPencil.drawRect(350, 150.0);
        myPencil.up();
        
        //Whole Ceiling 
        myPencil.move (-450, 200);
        myPencil.down();
        myPencil.move(200, 200);
        myPencil.up();
        
        //Roof L
        myPencil.move (-450, 200);//(-450, 200);
        myPencil.down();
        myPencil.setWidth(20);
        myPencil.move(115, 350);
        myPencil.up();
        //Roof R
        myPencil.move (550, 200);//(550, 200);
        myPencil.down();
        myPencil.setWidth(20);
        myPencil.move(115, 350);//g
        myPencil.up();
        //Roof Sub
        myPencil.move (200, 200);//(550, 200);
        myPencil.down();
        myPencil.setWidth(20);
        myPencil.move(365, 265);//g
        myPencil.up();
        
        myPencil.setWidth(5);
        //House Entrance Boarder
        myPencil.move (50, -150); //(-90,-300)
        myPencil.down();
        myPencil.drawRect(250, 300);
        myPencil.up();
        
        //House Frame Inner
        myPencil.move (50, -150);
        myPencil.down();
        myPencil.drawRect(150, 250);
        myPencil.up();
        
        //Door Entrance 3D
        myPencil.move (-75,-300);
        myPencil.down();
        myPencil.move (-25,-275);
        myPencil.up();
        //(50, -150);(250, 300)
        myPencil.move (175,-300);
        myPencil.down();
        myPencil.move (125,-275);
        myPencil.up();
        //
        myPencil.move (-25,-25);
        myPencil.down();
        myPencil.move (-75,0);
        myPencil.up();
        //
        myPencil.move (125,-25);                               
        myPencil.down();
        myPencil.move (0,-25);
        myPencil.up();
        //
        myPencil.move (175,0);                               
        myPencil.down();
        myPencil.move (125,-25);
        myPencil.up();
        //House Door
        myPencil.move (50, -200);
        myPencil.setWidth(3);
        myPencil.down();
        myPencil.drawRect(75, 150);
        myPencil.up();
        //House Door Window
        myPencil.move (50, -165);
        myPencil.setWidth(1);
        myPencil.down();
        myPencil.drawRect(40, 40);
        myPencil.up();
        //House Door Frame Horizontal
        myPencil.move (30, -165);
        myPencil.down();
        myPencil.move (70, -165);
        myPencil.up();
        //House Door Frame Vertical
        myPencil.move (50, -185);
        myPencil.down();
        myPencil.move (50, -145);
        myPencil.up();
        
        //Window1
        myPencil.move (375, -150); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(250, 100);
        myPencil.up();
        
        //Window2
        myPencil.move (375, -75); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(250, 100);
        myPencil.up();
        
        //Window3
        myPencil.move (375, 75); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(250, 100);
        myPencil.up();
        
        //Window4
        myPencil.move (50, 90); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(250, 100);
        myPencil.up();
        
        //Window5
        myPencil.move (-275, 125); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(250, 100);
        myPencil.up();
        
        //Garage
        myPencil.move (-325, -172.5); //(-90,-300)
        myPencil.setWidth(5);
        myPencil.down();
        myPencil.drawRect(375, 250);
        myPencil.up();
    }
}
