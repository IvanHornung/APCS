import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;
import java.util.*;

public class Mystique extends Critter {
    public Mystique() {
        super();
    }

    public void processActors(ArrayList<Actor> actors) {
        turn();
        ArrayList<Actor> critters = new ArrayList<Actor>();
        for (Actor a : actors) 
            if (a instanceof Bug) 
                critters.add(a);           
        int bSize = critters.size();
        if (bSize == 0) {
            return;
        }
        Actor alien = critters.get((int)(Math.random()*bSize));
        setColor(alien.getColor());
    }

    public void turn() {
        setDirection((int)(Math.random() * 359));
    }
}
