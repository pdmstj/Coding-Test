class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletWidth = Math.min(wallet[0], wallet[1]);
        int walletHeight = Math.max(wallet[0], wallet[1]);

        int billWidth = Math.min(bill[0], bill[1]);
        int billHeight = Math.max(bill[0], bill[1]);

        while ((billWidth > walletWidth || billHeight > walletHeight) && (billHeight > walletWidth || billWidth > walletHeight)) {
            if (billHeight > billWidth) {
                billHeight /= 2;
            } else {
                billWidth /= 2;
            }
            answer++;
        }

        return answer;
    }
}
