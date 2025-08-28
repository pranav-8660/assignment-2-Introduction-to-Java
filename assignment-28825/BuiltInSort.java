import java.util.Arrays;
import java.util.Scanner;

public class BuiltInSort {

    private static void sortUsingBuiltInMethods(int[] arrayToBeSorted){
        Arrays.sort(arrayToBeSorted);
    }

    private static void printArray(int[] arrayToBePrinted){
        Arrays.stream(arrayToBePrinted).forEach(System.out::println);
    }
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Enter the number of array elements:- ");
            int noOfElements = sc.nextInt();

            System.out.println("Enter "+noOfElements+" elements, one by one:- ");
            int[] numberArray = new int[noOfElements];

            for(int iterator=0;iterator<noOfElements;iterator++){
                numberArray[iterator] = sc.nextInt();
            }

            System.out.println("\n\n\n--------------------\n\n\n");

            
            System.out.println("Array elements before sorting:- ");
            printArray(numberArray);

            System.out.println("\n\n\n--------------------\n\n\n");

            System.out.println("Array elements after sorting:- ");
            sortUsingBuiltInMethods(numberArray);
            printArray(numberArray);
        }
    }
}
