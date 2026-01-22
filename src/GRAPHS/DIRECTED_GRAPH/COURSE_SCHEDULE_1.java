package GRAPHS.DIRECTED_GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class COURSE_SCHEDULE_1 {
    public static void main(String[] args) {
        System.out.println(canFinish(5,new int [][]{{1,4},{2,4},{3,1},{3,2}}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int [numCourses];
        boolean [] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for( int [] i : prerequisites){
                adj.get(i[1]).add(i[0]);
                indegree[i[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for( int  i =0;i<numCourses;i++){
            if ( indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node  = q.poll();
            visited[node]= true;
            result.add(node);
            for( int  i : adj.get(node)){
//               System.out.println(indegree[i]);
                indegree[i]--;

                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
//      System.out.println(result);
    return result.size()==numCourses;
    }
}
