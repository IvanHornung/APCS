import java.util.*;

public class SortDriver {
    /* count and comment steps for:
          assignment statements
          comparisons
          method calls*/
    private long steps;

    public SortDriver() {
        steps = 0;
    }

    public static void driver() {
        SortDriver a = new SortDriver();
        a.go();
    }

    public void go() {   
        int choice = 0;
        while (choice < 7) {
            Scanner keys = new Scanner(System.in);
            System.out.println("enter number of items");
            int size = keys.nextInt();
            int[] list = generateList(size);
            print(list);

            System.out.println("\n1 Bubble,     2 Sort1,        3 Sort2");
            System.out.println("4 MergeSort,    5 Binary Search,    6 Sequential Search,     7 Quit\n");
            choice = keys.nextInt();
            if (choice == 1)
                bubbleSort(list);
            else if (choice == 2)
                sort1(list);
            else if (choice == 3)
                sort2(list);
            else if (choice == 4)
                mergeSort(list, 0, list.length - 1);
            else if (choice == 5 || choice == 6)
                search(list, choice);
            if (choice < 7)
                print(list);
        }
    }

    // returns a list of size elements with values from 1 to5 * size
    public int[] generateList(int size) {
        steps= 0;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) 
            list[i] = (int)(Math.random() * size * 5 + 1);
        return list;    
    }

    public void print(int[] list) {
        if (steps > 0)
            System.out.println("This sort took " + steps + " steps to sort " + list.length + " numbers");
        if (list.length <= 100)
            for (int i = 0; i < list.length; i++)
                System.out.print(list[i] + " ");      
        System.out.println();
    }

    // bubble sort goes through the list comparing two neighboring values and swaps them if necessary
    // once the list is gone through once, the biggest is at the end
    // it then goes through the remaining spots to put the second biggest at the end, and so on
    public void bubbleSort(int[] list) {
        System.out.println("Bubble Sort");
        steps++;                                // outer = 
        for (int outer = list.length - 1; outer >= 0 ; outer--) {
            steps += 3;                         // outer >=, outer--, inner =
            for(int inner = 0; inner < outer; inner++) {
                steps += 3;                    // inner <, inner++, list[inner] >
                if (list[inner] > list[inner + 1]) {
                    steps++;                    // swap call
                    swap(list, inner, inner + 1);
                }
            }
        }
    }

    public void sort1(int[] list) {
        System.out.println("Selection Sort");      
        
    }

    public void sort2(int[] list) {
        System.out.println("Insertion Sort");
    }

    // swaps list[a] with list[b]
    public void swap (int[] list, int a, int b) {
        steps += 3;         // temp =, list[a] =, list[b] =
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    
    //to sort a portion of a list
    public void bubble(int[] list, int first, int last) {
        for (int outer = last; outer >= first ; outer--)
            for(int inner = first; inner < outer; inner++)
                if (list[inner] > list[inner + 1])
                    swap(list, inner, inner + 1);
    }
    
    public void mergeSort(int[] list, int first, int last) {
        int mid = (first + last) / 2;
        bubble( list, first, mid );
        bubble( list, mid + 1, last );
        merge( list, first, mid, last );
    }

    public void merge(int[] list, int first, int mid, int last) {
        
    }

    public void search(int[] list, int choice) {
        Scanner keys = new Scanner(System.in);
        System.out.println("Enter an item to search for");
        int value = keys.nextInt();
        int spot;
        if (choice == 5)
            spot = binarySearch(list, value);
        else
            spot = sequentialSearch(list, value);

        if (spot >= 0) 
            System.out.println(value + " is at spot " + spot);
        else
            System.out.println("value is not in the list");
    }

    public int binarySearch(int[] list, int value) {
        return -1;
    }

    public int sequentialSearch(int[] list, int value) {
        return -1;
    }
}
