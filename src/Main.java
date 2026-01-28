import java.util.Arrays;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int [] arr = { 56, 34, 67, 34, 5675, 345};

        //Converting primitive int array to Integer array using Arrays class, stream(arr), boxing into IntStream, reconvert to Array as new Integer
        Integer [] intArr= Arrays.stream(arr).boxed().toArray(Integer[]::new);
        System.out.println("Integer array is :" + Arrays.toString(intArr));

        //sub-array of 3 elements (starting from index 0 to index 2) sort
        Arrays.sort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));

        //Used to speed up sorting using fork/join (multi threading) for array length in the order of 10K
        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int searchedInt= 67;
        int i = Arrays.binarySearch(arr, searchedInt);
        System.out.println("Searched element " +  searchedInt + "  is found at index   " + i  );

        //reverse sort

        Arrays.sort( intArr, Collections.reverseOrder());
        System.out.println("Reverse order");
        System.out.println(Arrays.toString(intArr));


    }
    }
