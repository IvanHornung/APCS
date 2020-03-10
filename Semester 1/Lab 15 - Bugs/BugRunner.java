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

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid; 
import java.awt.*;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        
        int randomBoxBugSize = (int)(Math.random()*3) + 4;
        BoxBug bb = new BoxBug(randomBoxBugSize);

	SpiralBug sb = new SpiralBug();
	
	ZedBug zb = new ZedBug( 5 );
	world.add(new Location( 0, 0), sb );
	zb.setDirection( Location.EAST );

	
        world.show();
    }
}
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.*;


//Hornung
public class BoxBug extends Bug {
    
    private int boxSize, nMoves = 1;
    
    public BoxBug(int r) {
        boxSize = r;
        setColor(Color.RED);
    }

    
    public void act() {
        if( canMove() ) {
            if(nMoves < boxSize){
                move();
                nMoves++;
            } else if(nMoves == boxSize){
                turn();
                turn();
                nMoves = 1;
            } 
        } else {
            doubleTurn();
            nMoves = 1;
        }
    }
    
    
    //Double turn, convention instead of typing "turn();" twice
    public void doubleTurn(){
        turn();
        turn();
    }
}
