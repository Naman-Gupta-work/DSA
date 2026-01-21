package GRAPHS.DIRECTED_GRAPH;

//Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
// check whether it contains any cycle or not.
//The graph is represented as a 2D vector edges[][],
// where each entry edges[i] = [u, v] denotes an edge from vertex u to v.

import java.util.ArrayList;

public class DETECTING_CYCLE {

    public boolean function(int node, boolean [] visited,boolean [] path , ArrayList<ArrayList<Integer>> adj ){
        visited[node]=true;
        path[node]=true;

        for( int i : adj.get(node)){
            if(!visited[i]){
                if( function (i,visited,path,adj)) return true;

            }else if(path[i]){
                return true;
            }
        }

        path[node]=false;
        return false;
    }

}
