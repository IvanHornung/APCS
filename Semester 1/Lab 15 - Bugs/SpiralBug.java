import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;

//Hornung
public class SpiralBug extends Bug {
    
    public SpiralBug(){
        setColor(Color.BLUE);
    }

    public boolean canMove() {
        Grid<Actor> gr = getGrid();
        
        if( gr == null )
            return false;
            
        Location lc = getLocation();
        Location n = lc.getAdjacentLocation(getDirection());
        
        if( !gr.isValid(n) )
            return false;
            
        Actor nbor = gr.get(n);
        
        return( nbor == null );
    }
}
