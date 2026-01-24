package GRAPHS.DIRECTED_GRAPH;

import java.util.*;

public class SHORTEST_PATH_DAG {

    public static class Pair{

        int v;
        int wt;
        public Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        // Adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
        }

        // Topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, adj, visited, st);
        }

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Relax edges in topo order
        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (dist[node] + p.wt < dist[p.v]) {
                        dist[p.v] = dist[node] + p.wt;
                    }
                }
            }
        }

        // Replace unreachable with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    private void dfs(
            int node,
            List<List<Pair>> adj,
            boolean[] visited,
            Stack<Integer> st
    ) {
        visited[node] = true;

        for (Pair p : adj.get(node)) {
            if (!visited[p.v]) {
                dfs(p.v, adj, visited, st);
            }
        }
        st.push(node);
    }
}
