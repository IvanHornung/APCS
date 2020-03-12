import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VisualizingAlgorithms extends JPanel implements KeyListener {
    public static final int WIDTH = 1600, HEIGHT = 800;
    public static final int arraySize = 10;
    
    static Bar[] nodes;
    
    public VisualizingAlgorithms() {
        nodes = new Bar[arraySize];
        for(int i = 0; i < nodes.length; i++ ) {
            nodes[i] = new Bar(i);
        }
    }
    
    public void printArray() {
        for(int i = 0; i < nodes.length; i++) {
            
        }
    }

    public void go() {
        //label.setText(score1 + "-" + score2 );
        while( true) {
            //ball.move();
            //playerAI.move(ball.getX(), ball.getY());
            //player.move(ball.getX(), ball.getY());
            try
            {
                Thread.sleep( 5 );
            }
            catch( InterruptedException ex ){}
            repaint();
        }
    }

    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );
        for(int i = 0; i < nodes.length; i++ ) {
            nodes[i].draw(page);
        }
    }

    public void keyReleased( KeyEvent event )
    {
        if(  event.getKeyCode() == KeyEvent.VK_UP )
        {
            //player.setUp(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            //player.setDown(false);
        }
    }

    public void keyPressed( KeyEvent event )
    {
        if(  event.getKeyCode() == KeyEvent.VK_UP ) {
            //player.setUp(true);
            //player.setDown(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            //player.setDown(true);
            //player.setUp(false);
        }
    }

    public void shleep(int ms){
        try
        {
            Thread.sleep( ms );
        }
        catch( InterruptedException ex ){}   
    }

    public void keyTyped( KeyEvent event )
    {}

    public void dirtyWork() {
        setLayout( null );
        setBackground( Color.BLACK );
        Dimension sceneSize = new Dimension( WIDTH, HEIGHT );
        setPreferredSize(sceneSize);
        addKeyListener( this );
        setFocusable( true );
    }
}
