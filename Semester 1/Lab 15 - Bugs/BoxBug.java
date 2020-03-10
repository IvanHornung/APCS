import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;


//Hornung
public class BoxBug extends Bug {
    
    private int boxSize, nMoves = 1;
    
    public BoxBug(int r) {
        boxSize = r;
        setColor(Color.RED);
    }

    
    public void act() {
        if( canMove() ) {
            if(nMoves < boxSize){
                move();
                nMoves++;
            } else if(nMoves == boxSize){
                turn();
                turn();
                nMoves = 1;
            } 
        } else {
            doubleTurn();
            nMoves = 1;
        }
    }
    
    
    //Double turn, convention instead of typing "turn();" twice
    public void doubleTurn(){
        turn();
        turn();
    }
}
