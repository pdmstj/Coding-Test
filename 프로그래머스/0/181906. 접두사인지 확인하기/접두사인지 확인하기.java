class Solution {
    public int solution(String my_string, String is_prefix) {
        // my_string이 is_prefix로 시작하면 1을 반환, 아니면 0을 반환
        if (my_string.startsWith(is_prefix)) {
            return 1;
        } else {
            return 0;
        }
    }
}
