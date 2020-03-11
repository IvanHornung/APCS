public class PhraseDriver
{
    public static void main( String[] args )
    {
        PhraseMaker pm = new PhraseMaker();
        for( int i = 0; i < 5; i++ )
        {
            System.out.println( pm.makePhrase() );
        }
        System.out.println("\n\n==========Fauxku============\n\n");
        FauxkuMaker hm = new FauxkuMaker();
        System.out.println( hm.makeFauxku() );
        
    }
}
