import java.util.*;

public class RearrangeCharactersInString {

    private static String reArrangeStringNoTwoAdjacentSameChars(String givenString) {
        if (givenString == null || givenString.isEmpty()) return null;

        // frequency-map of strngs
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : givenString.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();

        // Previous entry - to avoid putting same char consecutively
        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());

            // decrease the  frequency
            current.setValue(current.getValue() - 1);

            // If previous character still has count remaining then push it back
            if (prev != null && prev.getValue() > 0) {
                maxHeap.offer(prev);
            }

            // Mark current as previous
            prev = current;
        }

        // If rearranged string length is not equal, then not possible
        if (result.length() != givenString.length()) {
            return null;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter an input string (suggestion: containing repeated characters):-");
            String inpuString = sc.nextLine();

            String rearranged = reArrangeStringNoTwoAdjacentSameChars(inpuString);

            if (rearranged == null) {
                System.out.println("None :- It is not possible to rearrange the string " + inpuString + " without adjacent duplicates.");
            } else {
                System.out.println("The result of re-arranging the given string " + inpuString + " is :- " + rearranged);
            }
        }
    }
}
