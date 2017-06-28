package leetcode.string;


/**
 * Created by joshua.chi on 6/27/17.

 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 Seen this question in a real interv

 http://blog.csdn.net/camellhf/article/details/70337501
 */
public class LargestPalindromicSubstring3 {
    private int pos = 0;
    private int maxLen = 0;

    public static void main(String[] args) {
        LargestPalindromicSubstring3 l = new LargestPalindromicSubstring3();
//        String text = "abbbbbbbaccdd";
        String text = "gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv";

        System.out.println(l.findLargestPalindromicSubstring(text));


    }

    private String populateText(String text) {
        StringBuffer buffer = new StringBuffer();
        char split = '$';
        buffer.append(split);
        for (char c: text.toCharArray()) {
            buffer.append(c);
            buffer.append(split);
        }
        return buffer.toString();
    }

    public String findLargestPalindromicSubstring(String text) {
        text = populateText(text);
        this.find(text);
        String substring = text.substring(pos, pos + maxLen + 1);
        return substring.replaceAll("\\$", "");
    }

    public void find(String text) {

        int len = text.length();
        boolean[][] dp = new boolean[len][len];

        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        //$a$b$b$a$
        for (int l=2; l<len; l++) {
            for (int i=0; i+l<len; i++) {
                if (text.charAt(i) != text.charAt(i+l)) {
                    dp[i][i+l] = false;
                }
                else {
                    dp[i][i+l] = dp[i+1][i+l-1];
                    if (dp[i][i+l] && l > maxLen) {
                        pos = i;
                        maxLen = l;
                    }
                }
            }
        }
    }


}
