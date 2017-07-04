package leetcode.dp;

import java.util.Arrays;

/**

 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true


 * b[i + 1][j + 1]: if s[0..i] matches p[0..j]
 *  if p[j] != '*'
 *      b[i + 1][j + 1] = b[i][j] && s[i] == p[j]
 *  if p[j] == '*', denote p[j - 1] with x,
 *      then b[i + 1][j + 1] is true iff any of the following is true
 *          1) "x*" repeats 0 time and matches empty: b[i + 1][j -1]
 *          2) "x*" repeats 1 time and matches x: b[i + 1][j]
 *          3) "x*" repeats >= 2 times and matches "x*x": s[i] == x && b[i][j + 1]
 * '.' matches any single character

 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for (int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int j=0; j<p.length(); j++) {
            if ('*' == p.charAt(j) && dp[0][j-1]) {
                dp[0][j+1] = true;
            }
        }

        for (int i=0; i<s.length(); i++) {
            char sc = s.charAt(i);
            for (int j=0; j<p.length(); j++) {
                char pc = p.charAt(j);
                if (pc == '.' || pc == sc) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (pc == '*') {
                    if (sc != p.charAt(j-1) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else {
                        dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {

        RegularExpressionMatching expressionMatching = new RegularExpressionMatching();
        boolean r = expressionMatching.isMatch("ab", ".*c");
        System.out.println(r);

        r = expressionMatching.isMatch("aab", "c*a*b");
        System.out.println(r);

        r = expressionMatching.isMatch("abcd", "d*");
        System.out.println(r);

        r = expressionMatching.isMatch("aaa", "a");
        System.out.println(r);

        r = expressionMatching.isMatch("aa", "a*");
        System.out.println(r);

        r = expressionMatching.isMatch("aa", ".*");
        System.out.println(r);

        r = expressionMatching.isMatch("aa", ".*");
        System.out.println(r);

        r = expressionMatching.isMatch("ab", ".*");
        System.out.println(r);

        r = expressionMatching.isMatch("aab", "c*a*b");
        System.out.println(r);
    }
}
