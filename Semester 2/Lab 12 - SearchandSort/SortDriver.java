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

    public static void Driver() {
        final SortDriver a = new SortDriver();
        a.go();
    }

    public void go() {   
        byte choice = 0;
        while(choice < 7) {
            Scanner keys = new Scanner(System.in);
            System.out.println("enter number of items");
            short size = keys.nextShort();
            int[] list = generateList(size);
            print(list);

            System.out.println("\n1 Bubble,     2 Sort1,        3 Sort2");
            System.out.println("4 MergeSort,    5 Binary Search,    6 Sequential Search,     7 Quit\n");
            choice = keys.nextByte();
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
            steps = 0;
        }
    }

    // returns a list of size elements with values from 1 to 5 * size
    public int[] generateList(final short size) {
        steps= 0;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) 
            list[i] = (int)(Math.random() * size * 5 + 1);
        return list;    
    }

    public void print(final int[] list) {
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
        steps++; // i =
        for (int i = 0; i < list.length; i++) {
            steps += 3; // i <, i++, j =
            int smallest = i;
            for (int v = i++; v < list.length; v++) {
                steps += 3; // j <, v++, list[v] >
                if (list[v] < list[smallest]) {
                    steps++; //smallest = 
                    smallest = v;
                }
            }
            swap(list, smallest, i);
            steps++; //swap()
        }
    }

    public void sort2(int[] list) {
        System.out.println("Insertion Sort");
        steps++; // i =
        for (int i = 1; i < list.length; i++) {
            int v = i-1;
            int temp = list[i];
            steps += 4; //temp =, v =, i <, i++
            while (list[v] > temp && v >= 0) {
                list[v + 1] = list[v];
                v--;
                steps += 4; // j >=, list[j] >, list[j+1] =, j--
            }
            list[v + 1] = temp;
            steps++; // list[v+1] =
        }
    }

    // swaps list[a] with list[b]
    public void swap(int[] list, int a, int b) {
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
    
    public void mergeSort(final int[] list, final int lower, final int upper) {
        if (lower < upper) {
            steps += 4; // midpoint = 
            final int midpoint = (lower + upper) / 2;
            mergeSort(list, lower, midpoint);
            mergeSort(list, midpoint+1, upper);
            merge(list, lower, midpoint, upper);
        }
    }

    public void merge(final int[] list, final int first, final int midpoint, final int last) {
        final int num1 = midpoint - first + 1;
        final int num2 = last - midpoint;
        final int left[] = new int[num1];
        final int right[] = new int[num2];
        steps += 4; //
        for (int i = 0; i < num1; i++) {
            left[i] = list[first + i];
        }
        for (int i = 0; i < num2; i++) {
            right[i] = list[midpoint + 1 + i];
        }
        int i = 0, v = 0;
        int j = first;
        while (i < num1 && v < num2) {
            if (left[i] <= right[v]) {
                list[j] = left[i];
                i++;
            }
            else {
                list[j] = right[v];
                v++;
            }
            j++;
        }
        while (i < num1) {
            list[j] = left[i];
            i++;
            j++;
        }
        while (j < num2) {
            list[j] = right[j];
            j++;
            j++;
        }
    }

    public void search(int[] list, int choice) {
        final Scanner keys = new Scanner(System.in);
        System.out.println("Enter an item to search for");
        final int value = keys.nextInt();
        short spot;
        if (choice == 5)
            spot = binarySearch(list, value);
        else
            spot = sequentialSearch(list, value);

        if (spot >= 0) 
            System.out.println(value + " is at spot " + spot);
        else
            System.out.println("value is not in the list");
    }

    public short binarySearch(int[] list, int value) {
        return -1;
    }

    public short sequentialSearch(int[] list, int value) {
        return -1;
    }
}
