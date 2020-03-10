//Hornung
//Lab 10 - APCSLand (Individual)
//Apply conditionals/loops in a fun way!
//Pre-conditions are the things that must be true before a method is called. The method tells clients "this is what I expect from you".
//Post-conditions are the things that must be true after the method is complete.
import java.util.*;
import gpdraw.*;

public class APCSLand
{
    /*private DrawingTool myPencil;
    private SketchPad myPaper;*/

    //Pre-Conditions = program is running
    //Post-Conditions = series of print statements that show game execution
    public void playGame() {
        System.out.println("\n\n\n\n=================================================================\n\n\n\n"); //syntax
        boolean over = false, playerAT = true; //Over determines if the game is still running | PlayerAT = is it player A's turn.
        int playerAP = 0, playerBP = 0; //position of Player A,B

        //Pre-Conditions = game isn't over
        //Post-Conditions = game is over and all print statements are executed
        while(!over) {
            int diceRP = diceRoll();

            
            if ( diceRP == 2 || diceRP == 12 )
                diceRP = 0;
            else if (diceRP == 7) 
                diceRP = -7;

            if (playerAT) {
                System.out.println("Player A Rolled a  " + diceRP);
                playerAP += diceRP;
                if (playerAP < 0 )
                    playerAP = 0;

                if ( playerAP == playerBP )
                    playerBP = 0;
            }

            else {
                System.out.println("Player B Rolled a  " + diceRP);
                playerBP += diceRP;
                if (playerBP < 0 )
                    playerBP = 0;

                if ( playerBP == playerAP )
                    playerAP = 0;
            }

            playerAT = !playerAT; //Switch player turns

            //Convert positions to strings to make printout easier
            String printOutA = String.valueOf(playerAP);
            String printOutB = String.valueOf(playerBP);

            if (playerAP == 0)
                printOutA = "START";
            else if (playerAP >= 40)
                printOutA = "FINISH";

            if (playerBP == 0)
                printOutB = "START";
            else if (playerBP >= 40)
                printOutB = "FINISH";

            System.out.println("Player A's Position: " + printOutA + "\tPlayer B's Position: " + printOutB);

            if (playerAP >= 40) {
                System.out.println("\nPlayer A Wins!");
                over = !over;
            }

            if (playerBP >= 40) {
                System.out.println("\nPlayer B Wins!");
                over = !over;
            }
        }
        //APCSLand_Visuals vis = new APCSLand_Visuals();
        //vis.Visuals();
    }
    
    //Pre-Conditions: method is called
    //Post-Conditions: the sum of two dice when rolled randomly is returned
    public int diceRoll() {
        int diceR1 = (int)(Math.random()*6) + 1;
        int diceR2 = (int)(Math.random()*6) + 1;
        int diceRoll = diceR1 + diceR2;
        return diceRoll;
    }

    public static void main( String[] args ) {
        APCSLand run = new APCSLand();
        run.playGame();
    }
}
