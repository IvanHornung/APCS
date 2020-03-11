import java.awt.*;
public class Ball
{
    private int x;
    private int y;
    private int size;
    public static int speed, vx, vy;
    private Color color;
    private boolean left, right, up, down;
    private Player player;
    private AIPlayer playerAI;
    private int score1, score2;
    private Game game;
    int hitCount;

    public Ball(AIPlayer p1, Player p2, Game g, boolean player1Turn)
    {
        size = 15;
        x = (int)((Game.WIDTH)/2);  //( Math.random()*(Game.WIDTH-size) );
        y = (int)((Game.HEIGHT)/2); //( Math.random()*(Game.HEIGHT-size) );
        color = Color.WHITE;
        if(Game.gamemode != "Accelerating") speed = 3; //(int)( Math.random()*5)+1;
        else {
            speed = 1;
        }

        int trajectoryY = (int)(Math.random() * 2 );
        vx=speed; vy = speed;
        if(player1Turn) vx *= -1;
        if(trajectoryY == 1 ) vy *= -1;

        playerAI = p1;
        player = p2;
        game = g;
    }

    public void move()
    {

        x += vx;
        y += vy;

        if(x <= 0 ) {
            game.yayScore(false);
            new Sound("Score");
            return;
        }
        if ( x >= Game.WIDTH){
            game.yayScore(true);
            new Sound("Score");
            return;
        }
        if( vx > 0 ) {
            if( (x + size ) >= player.getXPos() &&  (x + size) <= (player.getXPos() + Player.PLAYER_W) && y >= player.getYPos() && y <= (player.getYPos() + Player.PLAYER_H)) {
                vx *= -1;
                new Sound("PlayerHit");
                hitCount++;
                if(Game.gamemode == "50CC") player.changeColor();

                if (hitCount == 2 ) {
                    increaseSpeed();
                }
                else if (hitCount >= 4 && hitCount < 6) {
                    increaseSpeed();
                }
                else if (hitCount >= 6 && hitCount < 12) {
                    increaseSpeed();
                }
                else if (hitCount >= 12) {
                    increaseSpeed();
                }
            }
        }
        else {
            if(x >= playerAI.getXPos() && x <= (playerAI.getXPos() + AIPlayer.PLAYER_W) && y >= playerAI.getYPos() && y <= (playerAI.getYPos() + AIPlayer.PLAYER_H)) {
                vx *= -1;
                new Sound("PlayerHit");
                hitCount++;
                if(Game.gamemode == "50CC") playerAI.changeColor();

                if (hitCount == 2 ) {
                    increaseSpeed();
                }
                else if (hitCount >= 4 && hitCount < 6) {
                    increaseSpeed();
                }
                else if (hitCount >= 6 && hitCount < 12) {
                    increaseSpeed();
                }
                else if (hitCount >= 12) {
                    increaseSpeed();
                }
            }
        }
        if(y <= 0 || y >= (Game.HEIGHT-size) ) {
            vy *= -1;
            new Sound("WallHit");
        }

    }

    public void increaseSpeed(){
        if (vx < 0 ){
            vx = Math.abs(vx) + 1;
            vx *= -1;
        } else vx++;
        if (vy < 0 ){
            vy = Math.abs(vx) + 1;
            vy *= -1;
        } else vy++;
    }

    public void decreaseSpeed() {
        if (vx < 0 ){
            vx = Math.abs(vx) - 1;
            vx *= -1;
        } else vx--;
        if (vy < 0 ){
            vy = Math.abs(vx) - 1;
            vy *= -1;
        } else vy--;
    }

    public void setLeft( boolean temp )
    {
        left = temp;
    }

    public void setRight( boolean temp )
    {
        right = temp;
    }

    public void setUp( boolean temp )
    {
        up = temp;
    }

    public void setDown( boolean temp )
    {
        down = temp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeColor()
    {
        color = new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) );
    }

    public void draw( Graphics page )
    {
        page.setColor( color );
        page.fillOval( x, y, size, size );
    }
}
