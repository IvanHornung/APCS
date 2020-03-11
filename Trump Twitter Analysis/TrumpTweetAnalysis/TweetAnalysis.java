import java.util.*;
import java.io.*;

public class TweetAnalysis {
    static ArrayList<String> tweets = new ArrayList<String>();
    public void go () {
        //Preliminary processes
        Scanner input = new Scanner(System.in);
        /*/SOP("Doing preliminary processes");
        //initDic();
        //initTweets();
        //this.setTextFile();
        //SOP("All initialization is done");

        /* //Testing
        SOP("Enter string to find: ");
        String word = input.next();
        SOP("Index is: ");
        SOP(binarySearch(word));
        SOP("first 10 tweets");
        for (int i = 0; i < 10; i++) {
        SOP ("i: " + i + " || " + tweets.get(i));
        }*/
        
        Sound loading = new Sound("Loading");
        System.out.println("Processing the 63 million characters in the 45,000 tweets...\n");
        counting();
        
        System.out.println("Sorting...\n");
        ArrayList<Counter> sorted = sortWords(list);
        
        System.out.println("Counting...\n");
        ArrayList<Integer> counts = new ArrayList<Integer>();
        ArrayList<String> wordsToCount = new ArrayList<String>();
        for(int i = 0; i <= 35; i++) { //36 words
            wordsToCount.add(wordTurn(i));
            int saidTimes = list.get(findOccurence(wordTurn(i))).getCount();
            saidTimes += list.get(findOccurence(secondaryWordTurn(i))).getCount();
            if(i == 19) 
                saidTimes += list.get(findOccurence("foxnews")).getCount();
            else if(i == 22 ) 
                saidTimes += list.get(findOccurence("dems")).getCount();
            counts.add(saidTimes);
        }
        
        sleep(15000);
        loading.stopSong();
        intro();

        System.out.println("\n\n\n\n\n\n\n\n\t\t\t\tBEGIN!");
        sleep(2330);
        for(int i = 0; i <= 35; i++) {
            int sleepTime = 2600;
            if(i == 0) sleepTime = 2460;
            if(i == 1) sleepTime = 2750;
            if(i == 2) sleepTime = 2800;
            System.out.print('\u000C');
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\tAmount of times \"" + wordsToCount.get(i) + "\" was said:\n\n\t\t\t\t\t\t" + counts.get(i));
            sleep(sleepTime);
        }
        System.out.print('\u000C');
        sleep(3500);

        Sound inputMusic = new Sound("Loading");
        SOP("\n\n\n\n\n\n\n\n\t\t\t\tNow Your Turn!");
        SOP("\n\n\n\n\n\n\n\n\t\tEnter a word to find out how many times Trump tweeted that very word (length > 2)! (5 times)");
        for(int i = 0; i < 5; i++ ) {
            Scanner part2 = new Scanner(System.in);
            String inputPart2 = part2.next();
            int inputI = findOccurence(inputPart2);
            int inputO = list.get(inputI).getCount();
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\tAmount of times \""+inputPart2+"\" was said:\n\n\t\t\t\t\t\t" + inputO +"\n\n");
        }  sleep(4500);
        System.out.print('\u000C');
        inputMusic.stopSong();
        new Sound("Final");
        SOP("\n\n\n\n\n\n\n\n\t\t\t\tAnd Finally...");
        sleep(4500);
        System.out.print('\u000C');
        SOP("\n\n\n\n\n\n\n\n\t\t\t\tTRUMP'S 80 MOST COMMONLY SAID WORDS\n\n");
        sleep(4000);
        System.out.println("\n\n\n\tRank\tCount\tWord\n");
        for(int i = 79; i >= 0; i--) {
            System.out.println("\t"+ (i+1) +"\t"+sorted.get(sorted.size()-1-i).getCount()+"\t\""+sorted.get(sorted.size()-1-i).getWord()+"\"");
            sleep(1500);
        }
        credits();
    }

    public static void intro() {
        countdown();
        sleep(1000);
        System.out.print('\u000C');
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
    }

    public String wordTurn(int i ) {
        if(i == 0) return "china";
        if(i == 1) return "japan";
        if(i == 2) return "mexico";
        if(i == 3) return "covfefe";
        if(i == 4) return "obama";
        if(i == 5) return "fake";
        if(i == 6) return "news";
        if(i == 7) return "great";
        if(i == 8) return "wall";
        if(i == 9) return "cnn";
        if(i == 10) return "trump";
        if(i == 11) return "obamacare";
        if(i == 12) return "ratings";
        if(i == 13) return "russia";
        if(i == 14) return "crooked";
        if(i == 15) return "golf";
        if(i == 16) return "witch";
        if(i == 17) return "worst";
        if(i == 18) return "money";
        if(i == 19) return "fox";
        if(i == 20) return "treason";
        if(i == 21) return "loser";
        if(i == 22) return "democrats";
        if(i == 23) return "crazy";
        if(i == 24) return "makeamericagreatagain";
        if(i == 25) return "clown";
        if(i == 26) return "bad";
        if(i == 27) return "illegal";
        if(i == 28) return "dumb";
        if(i == 29) return "border";
        if(i == 30) return "shit";
        if(i == 31) return "bullshit";
        if(i == 32) return "hoax";
        if(i == 33) return "hillary";
        if(i == 34) return "clinton";
        if(i == 35) return "stupid";
        else return "hornung";
    }

    public String secondaryWordTurn(int i ) {
        if(i == 0) return "chinese";
        if(i == 1) return "japanese";
        if(i == 2) return "mexican";
        if(i == 3) return "hornung";///covfefe
        if(i == 4) return "barackobama";
        if(i == 5) return "fakenews";
        if(i == 6) return "fakenews";
        if(i == 7) return "hornung";///great
        if(i == 8) return "hornung";///wall
        if(i == 9) return "hornung";////cnn
        if(i == 10) return "realdonaldtrump";
        if(i == 11) return "hornung";///obamacare
        if(i == 12) return "rating";
        if(i == 13) return "russian";
        if(i == 14) return "hornung";///crooked
        if(i == 15) return "trumpgolf";
        if(i == 16) return "witchhunt";
        if(i == 17) return "hornung";///worst
        if(i == 18) return "dollars";
        if(i == 19) return "foxandfriends";/**foxnews*/
        if(i == 20) return "hornung";///treason
        if(i == 21) return "losers";
        if(i == 22) return "democrat";/**dems*/
        if(i == 23) return "hornung";///crazy
        if(i == 24) return "maga";
        if(i == 25) return "hornung";///clown
        if(i == 26) return "hornung";///bad
        if(i == 27) return "illegally";
        if(i == 28) return "dummy";
        if(i == 29) return "borders";
        if(i == 30) return "shitty";
        if(i == 31) return "chickenshit";
        if(i == 32) return "sham";
        if(i == 33) return "hillaryclinton";
        if(i == 34) return "hillaryclinton";
        if(i == 35) return "moron";
        else return "hornung";
    }

    public ArrayList<Counter> sortWords(ArrayList<Counter> words){
        for (int i = 0; i < words.size()-1; i++) {
            int min = i;
            for (int n = i+1; n < words.size(); n++)
                if (words.get(n).getCount() < words.get(min).getCount()) min = n;
            Counter temp = words.get(i);
            words.set(i,words.get(min));
            words.set(min, temp);
        } return words;
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

    //Shorthand for System.out.print(ln) :)
    static void SOP (Object line) {
        System.out.println(line);
    }

    static void sop (Object line) {
        System.out.print(line);
    }

    //Accesses dictionary text file and puts all words into an arraylist
    public static void initDic () {
        try {
            Scanner input = new Scanner( new File( "dictionary.txt" ) );
            while (input.hasNext()) {
                //dictionaryWords.add( input.nextLine() );
            }
        } catch ( FileNotFoundException ex) {}
    }

    //Two-pointer, iterative binary search
    //Pre: Gets a sting
    //Post: index of word if it exists, otherwise returns -1
    /**public static int binarySearch (String s) {
    int lft = 0, rgt = dictionaryWords.size()-1, mid;
    while (lft <= rgt) {
    mid = lft + (rgt - lft) / 2; //The famous incident where Java re-wrote their built-in binary search due to overflow
    //Link to the post where I read about it last year!!
    //https://thebittheories.com/the-curious-case-of-binary-search-the-famous-bug-that-remained-undetected-for-20-years-973e89fc212

    //Return index if we found the word
    if ( dictionaryWords.get(mid).equals(s) ) return mid;
    //Update pointers accordingly otherwise
    if ( dictionaryWords.get(mid).compareTo(s) < 0 ) lft = mid + 1;
    else rgt = mid - 1; 
    }
    //Return -1 if it doesn't exist
    return -1;
    }*/

    //Accesses Json file and outputs only the tweets to the text file
    public static void initTweets () {
        //AS OF 1:30 PM PST 1/28/2020
        String everything = "";
        try {
            Scanner input = new Scanner( new File( "TweetJson.txt" ) ); //"TweetJsonSmall.txt"
            while (input.hasNext()) {
                everything = input.nextLine();
            }
        } catch ( FileNotFoundException ex) {}

        //Use formatting from Json file to isolate tweet
        // Opening: {"text":"
        String opening = "{\"text\":\"";
        int openingLen = opening.length();
        // Closing: "}
        String closing = "\"}";
        int closingLen = closing.length();

        //Use indexOf to extract tweets
        int start = everything.indexOf(opening);
        int end = everything.indexOf(closing);
        while ( start != -1 ) {
            start = everything.indexOf(opening);
            everything = everything.substring(start + openingLen);
            end = everything.indexOf(closing);
            tweets.add( everything.substring(0,end));
        }
        //Loop iterates one more time than it should, so remove last element
        tweets.remove( tweets.size()-1 );
    }

    ArrayList<Counter> list = new ArrayList<Counter>();

    public void counting() {
        long tweetNumber = 0;
        try {
            Scanner input = new Scanner( new File( "tweetsFiltered.txt" ) );
            while (input.hasNext()) {
                tweetNumber++;
                if(tweetNumber % 1000 == 0 ) System.out.println("Tweet Number:\t" + tweetNumber + "\n\tList Size:\t" + list.size());
                String l = input.nextLine().toLowerCase();
                if(l.length() > 2 && !l.substring(0,2).equals("rt")){
                    String[] split = l.split("[\\s()?!’'\"”“#,_$…]+");
                    String cleanedUp = "";

                    for(int i = 0; i < split.length; i++ ) {
                        String term = split[i];
                        if(term.length() <= 2) continue;
                        if(term.startsWith("http") || term.startsWith("@")) continue;
                        cleanedUp += term + " ";
                    }
                    //split 2
                    split = cleanedUp.split("[\\s\\d\\W]+");
                    for(int i = 0; i < split.length; i++ ) {
                        String term = split[i];
                        if(term.length() <= 2) continue;
                        boolean notAdded = true;
                        for(int n = 0; n < list.size(); n++) {
                            String phrase;
                            if(i+1 < split.length) 
                                phrase = split[i] + " " + split[i+1];

                            if(list.get(n).getWord().equals(term) ) {
                                notAdded = false;
                                list.get(n).increase();
                            }
                        }
                        if(notAdded) {
                            list.add(new Counter(term));
                            //  System.out.println(term);
                        }
                    }
                }
            } 
        }
        catch ( FileNotFoundException ex) {}
    }

    public int findOccurence(String s) {
        for(int i = 0; i < list.size(); i++ ) {
            if(list.get(i).getWord().equals(s))
                return i;
        }
        return 0;
    }
    //Writes to a text file named tweetsFiltered
    public void setTextFile () {
        String allTweets = "";
        for (String tweet : tweets) {
            allTweets += tweet;
            allTweets += "\n";
        }
        BufferedWriter writer = null;
        try {
            File logFile = new File ("tweetsFiltered.txt");
            writer = new BufferedWriter( new FileWriter(logFile) );
            writer.write( allTweets );
        } catch (Exception e) {}
        try {
            writer.close();
        } catch (Exception e) {}
    }

    public static void credits() {
        sleep(500);
        System.out.println("\t\t\t\t\tCREDITS");
        for(int i = 0; i <= 125; i++ ) {
            String txt = "";
            if(i == 47) txt = "\t\t--Creators--";
            if(i== 50) txt = "\t\tIvan Hornung";
            if(i== 52) txt = "\t\tJaewon Lee";
            if(i== 60) txt = "\t\t--Songs--";
            if(i== 63) txt = "\"Donald Trump ft. Daft Punk - China, China, China, China\" by Grandayy";
            if(i== 65) txt = "\"THE DONALD TRUMP SONG\" by Quackity";
            if(i== 67) txt = "\"Queen - Don't Stop Me Now (Donald Trump Cover)\" by Maestro Ziikos";
            if(i== 73) txt = "\t\t--ASCII Art--";
            if(i == 76) txt = "twitchquotes.com";
            System.out.println(txt);
            sleep(100);
        }
    }
    /*public static void visuals(){
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
    int obamaIndex = findOccurence("obama");
    System.out.println(list.get(obamaIndex).getCount());
    sleep(3500);
    }*/
}
