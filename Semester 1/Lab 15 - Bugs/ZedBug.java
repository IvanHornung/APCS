import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;

//Hornung
public class ZedBug extends Bug {
    
    private int bugSize, nMoves = 1;
    private boolean up = true, down = false;
    
    public ZedBug(int r) {
        bugSize = r;
        setColor(Color.GREEN);
    }

    public void act() {
        if (canMove() && nMoves < bugSize) {
            move();
            nMoves++; 
        } else {
            doubleT();
            turn();
            if(up) {
                up = false;
                down = true;
            } else if(down) {
                doubleT();
                up = false;
                down = false;
            } else {
                turn();
                up = true;
                down = true;
            } 
            nMoves = 1;
        }
    } 
    
    public void doubleT(){
        turn();
        turn();
    }
}
