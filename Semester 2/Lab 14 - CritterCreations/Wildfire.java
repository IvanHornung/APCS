import java.util.*;
import java.awt.*;
import info.gridworld.actor.*;
import info.gridworld.grid.*;

public class Wildfire extends Critter {
    public Wildfire() {
        super();
        switch((byte)(Math.random()*8)) {
            case 0:
            switch((byte)(Math.random()*3)) {    
                case 0:
                setColor(Color.RED.darker()); break;
                case 1:
                setColor(Color.RED); break;
                default:
                setColor(Color.RED.brighter()); break;
            }
            break;
            case 1:
              case 2:
            switch((byte)(Math.random()*3)) {    
                case 0:
                setColor(Color.ORANGE.darker()); break;
                case 1:
                setColor(Color.ORANGE); break;
                default:
                setColor(Color.ORANGE.brighter()); break;
            }
            break;
            default:
            switch((byte)(Math.random()*3)) {    
                case 0:
                setColor(Color.YELLOW.darker()); break;
                case 1:
                setColor(Color.YELLOW); break;
                default:
                setColor(Color.YELLOW.brighter()); break;
            }
            break;
        }
    }

    public void makeMove(Location loc) {
        Location sp = getLocation();
        ArrayList<Location> positions = getMoveLocations();
        Grid<Actor> gridl = getGrid();
        removeSelfFromGrid();
        for (byte i = 0; i < 2; i++) {
            setDirection((int)(Math.random()*359));
            Wildfire spread = new Wildfire();
            if (positions.size() == 0) {
                spread.putSelfInGrid(gridl, sp); break;
            }
            int varR = (int)(Math.random()*positions.size());
            spread.putSelfInGrid(gridl, positions.get(varR));
            positions.remove(varR);
        }
    }

    public ArrayList<Location> getMoveLocations() {
        Grid<Actor> grid = getGrid();
        ArrayList<Location> availableLoc = new ArrayList<Location>();
        for (short i = 0; i < grid.getNumRows(); i++) {
            for (short v = 0; v < grid.getNumCols(); v++) {
                Location pos = new Location(i,v);
                Actor neighbor = grid.get(pos);
                if (!(neighbor instanceof Actor) && grid.isValid(pos)) 
                    availableLoc.add(pos);
            }
        }
        return availableLoc;
    }
}
