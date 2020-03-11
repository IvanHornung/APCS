//CUSTOM WORDS/PREPOSITIONS/VERBS HERE WERE INPUTTED BY ANOTHER STUDENT -- i wrote everything else
public class Word
{
    private String word;
    private int syllables;
    
    public Word( String w, int s )
    {
        word = w;
        syllables = s;
    }
    
    public String getWord()
    {
        return word;
    }
    
    public int getSyllables()
    {
        return syllables;
    }
}


public class PhraseMaker
{
    private String[] nouns;
    private String[] verbs;
    private String[] preps; 

    //initialize and fill arrays with at least ten nouns, verbs, and prepositional phrases of 
    // your choice.
    // Hint: A prepositional phrase consists of a preposition, modifiers, and an object.
    // Examples: "at home", "on the cat", "across the street", "in the compost heap", etc.
    public PhraseMaker()
    {
        nouns = new String[31];
        verbs = new String[52];
        preps = new String[31];
    }

    //construct and return a String consisting of a random noun from the nouns array,
    // a random verb from the verbs array, and a random prepositional phrase from the preps array.
    public String makePhrase() {
        nouns[0] = "Albania";
        nouns[1] = "basement";
        nouns[2] = "cheese";
        nouns[3] = "peanut butter"; 
        nouns[4] = "covfefe";
        nouns[5] = "tanning bed";
        nouns[6] = "toenail";
        nouns[7] = "belly button lint";
        nouns[8] = "urinal";
        nouns[9] = "propaganda";
        nouns[10] = "Demarcus Bradley";
        nouns[11] = "draft";
        nouns[12] = "blood";
        nouns[13] = "Dequavus Ma";
        nouns[14] = "rust";
        nouns[15] = "maggot";
        nouns[16] = "acid";
        nouns[17] = "warmth";
        nouns[18] = "crusty blanket";
        nouns[19] = "MrBoss Kim";
        nouns[20] = "arousal";
        nouns[21] = "Jahseh Onfroy";
        nouns[22] = "Fortnite";
        nouns[23] = "fart";
        nouns[24] = "homeless shelter";
        nouns[25] = "tapeworm";
        nouns[26] = "vibe";
        nouns[27] = "cocoon";
        nouns[28] = "gang violence";
        nouns[29] = "musty shower";
        nouns[30] = "كيس الكرة";

        verbs[0] = "arouses";
        verbs[1] = "galvanizes";
        verbs[2] = "captures";
        verbs[3] = "lampoons";
        verbs[4] = "moistens";
        verbs[5] = "stimulates";
        verbs[6] = "incubates";
        verbs[7] = "slithers";
        verbs[8] = "dampens";
        verbs[9] = "attacks";
        verbs[10] = "ensues";
        verbs[11] = "bestows";
        verbs[12] = "monopolizes";
        verbs[13] = "gentrifies";
        verbs[14] = "consumes";
        verbs[15] = "worships";
        verbs[16] = "secretes";
        verbs[17] = "beguiles";
        verbs[18] = "scams";
        verbs[19] = "idolizes";
        verbs[20] = "summons";
        verbs[21] = "sacrifices";
        verbs[22] = "trickshots";
        verbs[23] = "releases";
        verbs[24] = "intrigues";
        verbs[25] = "releases";
        verbs[26] = "smells";
        verbs[27] = "rubs";
        verbs[28] = "patronizes";
        verbs[29] = "builds";
        verbs[30] = "deploys";
        verbs[31] = "exemplifies";
        verbs[32] = "honors";
        verbs[33] = "smashes";
        verbs[34] = "discovers";
        verbs[35] = "wrestles";
        verbs[36] = "compresses";
        verbs[37] = "distills";
        verbs[38] = "husbands";
        verbs[39] = "engineers";
        verbs[40] = "indoctrinates";
        verbs[41] = "brainwashes";
        verbs[42] = "farts";
        verbs[43] = "exerts";
        verbs[44] = "vibes";
        verbs[45] = "operates";
        verbs[46] = "flirts";
        verbs[47] = "codes";
        verbs[48] = "executes";
        verbs[49] = "dominates";
        verbs[50] = "purchases";
        verbs[51] = "كيس الكرة";

        preps[0] = "at an Iraqi military base.";
        preps[1] = "under a bridge.";
        preps[2] = "in a homeless shelter.";
        preps[3] = "on a white suburban family's front lawn.";
        preps[4] = "in Michelle Obama's crawlspace.";
        preps[5] = "at the midget wrestling competition.";
        preps[6] = "in room D206.";
        preps[7] = "in the back of a sealed white van.";
        preps[8] = "in a vegan restaurant.";
        preps[9] = "under acid rain.";
        preps[10] = "on the roof of an orphanage.";
        preps[11] = "in the air vents of a dermatology center.";
        preps[12] = "on Tinder.";
        preps[13] = "in a Cambodian dirt tunnel.";
        preps[14] = "in كيس الكرة";
        preps[15] = "at سكيس";
        preps[16] = "inside a decaying lion.";
        preps[17] = "outside of De Anza College.";
        preps[18] = "betwixt a voting booth and Wendy's.";
        preps[19] = "in Soleimani's inner intestine.";
        preps[20] = "within proximity of you.";
        preps[21] = "in the matrix.";
        preps[22] = "inside of an unregulated Chinese factory.";
        preps[23] = "on Eppy's island.";
        preps[24] = "inside Neverland.";
        preps[25] = "in a liposuction waiting room.";
        preps[26] = "inside of a public sandbox.";
        preps[27] = "deep inside of a Chuck E. Cheese ballpit.";
        preps[28] = "whilst exposed to nuclear decay.";
        preps[29] = "by Dequavis's shack.";
        preps[30] = "on the doorstep of an Indian tech scamming center.";

        
        int r1 = (int)(Math.random()*31);
        int r2 = (int)(Math.random()*52);
        int r3 = (int)(Math.random()*31);

        return nouns[r1] + " " + verbs[r2] + " " + preps[r3];
    }
}
