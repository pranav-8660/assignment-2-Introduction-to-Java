import java.util.*;

public class DistinctCharactersInGivenString{

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a String:- ");
            String inpuString = sc.nextLine();

            Set<Character> distinctCharacters = new HashSet<>();

            for(int iterator=0;iterator<inpuString.length();iterator++){
                distinctCharacters.add(inpuString.charAt(iterator));
            }

            System.out.println("Distinct characters present in "+inpuString+" are:- ");
            System.out.println(distinctCharacters);
        }
    }
}