import java.util.Scanner;

public class PlaindromeString {

    private static String reverseString(String givenString){

        String str = "";

        for(int iterator=givenString.length()-1;iterator>=0;iterator--){
            str+=givenString.charAt(iterator);
        }
        return str;
    }

    private static boolean isPalindrome(String givenString){

        if(reverseString(givenString).equals(givenString)) return true;
        return false;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a string:- ");

            String inpuString = sc.nextLine();

            if(isPalindrome(inpuString)){
                System.out.println("The input string "+inpuString+" is Palindrome.");
            }
            else System.out.println("The input string "+inpuString+" is not Palindrome.");
            
        }

    }
    
}
