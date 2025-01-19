class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;

        int balance = 0, splitIndex = 0;
        for (int i = 0; i < p.length(); i++) {
            balance += (p.charAt(i) == '(') ? 1 : -1;
            if (balance == 0) {
                splitIndex = i + 1;
                break;
            }
        }

        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(solution(v)).append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }

    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
