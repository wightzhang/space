package com.zkg.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/*
 * created by kgzhang 2019/8/17
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    int lengthOfLongestSubstring3(String s) {
        int size, i = 0, j, k, max = 0;
        size = s.length();
        for (j = 0; j < size; j++) {
            for (k = i; k < j; k++)
                if (s.charAt(i) == s.charAt(j)) {
                    i = k + 1;
                    break;
                }
            if (j - i + 1 > max)
                max = j - i + 1;
        }
        return max;
    }

}
