import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = Integer.parseInt(scanner.nextLine());
        Map<Character, Integer> firstLetterCount = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String surname = scanner.nextLine();
            char firstLetter = surname.charAt(0);
            firstLetterCount.put(firstLetter, firstLetterCount.getOrDefault(firstLetter, 0) + 1);
        }
        
        List<Character> selectedLetters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : firstLetterCount.entrySet()) {
            if (entry.getValue() >= 5) {
                selectedLetters.add(entry.getKey());
            }
        }
        
        if (selectedLetters.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            Collections.sort(selectedLetters);
            for (char letter : selectedLetters) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }
}
