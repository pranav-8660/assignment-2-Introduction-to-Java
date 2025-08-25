import java.util.Scanner;

public class CountVowels {
    private static boolean isVowel(char inputCharacter){
        if(inputCharacter=='A' || inputCharacter=='E' || inputCharacter=='I' || inputCharacter=='O' || inputCharacter=='U'|| 
           inputCharacter=='a' || inputCharacter=='e' || inputCharacter=='i' || inputCharacter=='o' || inputCharacter=='u' )
            return true;
        return false;
    }

    private static int countVowelsInString(String givenString){

        int vowelCount=0;

        for(int iterator=0;iterator<givenString.length();iterator++){
            if(isVowel(givenString.charAt(iterator))) vowelCount++;
        }


        return vowelCount;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a string:- ");

            String inpuString = sc.nextLine();

            System.out.println("Vowel count of input string:- "+countVowelsInString(inpuString));
        }
    }
}
