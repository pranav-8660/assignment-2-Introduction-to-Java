import java.util.Arrays;
import java.util.Scanner;

public class LeftRotationOfArray {

    private static void reverseArrayElements(int start,int end,int[] array){
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private static void leftRotateArray(int nRotations,int[] array,int lastIndex){

        if (array.length == 0 || nRotations == 0) return;

        nRotations = nRotations % (lastIndex+1);

        reverseArrayElements(0,nRotations-1,array);
        reverseArrayElements(nRotations, lastIndex, array);
        reverseArrayElements(0, lastIndex, array);
        
    }

    private static void printArray(int[] arr){

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println();

    }

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Enter a length of the array :- ");

            int lengthOfArray = sc.nextInt();

            int[] integerArray = new int[lengthOfArray];

            System.out.println("Enter all the array elements one by one:-");
            
            for(int iterator=0;iterator<lengthOfArray;iterator++)
                integerArray[iterator] = sc.nextInt();

            System.out.println("Enter the total number of left rotations required:- ");
            int nRotations = sc.nextInt();
            
            
            System.out.println("Array elements before rotation:-");
            printArray(integerArray);

            leftRotateArray(nRotations, integerArray, lengthOfArray-1);

            System.out.println("Array elements after rotation:-");
            printArray(integerArray);
            
        }
    }
    
}
