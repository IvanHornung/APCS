import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;

//Hornung
public class StalkerBug extends Bug {
    private Bug victim;

    public StalkerBug(Bug v) {
        victim = v;
        setColor(Color.BLACK);
    }

    public void act() {
        Grid<Actor> stalkerBug = getGrid();

        Location location = getLocation();
        Location victimLocation = victim.getLocation();
        
        int angle = location.getDirectionToward(victimLocation);

        if( !canMove() )
            turn();
        else if ( angle == 0 ) {
            setDirection( Location.NORTH );
            move();
        } else if ( angle == 45 ) {
            setDirection( Location.NORTHEAST );
            move();
        } else if( angle == 90 ) {
            setDirection( Location.EAST );
            move();
        } else if( angle == 135 ) {
            setDirection( Location.SOUTHEAST );
            move();
        } else if( angle == 180 ) {
            setDirection( Location.SOUTH );
            move();
        } else if( angle == 225 ) {
            setDirection( Location.SOUTHWEST );
            move();
        } else if (angle == 270) {
            setDirection(Location.WEST);
            move();
        } else if (angle == 315) {
            setDirection(Location.NORTHWEST);
            move();
        }
    }
}
