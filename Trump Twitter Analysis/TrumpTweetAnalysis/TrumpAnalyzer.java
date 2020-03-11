import java.util.*;
import java.io.*;

public class TrumpAnalyzer {
    static ArrayList<String> wordList;
    static String all = "";

    public static void go() {
        visuals();
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds); }
        catch( InterruptedException ex ) {}
    }

    public static void countdown(){
        for(int i = 3; i > 0; i-- ) {
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t" + i);
            sleep(1000);
            System.out.print('\u000C');
        }
    }

    public static void visuals(){
        countdown();

        new Sound("Intro");
        sleep(1000);
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tσηє ρєяѕση...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tειεvεη үεαяs...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t𝟛𝟙,𝟠𝟘𝟡 𝓇𝒶𝓌 𝓣𝓌𝑒𝑒𝓉𝓈...");
        sleep(4800);
        System.out.print('\u000C');

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t𝕋ℍ𝔼 𝔻𝕆ℕ𝔸𝕃𝔻 𝕋ℝ𝕌𝕄ℙ 𝕋𝕎𝔼𝔼𝕋 𝔸ℕ𝔸𝕃𝕐𝕊𝕀𝕊");
        sleep(2300);
        System.out.println("\n\n\n\t\t\t\t⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠋⠉⡉⣉⡛⣛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠄⠄⠄⠄⠄⢀⣸⣿⣿⡿⠿⡯⢙⠿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣿⡿⠄⠄⠄⠄⠄⡀⡀⠄⢀⣀⣉⣉⣉⠁⠐⣶⣶⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠁⣿⣿⣀⠈⠿⢟⡛⠛⣿⠛⠛⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣿⡆⠄⠄⠄⠄⠄⠈⠁⠰⣄⣴⡬⢵⣴⣿⣤⣽⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣿⡇⠄⢀⢄⡀⠄⠄⠄⠄⡉⠻⣿⡿⠁⠘⠛⡿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⡿⠃⠄⠄⠈⠻⠄⠄⠄⠄⢘⣧⣀⠾⠿⠶⠦⢳⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣶⣤⡀⢀⡀⠄⠄⠄⠄⠄⠄⠻⢣⣶⡒⠶⢤⢾⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⡿⠟⠋⠄⢘⣿⣦⡀⠄⠄⠄⠄⠄⠉⠛⠻⠻⠺⣼⣿⠟⠋⠛⠿⣿⣿");
        System.out.println("\t\t\t\t⠋⠉⠁⠄⠄⠄⠄⠄⠄⢻⣿⣿⣶⣄⡀⠄⠄⠄⠄⢀⣤⣾⣿⣿⡀⠄⠄⠄⠄⢹");
        System.out.println("\t\t\t\t⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢻⣿⣿⣿⣷⡤⠄⠰⡆⠄⠄⠈⠉⠛⠿⢦⣀⡀⡀⠄");
        System.out.println("\t\t\t\t⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢿⣿⠟⡋⠄⠄⠄⢣⠄⠄⠄⠄⠄⠄⠄⠈⠹⣿⣀");
        System.out.println("\t\t\t\t⣿⣿⣿⣿⣿⣶⣤⡀⢀⡀⠄⠄⠄⠄⠄⠄⠻⢣⣶⡒⠶⢤⢾⣿⣿⣿⣿⣿⣿⣿");
        System.out.println("\t\t\t\t⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠹⣿⣿⡇⠄⠄⠸⣿⡄⠄⠈⠁⠄⠄⠄⠄⠄⣿");
        System.out.println("\t\t\t\t⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢻⣿⡇⠄⠄⠄⢹⣧⠄⠄⠄⠄⠄⠄⠄⠄⠘");
        System.out.println("\t\t\t\t               \"ｃｈｉｎａ\"");
        sleep(2000);
        System.out.print('\u000C');

        new Sound("Rap");
        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\tBEGIN!");
        sleep(500);
        
        sleep(3500);
    }
}
