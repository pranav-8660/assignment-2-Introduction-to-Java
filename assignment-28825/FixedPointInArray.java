import java.util.Scanner;

public class FixedPointInArray {

    private static String fixedPointWhoseValueEqualToIndex(int[] array, int numOfElements) {
        int low = 0, high = numOfElements - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == mid) {
                return String.valueOf(mid); // this is fixed point
            } else if (array[mid] < mid) {
                low = mid + 1; // move to right
            } else {
                high = mid - 1; // move to left
            }
        }

        return "False"; //fixed point absent
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of array elements:- ");
            int numOfElements = sc.nextInt();

            System.out.println("Enter " + numOfElements + " elements, one by one:- ");
            int[] numArray = new int[numOfElements];

            for (int iterator = 0; iterator < numOfElements; iterator++) {
                numArray[iterator] = sc.nextInt();
            }

            System.out.println("The result is :- " + fixedPointWhoseValueEqualToIndex(numArray, numOfElements));
        }
    }
}
