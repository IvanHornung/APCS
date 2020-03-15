import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener
{
    private Ball ball, ball2;
    private Player player;
    private AIPlayer playerAI;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private int score1, score2;
    private Sound classic;
    private JLabel label, scoreLabel, timeLabel;
    public static String gamemode;
    private Sound main;
    private int scoreRange = 5;
    private boolean isMB = false;

    public Game(int gameMode)
    {

        if(gameMode >= 25 && gameMode < 30) {//gameMode < 30
            gamemode = "Shrunk";
            main = new Sound("Classic");
        }

        if(gameMode >= 30 && gameMode < 35) {//gameMode < 30
            gamemode = "Impossible";
            main = new Sound("Accelerating");
        }

        if(gameMode >= 40 && gameMode <= 45) {//gameMode < 30
            gamemode = "Multiball";
            main = new Sound("Multiball");
            isMB = true;
        }
        playerAI = new AIPlayer(false);
        player = new Player(true);

        ball = new Ball(playerAI, player, this, false);
        if(isMB) ball2 = new Ball(playerAI, player, this, false);

        score1 = 0;
        score2 = 0;

        if(gameMode < 10 ) { //gameMode < 15
            main = new Sound("Classic");
            gamemode = "Classic";
        } else if(gameMode >= 10 && gameMode < 15 ) {//gameMode >= 15 
            gamemode = "NextPoint";
            score1 = 4;
            score2 = 4;
            main = new Sound("Upbeat");
        } else if(gameMode >= 15 && gameMode < 20) {
            gamemode = "Accelerating";
            main = new Sound("Accelerating");
        } else if(gameMode >= 20 && gameMode < 25) {
            gamemode = "Seizure";
            main = new Sound("Upbeat");
        } else if(gameMode >= 35 && gameMode < 40){
            gamemode = "50CC";
            main = new Sound("Classic");
        }

        setLayout( null );
        setBackground( Color.BLACK );
        Dimension sceneSize = new Dimension( WIDTH, HEIGHT );
        setPreferredSize(sceneSize);

        addKeyListener( this );
        setFocusable( true );

        label = new JLabel(score1 + "-" + score2);
        this.setLayout(new FlowLayout());
        this.add(label);
        label.setFont(new Font("Courier New", Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        label.setVisible(true);

        scoreLabel = new JLabel("");
        this.add(scoreLabel,BorderLayout.CENTER);
        this.add(scoreLabel);
        scoreLabel.setFont(new Font("Courier New", Font.PLAIN, 50));
        scoreLabel.setForeground(Color.WHITE);

    }

    public void go()
    {
        intro();
        shleep();
        label.setText(score1 + "-" + score2 );
        if(gamemode == "50CC") scoreRange = 50;
        while( score1 < scoreRange && score2 < scoreRange)
        {
            if(gamemode == "Seizure") seizurism();
            ball.move();
            if(isMB) ball2.move();
            playerAI.move(ball.getX(), ball.getY());
            player.move(ball.getX(), ball.getY());
            try
            {
                Thread.sleep( 5 );
            }
            catch( InterruptedException ex ){}
            repaint();
        }
        main.stopSong();
        label.setVisible(false);

        if(score1 >= scoreRange ) {
            scoreLabel.setText("AI Is Superior");
            new Sound("AIWin");
        } else if(score2 >= scoreRange ) {
            scoreLabel.setText("YOU WIN!");
            new Sound("PlayerWin");
        }
        scoreLabel.setVisible(true);
    }

    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );
        ball.draw( page );
        if(isMB) ball2.draw(page);
        playerAI.draw( page );
        player.draw( page );
    }

    public void keyReleased( KeyEvent event )
    {
        if(  event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(false);
        }
        if(event.getKeyCode() == KeyEvent.VK_W ) {
            playerAI.setUp(false);
        }
        if(event.getKeyCode() == KeyEvent.VK_S ) {
            playerAI.setDown(false);
        }

        if(event.getKeyCode() == KeyEvent.VK_C) {
            playerAI.changeColor();
        }

        if(event.getKeyCode() == KeyEvent.VK_M) {
            main.stopSong();
        }

        if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            if (ball.vx < 0 ){
                ball.vx = Math.abs(ball.vx) + 1;
                ball.vx *= -1;
            } else ball.vx++;
            if (ball.vy < 0 ){
                ball.vy = Math.abs(ball.vx) + 1;
                ball.vy *= -1;
            } else ball.vy++;
        }
        
        if(event.getKeyCode() == KeyEvent.VK_O) {
            if (ball.vx < 0 ){
                ball.vx = Math.abs(ball.vx) - 1;
                ball.vx *= -1;
            } else ball.vx--;
            if (ball.vy < 0 ){
                ball.vy = Math.abs(ball.vx) - 1;
                ball.vy *= -1;
            } else ball.vy--;
        }

        if(event.getKeyCode() == KeyEvent.VK_P) {
            shleep();
            shleep();
            shleep();
        }
    }

    public void keyPressed( KeyEvent event )
    {
        if(  event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(true);
            player.setDown(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(true);
            player.setUp(false);
        }
        if(event.getKeyCode() == KeyEvent.VK_W ) {
            playerAI.setUp(true);
            playerAI.setDown(false);
        }
        if(event.getKeyCode() == KeyEvent.VK_S ) {
            playerAI.setDown(true);
            playerAI.setUp(false);
        }
        if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void increaseSpeed (){
        if (ball.vx < 0 ){
            ball.vx = Math.abs(ball.vx) + 1;
            ball.vx *= -1;
        } else ball.vx++;
        if (ball.vy < 0 ){
            ball.vy = Math.abs(ball.vx) + 1;
            ball.vy *= -1;
        } else ball.vy++;
    }

    public void decreaseSpeed() {
        if (ball.vx < 0 ){
            ball.vx = Math.abs(ball.vx) - 1;
            ball.vx *= -1;
        } else ball.vx--;
        if (ball.vy < 0 ){
            ball.vy = Math.abs(ball.vx) - 1;
            ball.vy *= -1;
        } else ball.vy--;
    }

    public void yayScore(boolean playerOneScored){
        if(playerOneScored) 
            score1++;
        else
            score2++;

        label.setText(score1 + "-" + score2);

        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException ex ){}        
        ball = new Ball(playerAI, player, this, playerOneScored);
        if(isMB) ball2 = new Ball(playerAI, player, this, playerOneScored);
    }

    public void shleep(){
        for( int i = 4; i >= 0; i--) {
            label.setText(""+ i);
            try
            {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException ex ){}   
        }
    }

    public void intro(){
        if(gamemode == "Classic") label.setText("Gamemode: Classic!");
        else if (gamemode == "Shrunk") label.setText("Gamemode: Shrunk!");
        else if (gamemode == "Impossible") label.setText("Gamemode: Impossible!");
        else if(gamemode == "50CC") label.setText("Gamemode: First to 50!");
        else if(gamemode == "NextPoint") label.setText("Gamemode: Sudden Death!");
        else if (gamemode == "Accelerating") label.setText("Gamemode: Accelerating!");
        else if(gamemode == "Multiball") label.setText("Gamemode: Ballsack");
        else if(gamemode == "Seizure") label.setText("Gamemode: Seizure!");
        else label.setText("An error occurred.");
        try
        {
            Thread.sleep( 3000 );
        }
        catch( InterruptedException ex ){}
    }

    public void seizurism(){
        playerAI.changeColor();
        player.changeColor();
        ball.changeColor();
        setBackground(new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) ));
    }

    public void keyTyped( KeyEvent event )
    {}

}
