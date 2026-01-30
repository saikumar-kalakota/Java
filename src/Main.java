import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int [] arr = { 56, 34, 67, 34, 5675, 345};

        //Converting primitive int array to Integer array using Arrays class, stream(arr), boxing into IntStream, reconvert to Array as new Integer
        Integer [] intArr= Arrays
                            .stream(arr)
                            .boxed()
                            .toArray(Integer[]::new);
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

        Arrays.sort( intArr, Collections.reverseOrder()); //~ AS CRO~~ AS CRO ~ESCROW
        System.out.println("Reverse order");
        System.out.println(Arrays.toString(intArr));

        String str= reverseString("Monalisa");
        System.out.println("Reversed string "+ str);

        char [] a= {'a', 'e', 'i', 'o','s','a', 'u', 'b'};

        Character [] charArr = convertToCharacterArray(a);
        System.out.println(Arrays.asList(charArr));

        sortArrays();
        int [] arr2 = new int [7];
        arr2= new int[] {1, 5,3,44,6,33,3};
        int [] mergedPrimitiveIntsArray= mergeArrays(arr, arr2);
        System.out.println(Arrays.toString(mergedPrimitiveIntsArray));
        int[] array = Arrays.stream(mergedPrimitiveIntsArray).distinct().toArray();
        System.out.println(Arrays.toString(array));

    }
    
    public static String reverseString(String str){
        
        char [] arr= str.toCharArray();
        StringBuilder reverseStr = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            char c= arr[i];
            reverseStr.append(c);
        }
        System.out.println(reverseStr);
        return reverseStr.toString();
    }

    static Character [] convertToCharacterArray(char [] a){
        return new String(a)
                .chars()
                .mapToObj(c-> (char) c)
                .toArray(Character[]::new);
    }

    static void sortArrays(){
        int [] arr =  new int[8];
        arr = new int [] { 12, 34543, 23, 4545, 345,33, 674, 67};
        Integer [] intArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        System.out.println(Arrays.toString(intArr));

        Arrays.sort(intArr, Collections.reverseOrder());
        System.out.println(Arrays.toString(intArr));

        List<Integer> lstArr= new ArrayList<>(Arrays.asList(intArr));
        System.out.println(lstArr);

        Collections.sort(lstArr);
        System.out.println("Asc order sort using Collections.sort(list) " +lstArr );

        Collections.sort(lstArr, Comparator.comparingInt(Integer::intValue).reversed());
        System.out.println("Desc order sort using Collections.sort(list, Comparator.comparingInt(Integer::intValue).reversed()) " +lstArr );
    }

    /**
     *
     * @param a array of primitive integers
     * @param b array of primitive integers
     * @return array of primitive integers
     */

    static int [] mergeArrays(int [] a, int [] b){
        int [] mergedArray= IntStream.concat(Arrays.stream(a) , Arrays.stream(b)).toArray();
        return mergedArray ;
    }
    }
