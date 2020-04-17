/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.awt.*;

public class BugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();

        world.add(new Isolationist());
        world.add(new Wildfire());

        world.add(new Bug(Color.RED));
        world.add(new Bug(Color.BLUE));
        world.add(new Bug(Color.GREEN));

        for(int i = 0; i < 3; i++) 
            world.add(new Rock());

        world.show();
    }
}
