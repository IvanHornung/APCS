import javax.swing.*;
import java.awt.*;
public class ClickDriver
{
    public static void main( String[] args )
    {
        //create a JFrame (window) that will be visible on screen
        JFrame frame = new JFrame( "THE BOUNCING" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //make the red close button work
        frame.setLocation( 0, 0 ); //place the frame in the upper left corner
        ClickGame game = new ClickGame(); //create a Game object
        frame.add(game); //add game to the frame so it will be on the screen
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        game.playGame();//call the playGame() method to intitiate the game
    }
}
