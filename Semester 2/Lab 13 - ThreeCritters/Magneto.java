import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Magneto extends Critter {
    public Magneto() {
        super();
    }

    public void processActors(ArrayList<Actor> actors) {
        Grid<Actor> grid = getGrid();
        Location x = getLocation();

        for (int i = 0; i < grid.getNumRows(); i++) {
            for (int v = 0; v < grid.getNumCols(); v++) {
                Location location = new Location(i, v);
                Actor neighbor = grid.get(location);
                if (neighbor instanceof Rock) 
                    moveRock(neighbor, x, location);
            }
        }
    }

    public void moveRock(Actor a, Location l, Location r) {
        int rock_R = r.getRow(), rock_C = r.getCol(), new_R = rock_R, new_C = rock_C;
        if (rock_R < l.getRow()) {
            if (rock_C < l.getCol()) {
                if (isValid(rock_R + 1, rock_C)) {
                    new_R = rock_R + 1;
                    new_C = rock_C;
                }
                if (isValid(rock_R, rock_C + 1)) {
                    new_R = rock_R;
                    new_C = rock_C + 1;
                }
                if (isValid(rock_R + 1, rock_C + 1)) {
                    new_R = rock_R + 1;
                    new_C = rock_C + 1;
                }
            }
            else if (rock_C > l.getCol()) {
                if (isValid(rock_R + 1, rock_C)) {
                    new_R = rock_R + 1;
                    new_C = rock_C;
                }
                if (isValid(rock_R, rock_C - 1)) {
                    new_R = rock_R;
                    new_C = rock_C - 1;
                }
                if (isValid(rock_R + 1, rock_C - 1)) {
                    new_R = rock_R + 1;
                    new_C = rock_C - 1;
                }
            }
        }
        else if (rock_R > l.getRow()) {
            if (rock_C < l.getCol()) {
                if (isValid(rock_R - 1, rock_C)) {
                    new_R = rock_R - 1;
                    new_C = rock_C;
                }
                if (isValid(rock_R, rock_C + 1)) {
                    new_R = rock_R;
                    new_C = rock_C + 1;
                }
                if (isValid(rock_R - 1, rock_C + 1)) {
                    new_R = rock_R - 1;
                    new_C = rock_C + 1;
                }
            }
            else if (rock_C > l.getCol()) {
                if (isValid(rock_R - 1, rock_C)) {
                    new_R = rock_R - 1;
                    new_C = rock_C;
                }
                if (isValid(rock_R, rock_C - 1)) {
                    new_R = rock_R;
                    new_C = rock_C - 1;
                }
                if (isValid(rock_R - 1, rock_C - 1)) {
                    new_R = rock_R - 1;
                    new_C = rock_C - 1;
                }
            }
        } a.moveTo(new Location(new_R, new_C));
    }

    public void makeMove(Location l) {
        ArrayList<Location> newLocation = getMoveLocations();
        if (l == null || newLocation.size() == 0) 
            removeSelfFromGrid();
        else 
            moveTo(l);
    }

    public boolean isValid(int i, int v) {
        Grid<Actor> grid = getGrid();
        Actor neighbor = grid.get(new Location(i, v));
        if (((!(neighbor instanceof Actor)) && (grid.isValid(new Location(i, v)))))
            return true;
        return false;
    }
}
