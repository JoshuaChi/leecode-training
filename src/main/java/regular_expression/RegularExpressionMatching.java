package regular_expression;

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

 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        int plength = p.length();
        if (plength < 1) {
            return true;
        }

        int slength = s.length();
        if (slength < 1) {
            return true;
        }

        //if next character in p is '*' or '.', we will cutOneCharacter from s and reverse p;
        boolean[][] dp = new boolean[plength][slength];
        for (int i=0; i<plength; i++) {
            char pc = p.charAt(i);
            for (int j = 0; j<slength; j++) {
                char sc = s.charAt(j);

                if (pc == '.') {
                    if ( (i-1) >= 0 && (j-1) >= 0) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else {
                        dp[i][j] = true;
                    }
                }
                else if(pc == '*') {
                    //aac a*c
                    char pc1 = p.charAt(i-1);
                    if (sc == pc1 || pc1 == '.') {
                        if (j-1 >=0 && i-1 >=0) {
                            dp[i][j] = dp[i-1][j-1];
                        }
                        else {
                            dp[i][j] = true;
                        }
                    }
                    else {
                        if(i-2 >=0) {
                            dp[i][j] = dp[i][j-2];
                        }
                        dp[i][j] = false;
                    }
                }
                else {
                    if (pc == sc) {
                        dp[i][j] = true;
                    }
                    else {
                        if ((i-1) >= 0 ) {
                            dp[i][j] = dp[i-1][j];
                        }
                        else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        return dp[plength-1][slength-1];
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
