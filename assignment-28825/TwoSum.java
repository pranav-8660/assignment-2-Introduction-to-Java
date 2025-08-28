import java.util.HashSet;
import java.util.Scanner;

public class TwoSum{

    private static boolean twoSum(int[] array,int targetSum){
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : array) {
            if (seen.contains(targetSum - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){

            System.out.println("Enter the nnumber of array elements:-");
            int noOfElements = scanner.nextInt();

            int[] arrayOfElements = new int[noOfElements];

            System.out.println("Enter all the array elements one by one:-");

            for(int iterator=0;iterator<noOfElements;iterator++){
                arrayOfElements[iterator] = scanner.nextInt();
            }

            System.out.println("Enter the target sum:-");
            int targetSum = scanner.nextInt();


            if(twoSum(arrayOfElements, targetSum)){
                System.out.println("True:- Two numbers in the provided array add up to the target sum.");
            }
            else System.out.println("False:- Two numbers in the provided array cannot add up to the target sum.");


        }
        
    }


}