import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        Set<Integer> allNumbers = new HashSet<>();
        generatePermutations("", numbers, allNumbers);

        int primeCount = 0;
        for (int num : allNumbers) {
            if (isPrime(num)) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private void generatePermutations(String prefix, String remaining, Set<Integer> allNumbers) {
        if (!prefix.isEmpty()) {
            allNumbers.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < remaining.length(); i++) {
            generatePermutations(
                prefix + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i + 1),
                allNumbers
            );
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
