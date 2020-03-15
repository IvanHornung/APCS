import java.awt.*;
public class Player
{
    private int x, artiX;
    private int y;
    private int xPreviousB, yPreviousB;
    public static int PLAYER_H = 90;
    public static int PLAYER_W = 15;
    public static int SPEED = 4;
    private Color color;
    private boolean up, down, isRight;

    public Player(boolean iR)
    {
        if (iR) {
            x = Game.WIDTH-50;
            color = Color.BLUE;
        } else {
            x = 50;
            color = Color.RED;
        }
        y = (int)((Game.HEIGHT)/2);
        isRight = iR;
        
        if(Game.gamemode == "Shrunk") {
            PLAYER_H = 25;
            PLAYER_W =10;
        }
        
        artiX = x + PLAYER_W;
        
        xPreviousB = 0;
        yPreviousB = 0;
    }
    

    public void move(int xBall, int yBall)
    {
        if( y <= 0 ) {
            if( down == true )
            {
                y += SPEED;
            }
        }
        else if ( y >= (Game.HEIGHT - PLAYER_H ) ) {
            if( up == true )
            {
                y -= SPEED;
            }
        } else {
            if( up == true )
            {
                y -= SPEED;
            }
            else if( down == true )
            {
                y += SPEED;
            }
        }
        
    } 

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public void setUp( boolean temp )
    {
        up = temp;
    }

    public void setDown( boolean temp )
    {
        down = temp;
    }

    public void changeColor()
    {
        color = new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) );
    }

    public void draw( Graphics page )
    {
        page.setColor( color );
        page.fillRect( x, y, PLAYER_W, PLAYER_H );
    }

    /*        
    if( left == true )
    {
    x = x - 1;
    }
    else if( right == true )
    {
    x = x + 1;
    }
    if( up == true )
    {
    y -= 1;
    }
    else if( down == true )
    {
    y += 1;
    }
     */
}

/**
 * import java.awt.*;
public class Player
{
    private int x, artiX;
    private int y;
    private int xPreviousB, yPreviousB;
    public static final int PLAYER_H = 90;
    public static final int PLAYER_W = 15;
    public static final int SPEED = 4;
    private Color color;
    private boolean up, down, isRight, isBot;

    public Player(boolean iR, boolean isAI)
    {
        if (iR) {
            x = Game.WIDTH-50;
            color = Color.BLUE;
        } else {
            x = 50;
            color = Color.RED;
        }
        y = (int)((Game.HEIGHT)/2);
        isRight = iR;
        isBot = isAI;
        
        artiX = x + PLAYER_W;
        
        xPreviousB = 0;
        yPreviousB = 0;
    }

    public void move(int xBall, int yBall)
    {
        if(isBot) {
            if(xBall < xPreviousB){
                if (this.y > yBall ) {
                    up = true;
                    down = false;
                }
                else if(this.y < yBall) {
                    down = true;
                    up = false;
                }
            }
            xPreviousB = xBall;
            yPreviousB = yBall;
        }

        if( y <= 0 ) {
            if( down == true )
            {
                y += SPEED;
            }
        }
        else if ( y >= (Game.HEIGHT - PLAYER_H ) ) {
            if( up == true )
            {
                y -= SPEED;
            }
        } else {
            if( up == true )
            {
                y -= SPEED;
            }
            else if( down == true )
            {
                y += SPEED;
            }
        }
        
    } 

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public void setUp( boolean temp )
    {
        if(!isBot) up = temp;
    }

    public void setDown( boolean temp )
    {
        if(!isBot) down = temp;
    }

    public void changeColor()
    {
        color = new Color( (int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256) );
    }

    public void draw( Graphics page )
    {
        page.setColor( color );
        page.fillRect( x, y, PLAYER_W, PLAYER_H );
    }

    /*        
    if( left == true )
    {
    x = x - 1;
    }
    else if( right == true )
    {
    x = x + 1;
    }
    if( up == true )
    {
    y -= 1;
    }
    else if( down == true )
    {
    y += 1;
    }
     */
