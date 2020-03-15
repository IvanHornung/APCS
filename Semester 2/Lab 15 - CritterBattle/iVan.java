import java.util.*;
import java.awt.*;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class iVan extends Critter {

    public iVan() {
        super();
    }

    /** 
     * @param locs : an ArrayList of available locations on the grid
     * @return the most optimal location on the grid: the first location available (first gets first move)
     */
    public Location selectMoveLocation(final ArrayList<Location> locs) {
        return ((getLocation().getRow() + getLocation().getCol() == 0) || (locs.size() == 0)) ? getLocation()
                : locs.get(0);
    }

    /**
     * @return an ArrayList of available locations
     */
    public ArrayList<Location> getMoveLocations() {
        final ArrayList<Location> available = new ArrayList<Location>();
        final Grid<Actor> grid = getGrid();
        for (int r = 0; r < grid.getNumRows(); r++)
            for (int c = 0; c < grid.getNumCols(); c++) {
                if (grid.isValid(new Location(r, c)) && !(grid.get(new Location(r, c)) instanceof Critter))
                    available.add(new Location(r, c));
            }
        return available;
    }

    /**
     * @return an ArrayList of other critters on the grid. to be used to chose which one to kill.
     */
    public ArrayList<Actor> getActors() {
        final ArrayList<Actor> roadkill = new ArrayList<Actor>();
        final Grid<Actor> grid = getGrid();
        for (int r = 0; r < grid.getNumRows(); r++)
            for (int c = 0; c < grid.getNumCols(); c++) {
                final Actor spot = grid.get(new Location(r, c));
                if ((spot instanceof Critter && !(spot instanceof iVan))
                        && (r != getLocation().getRow() && c != getLocation().getCol()))
                    roadkill.add(spot);
            }
        return roadkill;
    }

    public int moveCount = 0;

    /**
     * @param victims : the return value of getActors()
     * @return removes a random actor from the grid  & duplicates itself every three turns
     */
    public void processActors(final ArrayList<Actor> victims) {
        moveCount++;
        if (victims.size() != 0)
            victims.get((byte) (Math.random() * victims.size())).removeSelfFromGrid();
        final Grid<Actor> grid = getGrid();
        if(moveCount % 3 == 0 && getMoveLocations().size() > 0 ) {
            (new iVan()).putSelfInGrid(grid, getMoveLocations().get(0));
        }
    }   
}