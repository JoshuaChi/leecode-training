package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Joshua on 11/25/15.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        return null;
    }

    public Set<String> extractChars (Set<String> wordList) {
        String bigString = "";
        for(String word: wordList) {
            bigString += word;
        }
        return new HashSet<String>(Arrays.asList(bigString.split("")));
    }
}
