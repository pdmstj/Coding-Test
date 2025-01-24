class Solution {
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        StringBuilder kBase = new StringBuilder();
        while (n > 0) {
            kBase.insert(0, n % k);
            n /= k;
        }

        String[] candidates = kBase.toString().split("0");

        int primeCount = 0;
        for (String candidate : candidates) {
            if (!candidate.isEmpty()) {  
                long num = Long.parseLong(candidate); 
                if (isPrime(num)) {
                    primeCount++;
                }
            }
        }

        return primeCount;
    }
}
