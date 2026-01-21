package GRAPHS.DIRECTED_GRAPH;

//Given a directed graph with V vertices numbered from 0 to V-1 and E directed edges,
// represented as a 2D array edges[][], where each element edges[i] = [u, v] represents a directed edge from vertex u to vertex v.
// Return all Safe Nodes of the graph.
//A vertex with no outgoing edges is called a terminal node.
// A vertex is considered safe if every path starting from it eventually reaches a terminal node.


import java.util.ArrayList;
import java.util.List;

public class EVENTUAL_SAFE_STATES {

    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        List<List<Integer>> adj = build(V,edges);
        int [] visited = new int [V];


        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,visited);
            }
        }
        ArrayList<Integer> result  = new ArrayList<>();
        for( int i =0;i<V;i++){
            if(visited[i]==2){
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int i, List<List<Integer>> adj, int [] visited){
            if(visited[i]==1) return true;

            if(visited[i]==2) return false;

            visited[i]=1;
            for( int n: adj.get(i)){
                if(dfs(n,adj, visited)){
                    return true;
                }
            }
            visited[i]=2;
    return false;
    }

    public List<List<Integer>> build(int V, int [][] arr){
            List<List<Integer>> list = new ArrayList<>();

            for(int i=0;i<V;i++){
                list.add(new ArrayList<Integer>());
            }
            for( int [] i : arr){
                list.get(i[0]).add(i[1]);
            }

            return list;
    }
}
