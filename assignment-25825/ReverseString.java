import java.util.Scanner;

public class ReverseString{

    private static String reverseString(String givenString){

        String str = "";

        for(int iterator=givenString.length()-1;iterator>=0;iterator--){
            str+=givenString.charAt(iterator);
        }
        return str;
    }

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a string:- ");

            String inpuString = sc.nextLine();

            System.out.println("The reverse of input string:- "+inpuString+" is :- "+reverseString(inpuString));
        }
        
    }

}