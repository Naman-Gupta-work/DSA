package GRAPHS.ALGORITHMS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KAHNS_ALGORITHM {

    // MAKE IN DEGREE ARRAY
    // PUSH ELEMENTS WITH ZERO VAL TO  QUEUE
    // GET ADJ LIST OF NODE , IN DEGREE --
    // IF IN DEGREE IS ZERO ADD TO  QUEUE
    ArrayList<Integer> result;

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            list.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        Kahn(visited,indegree,list,q);
        return result;
    }

    public void Kahn(boolean[] visited, int[] indegree, List<List<Integer>> adj, Queue<Integer> q) {

        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            result.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }

            }
        }

    }


}
