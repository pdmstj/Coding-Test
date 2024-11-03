class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder();

        // str_list를 순회하면서 ex가 포함되지 않은 문자열을 answer에 추가
        for (String str : str_list) {
            if (!str.contains(ex)) {
                answer.append(str);
            }
        }

        return answer.toString();
    }
}
