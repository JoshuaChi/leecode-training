package leetcode.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Joshua on 6/18/17.
 */
public class WordSearchII1 {
    HashMap<Character, List<String>> map = new HashMap<>();

    public List<String> findWords(char[][] board, String[] words) {
        initMap(board);

        List<String> result = new ArrayList<>();

        HashMap<String, Boolean> cache = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            if (false == cache.containsKey(words[i])) {
                if (found(board, words[i])) {
                    cache.put(words[i], true);
                    result.add(words[i]);
                }
                else {
                    cache.put(words[i], false);
                }
            }
        }

        return result;


    }

    private boolean found(char[][] board, String word) {
        char first = word.charAt(0);
        if (map.containsKey(first) == false) {
            return false;
        }
        List<String> xys = map.get(first);
        for (String xy: xys) {
            String[] xyAry = xy.split("-");
            int x = Integer.parseInt(xyAry[0]);
            int y = Integer.parseInt(xyAry[1]);
            HashSet<String> visited = new HashSet<>();
            if (f(board, word, 0, x, y, visited)) {
                return true;
            }

        }

        return false;
    }

    private boolean f(char[][] board, String word, int cursor, int i, int j, HashSet<String> visited) {

        if (cursor >= word.length()) {
            return true;
        }

        if (i<0 || j<0 || i >= board.length || j>= board[0].length) {
            return false;
        }
        String key = key(i, j);

        //if visited
        if (visited.contains(key)) {
            return false;
        }



        if (board[i][j] == word.charAt(cursor)) {
            visited.add(key);
            boolean r =  f(board, word, cursor+1, i+1, j, visited) ||
                    f(board, word, cursor+1, i-1, j, visited) ||
                    f(board, word, cursor+1, i, j-1, visited) ||
                    f(board, word, cursor+1, i, j+1, visited);
            if(false == r) {
                visited.remove(key);
            }
            return r;

        }

        return false;
    }

    private void initMap(char[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                char c = board[i][j];
                String key = key(i, j);
                List<String> list;
                if (map.containsKey(c)) {
                    list = map.get(c);
                }
                else {
                    list = new ArrayList<>();
                }
                list.add(key);
                map.put(c, list);
            }
        }
    }

    private String key(int i, int j) {
        return String.format("%s-%s", i, j);
    }

    public static void main(String[] args) {
        WordSearchII1 wordSearchII1 = new WordSearchII1();
        String[] strMap = new String[3];
        strMap[0] = "abc";
        strMap[1] = "aed";
        strMap[2] = "afg";

        String[] words = new String[1];
        words[0] = "eaabcdgfa"; //["abcdefg","befa","eaabcdgfa","gfedcbaaa"]
/*        String[] strMap = new String[4];
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
