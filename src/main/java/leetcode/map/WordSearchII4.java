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
public class WordSearchII4 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res) {
        if (i<0 || j<0 ||i>=board.length ||j>= board[0].length) {
            return;
        }

        char c = board[i][j];

        if (c == '#' || root.next[c-'a'] == null) {
            return;
        }

        if (root.next[c-'a'].word != null) {
            res.add(root.next[c-'a'].word);
            root.next[c-'a'].word = null;
        }

        board[i][j] = '#';

        dfs(board, i-1, j, root.next[c-'a'], res);
        dfs(board, i+1, j, root.next[c-'a'], res);
        dfs(board, i, j-1, root.next[c-'a'], res);
        dfs(board, i, j+1, root.next[c-'a'], res);
        board[i][j] = c;

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            for (char c: word.toCharArray()) {

                if (root.next[c-'a'] == null) {
                    root.next[c-'a'] = new TrieNode();
                }
                root = root.next[c-'a'];
            }
            root.word = word;
        }
        return root;
    }


    public class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }

    public static void main(String[] args) {
        char[] a = new char[26];
    }
}
