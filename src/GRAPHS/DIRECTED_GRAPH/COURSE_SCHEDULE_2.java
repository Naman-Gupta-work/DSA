package GRAPHS.DIRECTED_GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class COURSE_SCHEDULE_2 {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int [] result  = new int [numCourses];
            // List<Integer> result = new ArrayList<>();
            List<List<Integer>> adj = new ArrayList<>();
            int [] indegree = new int [numCourses];

            for(int i=0;i<numCourses;i++){
                adj.add(new ArrayList<>());
            }
            for( int [] i : prerequisites){
                adj.get(i[1]).add(i[0]);
                indegree[i[0]]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for( int  i=0;i<numCourses;i++){
                if ( indegree[i] == 0) q.offer(i);
            }
            int ind=0;
            while(!q.isEmpty()){
                int node  = q.poll();

                result[ind++]=node;
                for( int  i : adj.get(node)){
//                System.out.println(indegree[i]);
                    indegree[i]--;

                    if(indegree[i]==0){
                        q.offer(i);
                    }
                }
            }
//        System.out.println(result);
            // return  (result.size() == numCourses ) ? result.stream().mapToInt(Integer::intValue).toArray() : new int []{};
            return ind==numCourses ? result : new int [0];
        }

}
