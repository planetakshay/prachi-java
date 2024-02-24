package practice2023.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/
 */
public class DivideTeamIntoEqualSkills {
    public long dividePlayers(int[] skill) {
        if (skill == null || skill.length == 0) {
            return 0L;
        }
        Arrays.sort(skill);
        int len = skill.length;
        int i = 0, j = len - 1;
        long chemistry = 0;
        long total = skill[i] + skill[j];
        long curr = 0;
        while (i < j) {
            curr = skill[i] + skill[j];
            if (curr != total) {
                return -1;
            }
            chemistry += ((long) skill[i] * skill[j]);
            i++;
            j--;
        }
        return chemistry;
    }
}