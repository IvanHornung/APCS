import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;

//Hornung
public class JumperBug extends Bug {
    private boolean jump;
    private Location blc, following, fNext;
    private Flower flwr;

    public JumperBug() {
        setColor(Color.WHITE);
    }

    public void act() {
        if ( canMove() )
            super.move(); //new concept
        else if ( canJump() )
            jump();
        else
            turn();
    }    

    public void jump() {
        Grid<Actor> jumperBug = getGrid();

        if (jumperBug == null)
            return;
            
        locationFunction();
        
        if ( jumperBug.isValid(following) )
            moveTo(fNext);
        else
            removeSelfFromGrid();
            
        flwr = new Flower( getColor() );
        
        flwr.putSelfInGrid(jumperBug, blc);
    }
    
    public boolean canJump() {
        Grid<Actor> jumperBug = getGrid();

        if(jumperBug == null)
            return false;

        locationFunction();

        if (!jumperBug.isValid(fNext))
            return false;

        Actor x = jumperBug.get(fNext);

        return ( x == null || (x instanceof Flower) );
    } 
    
    public void locationFunction(){
        blc = getLocation();
        following = blc.getAdjacentLocation( getDirection() );
        fNext = following.getAdjacentLocation( getDirection() );
    }
}
