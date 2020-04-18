import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Nightcrawler extends Critter {
    public Nightcrawler() {
        super();
    }

    public ArrayList<Location> getMoveLocations() {
        Grid<Actor> grid = getGrid();
        ArrayList<Location> available = new ArrayList<Location>();
        for (int i = 0; i < grid.getNumRows(); i++) {
            for (int v = 0; v < grid.getNumCols(); v++) {
                Location l = new Location(i, v);
                Actor neighbor = grid.get(l);
                if (!(neighbor instanceof Actor) && grid.isValid(l)) {
                    available.add(l);
                }
            }
        }
        return available;
    }

    public void makeMove(Location l) {
        moveTo(l);
        Smoke poof = new Smoke(Color.PINK);
        poof.putSelfInGrid(getGrid(), getLocation());
    }
}
