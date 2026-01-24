package GRAPHS.UNDIRECTED_GRAPHS;

import java.util.*;

public class SHORTEST_PATH {
    public static void main(String[] args) {
//        int [][] edges = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
//        int [][] edges ={{0,3},{1,3}};
//        int[][] edges = {
////                {0, 1}, {0, 3}, {3, 4}, {4, 5},
//                {5, 6}, {1, 2}, {2, 6}, {6, 7},
//                {7, 8}, {6, 8}};
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3},
                {0, 4}, {4, 5}, {5, 6},
                {6, 7}, {0, 7}, {1, 7}, {3, 7}
        };

        int [] answer =shortestPath(8,edges,0);
        for(int i : answer) System.out.print(i+" ");
        System.out.println();
        for( int i =0 ;i<answer.length;i++){
            System.out.print(i+" ");
        }
    }
    public static int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        // build adjacency list
        for( int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for( int [] list : edges){
            adj.get(list[0]).add(list[1]);
            adj.get(list[1]).add(list[0]);
        }
        boolean [] visited = new boolean[V];
        int [] distance = new int [V];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        q.offer(src);
//        System.out.println(adj);
        visited[src]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int vertice : adj.get(node)){
                if(!visited[vertice]){
                    distance[vertice]=distance[node]+1;
                    q.offer(vertice);
                    visited[vertice]=true;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(distance[i]==Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }
        return distance;
    }
}
