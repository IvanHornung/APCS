import java.awt.*;
public class Ball
{
    private int x;
    private int y;
    private int size;
    public int speed, vx, vy;
    private Color color;
    private boolean isG2;
    private Player player, playerL;
    private AIPlayer playerAI;
    private int score1, score2;
    private Game game;
    private TwoGame game2;
    int hitCount;

    public Ball(AIPlayer p1, Player p2, Game g, boolean player1Turn) {
        size = 15;
        x = (int) ((Game.WIDTH) / 2); // ( Math.random()*(Game.WIDTH-size) );
        y = (int) ((Game.HEIGHT) / 2); // ( Math.random()*(Game.HEIGHT-size) );
        color = Color.WHITE;
        if (Game.gamemode == "Multiball")
            color = new Color(255, 204, 153);
        if (Game.gamemode != "Accelerating")
            speed = 3; // (int)( Math.random()*5)+1;
        else {
            speed = 1;
        }

        int trajectoryY = (int) (Math.random() * 2);
        vx = speed;
        vy = speed;
        if (player1Turn)
            vx *= -1;
        if (trajectoryY == 1)
            vy *= -1;

        playerAI = p1;
        player = p2;
        game = g;
        isG2 = false;
    }

    public Ball(Player p1, Player p2, TwoGame g, boolean player1Turn) {
        size = 15;
        x = (int) ((TwoGame.WIDTH) / 2); // ( Math.random()*(Game.WIDTH-size) );
        y = (int) ((TwoGame.HEIGHT) / 2); // ( Math.random()*(Game.HEIGHT-size) );
        color = Color.WHITE;
        if (Game.gamemode == "Multiball")
            color = new Color(255, 204, 153);
        if (TwoGame.gamemode != "Accelerating")
            speed = 3; // (int)( Math.random()*5)+1;
        else {
            speed = 1;
        }

        int trajectoryY = (int) (Math.random() * 2);
        vx = speed;
        vy = speed;
        if (player1Turn)
            vx *= -1;
        if (trajectoryY == 1)
            vy *= -1;

        playerL = p1;
        player = p2;
        game2 = g;
        isG2 = true;
    }

    public void move() {
        x += vx;
        y += vy;
        if (!isG2) {
            if (x <= 0) {
                game.yayScore(false);
                new Sound("Score");
                return;
            }
            if (x >= Game.WIDTH) {
                game.yayScore(true);
                new Sound("Score");
                return;
            }
            if (vx > 0) {
                if ((x + size) >= player.getXPos() && (x + size) <= (player.getXPos() + Player.PLAYER_W)
                        && y >= player.getYPos() && y <= (player.getYPos() + Player.PLAYER_H)) {
                    vx *= -1;
                    new Sound("PlayerHit");
                    hitCount++;
                    if (Game.gamemode == "50CC")
                        player.changeColor();

                    if (hitCount == 2) {
                        increaseSpeed();
                    } else if (hitCount >= 4 && hitCount < 6) {
                        increaseSpeed();
                    } else if (hitCount >= 6 && hitCount < 12) {
                        increaseSpeed();
                    } else if (hitCount >= 12) {
                        increaseSpeed();
                    }
                }
            } else {
                if (x >= playerAI.getXPos() && x <= (playerAI.getXPos() + AIPlayer.PLAYER_W) && y >= playerAI.getYPos()
                        && y <= (playerAI.getYPos() + AIPlayer.PLAYER_H)) {
                    vx *= -1;
                    new Sound("PlayerHit");
                    hitCount++;
                    if (Game.gamemode == "50CC")
                        playerAI.changeColor();

                    if (hitCount == 2) {
                        increaseSpeed();
                    } else if (hitCount >= 4 && hitCount < 6) {
                        increaseSpeed();
                    } else if (hitCount >= 6 && hitCount < 12) {
                        increaseSpeed();
                    } else if (hitCount >= 12) {
                        increaseSpeed();
                    }
                }
            }
            if (y <= 0 || y >= (Game.HEIGHT - size)) {
                vy *= -1;
                new Sound("WallHit");
            }
        }
        /////////////////////////////// Two-Player//////////////////////////
        else {
            if (x <= 0) {
                game2.yayScore(false);
                new Sound("Score");
                return;
            }
            if (x >= TwoGame.WIDTH) {
                game2.yayScore(true);
                new Sound("Score");
                return;
            }
            if (vx > 0) {
                if ((x + size) >= player.getXPos() && (x + size) <= (player.getXPos() + Player.PLAYER_W)
                        && y >= player.getYPos() && y <= (player.getYPos() + Player.PLAYER_H)) {
                    vx *= -1;
                    new Sound("PlayerHit");
                    hitCount++;
                    if (TwoGame.gamemode == "50CC")
                        player.changeColor();

                    if (hitCount == 2) {
                        increaseSpeed();
                    } else if (hitCount >= 4 && hitCount < 6) {
                        increaseSpeed();
                    } else if (hitCount >= 6 && hitCount < 12) {
                        increaseSpeed();
                    } else if (hitCount >= 12) {
                        increaseSpeed();
                    }
                }
            } else {
                if (x >= playerL.getXPos() && x <= (playerL.getXPos() + Player.PLAYER_W) && y >= playerL.getYPos()
                        && y <= (playerL.getYPos() + Player.PLAYER_H)) {
                    vx *= -1;
                    new Sound("PlayerHit");
                    hitCount++;
                    if (TwoGame.gamemode == "50CC")
                        playerL.changeColor();

                    if (hitCount == 2) {
                        increaseSpeed();
                    } else if (hitCount >= 4 && hitCount < 6) {
                        increaseSpeed();
                    } else if (hitCount >= 6 && hitCount < 12) {
                        increaseSpeed();
                    } else if (hitCount >= 12) {
                        increaseSpeed();
                    }
                }
            }
            if (y <= 0 || y >= (TwoGame.HEIGHT - size)) {
                vy *= -1;
                new Sound("WallHit");
            }
        }

    }

    public void increaseSpeed() {
        if (vx < 0) {
            vx = Math.abs(vx) + 1;
            vx *= -1;
        } else
            vx++;
        if (vy < 0) {
            vy = Math.abs(vx) + 1;
            vy *= -1;
        } else
            vy++;
    }

    public void decreaseSpeed() {
        if (vx < 0) {
            vx = Math.abs(vx) - 1;
            vx *= -1;
        } else
            vx--;
        if (vy < 0) {
            vy = Math.abs(vx) - 1;
            vy *= -1;
        } else
            vy--;
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
