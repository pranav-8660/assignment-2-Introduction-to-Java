import java.util.Scanner;

public class LargestNumberInArray {

    private static int findLargestInArray(int lastIndex,int[] array){

        int maxEle = array[0];

        for(int iterator=1;iterator<lastIndex;iterator++){
            if(array[iterator]>maxEle) maxEle=array[iterator];
        }
        return maxEle;

    }

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a length of the array :- ");

            int lengthOfArray = sc.nextInt();

            int[] integerArray = new int[lengthOfArray];

            System.out.println("Enter all the array elements one by one:-");
            
            for(int iterator=0;iterator<lengthOfArray;iterator++)
                integerArray[iterator] = sc.nextInt();

            
            System.out.println("The largest element of the array is:- "+findLargestInArray(lengthOfArray-1,integerArray));
        }
    }
    
}
