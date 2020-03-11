import javax.swing.*;
import java.awt.*;

public class GameDriver
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "BabyGame" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLocation( 0, 0 );
        
        int randomNumber = (int)(Math.random()*39 + 1);
        Game game = new Game(randomNumber);
        frame.getContentPane().add( game );
        frame.pack();
        frame.setVisible( true );
        game.go();
    }
}
