package GRAPHS.ALGORITHMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TOPOLOGICAL_SORT {

    public static void main(String[] args) {
        int [][] edges= new int[][]{{3,0},{1,0},{2,0}};
        System.out.println(topoSort(4,edges));
    }

    // A LINEAR ORDERING SUCH THAT IF THERE IS AN EDGE BETWEEN U AND V , U APPEARS BEFORE V
    // ONLY FOR A ACYCLIC GRAPH DUE TO CYCLIC DEPENDENCY

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for( int  [] list: edges){
            adj.get(list[0]).add(list[1]);
        }
        boolean [] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                func(adj,i,st,visited);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }

    public static void func(List<List<Integer>> adj, int node, Stack<Integer> st, boolean [] visited){
            visited[node] = true;

            for( int i: adj.get(node)){
                if(!visited[i]){
                func(adj,i,st,visited);
                }
            }
            st.push(node);
    }

}
