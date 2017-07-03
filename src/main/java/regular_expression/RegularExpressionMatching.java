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

        if (p.length() < 1) {
            return true;
        }

        if (s.length() < 1) {
            return true;
        }


        //if next character in p is '*' or '.', we will cutOneCharacter from s and reverse p;
        int i = 0;
        while(i < p.length()) {
            s = cutOffString(s, p, i);
            if (s.indexOf("#") != -1) {
                return false;
            }
            if (s.equals("")) {
                break;
            }
            i++;
        }

        if (i == (p.length()-1)) {
            return true;
        }

        return false;
    }


    public String cutOffString(String s, String p, int i) {
        if (s.length() < 1) {
            return "";
        }

        char pc = p.charAt(i);

        if (pc == '*') {
            if (i == (p.length()-1)) {
                return "";
            }
            else {
                char nextPc = p.charAt(i+1);
                int nextIndex = s.indexOf(nextPc);
                if (nextIndex == -1) {
                    return s;
                }
                else {
                    return s.substring(nextIndex);
                }
            }
        }


        if (pc == s.charAt(0) || pc == '.') {
            return s.substring(1);
        }

        int index = s.indexOf(p);

        return index == -1? ("#"+s): s.substring(index+1);

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
