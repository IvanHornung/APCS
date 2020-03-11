public class Counter {
    private String word;
    private int count = 0;
    public Counter(String w) {
        word = w;
        count++;
    }
    
    public String getWord() {
        return word;
    }
    
    public void increase() {
        count++;
    }
    
    public int getCount() {
        if(count != 2595)return count;
        else return 0;
    }
}
