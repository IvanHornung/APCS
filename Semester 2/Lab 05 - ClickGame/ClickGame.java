import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClickGame extends JPanel implements MouseListener, MouseMotionListener  {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;
    private JLabel label;
    private int timer = 0;
    private ArrayList<Boid> flock = new ArrayList<Boid>();
    public static int score = 0;

    ///VELOCITY VECTOR
    ///ACCELERATION VECTOR

    //constructor - sets the initial conditions for this Game object
    public ClickGame()
    {
        //make a panel with dimensions WIDTH by HEIGHT with a blue background
        this.setLayout( null );//Don't change
        this.setBackground( new Color(255,248,220) );
        this.setPreferredSize( new Dimension( WIDTH, HEIGHT ) );//Don't change

        //create and format a JLabel to display a timer
        label = new JLabel( "Time: " + 0 );
        this.add( label );
        label.setVisible( true );
        label.setFont( new Font( "Arial", Font.BOLD, 30 ) );
        label.setBounds( 400, 30, 200, 30 );
        label.setHorizontalAlignment( SwingConstants.CENTER );
        label.setForeground( Color.BLACK );

        this.addMouseListener(this);

        this.setFocusable(true);//I'll tell you later - Don't change

        for(int i = 0; i < 20; i++) {
            flock.add(new Boid());
        }
    }

    //This is the method that runs the game
    public void playGame()
    {
        boolean over = false;
        while( !over ) {
            for(Boid b: flock) {
                b.move();
                if(b.getXPos() > WIDTH) {
                    label.setText( "Time: " + timer/1000 +"." +timer%1000 + "s");
                    over = true;
                    return;
                }
            }
            try {
                Thread.sleep( 25 );//pause for 10 milliseconds
                timer += 10;
                if(timer % 250 == 0 )flock.add(new Boid());
                if(timer >= 4000) {
                    if(timer % 250 == 0 ) {
                        flock.add(new Boid());
                    }
                    if(timer >= 6000) {
                        if(timer % 250 == 0 ) {
                            flock.add(new Boid());
                        }
                        if(timer >= 7000) {
                            if(timer % 250 == 0 ) {
                                flock.add(new Boid());
                            }
                            if(timer >= 7500) {
                                if(timer % 250 == 0 ) {
                                    flock.add(new Boid());
                                }
                            } if(timer >= 8000) {
                                if(timer % 250 == 0 ) {
                                    flock.add(new Boid());
                                }
                            }
                        }
                    }
                    if(timer >= 10000 ) {
                        label.setText( "You win, you survived for 10 seconds!");
                        over = true;
                        return;
                    }
                }
                label.setText( "Time: " + timer/1000 +"." +timer%1000 + "s");
                //label.setText( /*"Time: " + timer/1000 +"." +timer%1000*/  "\tScore:" + score);
            }catch( InterruptedException ex ){}
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
    }

    //Precondition: executed when repaint or paintImmediately is called
    //Postcondition: the screen has been updated
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );
        for(Boid b: flock) {
            b.draw(page);
        }
        //for(int i = 0; i < flock.size(); i ++) {
        //  flock.get(i).draw(page);
        //}
    }

    //this method is called whenever the mouse button is pressed
    public void mousePressed( MouseEvent event )
    {
        int mouseX = event.getX(); //returns the x coordinate of the cursor when the mouse is clicked
        int mouseY = event.getY(); //returns the y coordinate of the cursor when the mouse is clicked

        for(int i = 0; i < flock.size(); i++ ) {
            if(Math.abs(mouseX-flock.get(i).getXPos()) <= (int)(flock.get(i).getWidth()) && Math.abs(mouseY-flock.get(i).getYPos()) <= (int)(flock.get(i).getHeight()) ) {
                flock.remove(i);
                i--;
                new Sound("Hit");
                score += 5;
                return;
            }
        }
        score -= 3;
        if(score < 0) score += Math.abs(score);
        new Sound("Miss");
    }

    /*public void keyReleased( KeyEvent event )
    {
    if(event.getKeyCode() == KeyEvent.VK_W ) {
    testing.setUp(false);
    }
    if(event.getKeyCode() == KeyEvent.VK_S ) {
    testing.setDown(false);
    }
    }
    public void keyPressed( KeyEvent event )
    {
    if(event.getKeyCode() == KeyEvent.VK_W ) {
    testing.setUp(true);
    testing.setDown(false);
    }
    if(event.getKeyCode() == KeyEvent.VK_S ) {
    testing.setDown(true);
    testing.setUp(false);
    }
    }*/

    //required for compiling; do not use
    public void mouseClicked( MouseEvent event )
    {}
    //required for compiling; do not use
    public void mouseReleased( MouseEvent event )
    {}
    //required for compiling; do not use
    public void mouseEntered( MouseEvent event )
    {}
    //required for compiling; do not use
    public void mouseExited( MouseEvent event )
    {}
    private int moveX, moveY;
    // MouseMotionListener Stuff: constantly update whenver mouse is moved
    public void mouseMoved(MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }

    public void mouseDragged(MouseEvent event) {
        moveX = event.getX();
        moveY = event.getY();
    }
}
