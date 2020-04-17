import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Isolationist extends Critter {
    boolean isolate = false;
    Location indoors;
    public Isolationist() {
        super();
        setColor(Color.WHITE);
        indoors = getLocation();
    }

    public ArrayList<Location> getMoveLocations() {
        ArrayList locs = new ArrayList<Location>();
        if(!isolate)
            for(int r = 0; r < getGrid().getNumRows(); r++) 
                for(int c = 0; c < getGrid().getNumCols(); c++)
                    if(getGrid().get(new Location(r,c)) == null)
                        locs.add(new Location(r,c));
        return locs;
    }  

    public void processActors(ArrayList<Actor> critters) {
        for(Actor critter : critters )
            if(critter instanceof Critter) {
                isolate = true;
                critter.removeSelfFromGrid();                
                ArrayList<Location> adjascents = new ArrayList<Location>();
                adjascents = getGrid().getEmptyAdjacentLocations(getLocation());
                for(Location surroundings: adjascents) 
                    (new Rock()).putSelfInGrid(getGrid(),surroundings);
            }
    }
}
