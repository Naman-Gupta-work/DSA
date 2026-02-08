package GRAPHS.DIRECTED_GRAPH;

import java.util.*;

public class WORD_LADDER_1 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        q.offer(beginWord);
        visited.add(beginWord);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {

                String node = q.poll();
                if(node.equals(endWord)) return ans;
                char[] word = node.toCharArray();
                for (int i = 0; i < node.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char org = word[i];
                        if (word[i] == c) continue;
                        word[i] = c;
                        String child = new String(word);
                        if (words.contains(child) && !visited.contains(child)) {
                            q.offer(child);
                            visited.add(child);
                        }
                        word[i] = org;
                    }
                }

            }
            ans++;
        }


        return 0;
    }


}
