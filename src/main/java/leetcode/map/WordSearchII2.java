package leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Joshua on 6/18/17.
 */
public class WordSearchII2 {
    HashMap<Character, List<String>> map = new HashMap<>();
    public List<String> findWords(char[][] board, String[] words) {

        Node root = new Node();
        initTrie(root, words);

        List<String> result = new ArrayList<>();
        for (int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, i, j, root, result);
            }
        }

        return result;
    }

    private void find(char[][] board, int i, int j, Node root, List<String> result) {
        if (i<0 || j<0 ||i>=board.length || j>= board[0].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        //1. has been visited
        //2. not the character we are looking for
        Node node = root.next[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        find(board, i, j-1, node, result);
        find(board, i, j+1, node, result);
        find(board, i-1, j, node, result);
        find(board, i+1, j, node, result);
        board[i][j] = c;

    }

    //"abc", "aefg"
    private void initTrie(Node root, String[] words) {
        for (String word: words) {
            Node cursor = root;
            for (char c: word.toCharArray()) {
                if (cursor.next[c-'a'] == null) {
                    cursor.next[c-'a'] = new Node();
                }
                cursor = cursor.next[c-'a'];
            }
            cursor.word = word;
        }
    }

    public class Node {
        String word;
        Node[] next = new Node[26];
    }



    public static void main(String[] args) {
        WordSearchII2 wordSearchII1 = new WordSearchII2();
        String[] strMap = new String[7];
        strMap[0] = "baabab";
        strMap[1] = "abaaaa";
        strMap[2] = "abaaab";
        strMap[3] = "ababba";
        strMap[4] = "aabbab";
        strMap[5] = "aabbba";
        strMap[6] = "aabaab";

        String[] words = new String[1]; //"","","","",
        words[0] = "aabbbbabbaababaaaabababbaaba";
//        words[1] = "aabbaaabaaabaabaaaaaabbaaaba";
//        words[2] = "babaababbbbbbbaabaababaabaaa";
//        words[3] = "bbbaaabaabbaaababababbbbbaaa";
/*        String[] strMap = new String[3];
        strMap[0] = "abc";
        strMap[1] = "aed";
        strMap[2] = "afg";

        String[] words = new String[1];
        words[0] = "eaabcdgfa"; //["abcdefg","befa","eaabcdgfa","gfedcbaaa"]*/
        /*String[] strMap = new String[4];
        strMap[0] = "oaan";
        strMap[1] = "etae";
        strMap[2] = "ihkr";
        strMap[3] = "iflv";

        String[] words = new String[4];
        words[0] = "oath";
        words[1] = "pea";
        words[2] = "eat";
        words[3] = "rain";*/

        char[][] map = new char[strMap.length][strMap[0].length()];
        int i = 0;
        for (String s: strMap) {
            int j=0;
            for (char c: s.toCharArray()) {
                map[i][j] = c;
                j++;
            }
            i++;
        }

        List<String> list = wordSearchII1.findWords(map, words);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
