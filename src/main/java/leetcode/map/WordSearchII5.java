package leetcode.map;

import java.util.ArrayList;
import java.util.List;

/**
 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 */
public class WordSearchII5 {
    public List<String> findWords(char[][] board, String[] words) {
       Node root = buildTrie(words);

       List<String> result = new ArrayList<>();

       for (int i=0; i<board.length; i++) {
           for (int j=0; j<board[0].length; j++) {
               find(board, i, j, result, root);
           }
       }

       return result;
    }

    private void find(char[][] board, int i, int j, List<String> result, Node root) {
        if (i<0 || i>= board.length || j<0 || j>= board[0].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#' || root.next[c -'a'] == null) {
            return;
        }

        if (root.next[c -'a'].word != null) {
            result.add(root.next[c -'a'].word);
            root.next[c -'a'].word = null;
        }

        board[i][j] = '#';

        find(board, i, j-1, result, root.next[c-'a']);
        find(board, i, j+1, result, root.next[c-'a']);
        find(board, i-1, j, result, root.next[c-'a']);
        find(board, i+1, j, result, root.next[c-'a']);
        board[i][j] = c;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();

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

        return root;
    }

    public class Node {
        String word = null;
        Node[] next;
    }

    public static void main(String[] args) {
        char[] a = new char[26];
    }
}
