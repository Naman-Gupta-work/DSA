package GRAPHS.DIRECTED_GRAPH;

import java.util.*;

public class ALIEN_DICTIONARY {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(words));

    }

    public static String findOrder(String[] words) {

        Map<Character, List<Character>> adj = new HashMap<>();

        // Step 1: include all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }

        // Step 2: build edges
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;

            while (j < len && w1.charAt(j) == w2.charAt(j)) {
                j++;
            }

            if (j < len) {
                adj.get(w1.charAt(j)).add(w2.charAt(j));
            } else if (w1.length() > w2.length()) {
                return "";
            }
        }
        Map<Character, Integer> state = new HashMap<>();
        for (char c : adj.keySet()) state.put(c, 0);

        Stack<Character> st = new Stack<>();

        for (char c : adj.keySet()) {
            if (state.get(c) == 0) {
                if (!dfs(c, adj, state, st)) {
                    return ""; // cycle detected
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.toString();
    }

    private static boolean dfs(char c, Map<Character, List<Character>> adj, Map<Character, Integer> state, Stack<Character> st) {
        state.put(c, 1); // visiting

        for (char nei : adj.get(c)) {
            if (state.get(nei) == 1) return false; // cycle
            if (state.get(nei) == 0) {
                if (!dfs(nei, adj, state, st)) return false;
            }
        }

        state.put(c, 2); // visited
        st.push(c);
        return true;
    }


}