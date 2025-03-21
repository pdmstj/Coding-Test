import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            StringBuilder filteredSkillTree = new StringBuilder();

            for (char c : skill_tree.toCharArray()) {
                if (skill.contains(String.valueOf(c))) {
                    filteredSkillTree.append(c);
                }
            }

            if (skill.startsWith(filteredSkillTree.toString())) {
                answer++;
            }
        }

        return answer;
    }
}
