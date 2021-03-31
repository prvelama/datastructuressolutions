package main.java.com.datastructures.solutions.graphs;
import java.util.*;

/*
Given a directed, acyclic graph of N nodes.
Find all possible paths from node 0 to node N-1, and return them in any order.
The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
graph[i] is a list of all nodes j for which the edge (i, j) exists.
Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:
The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

public class AllPathsSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new LinkedList<>();
        List<Integer> currentPath = new LinkedList<>();
        currentPath.add(0);
        dfs(graph, currentPath, allPaths,0);
        return allPaths;
    }

    public void dfs(int[][] graph, List<Integer> currentPath, List<List<Integer>> allPaths, int node){

        if(node == graph.length-1)
        {
            allPaths.add(new LinkedList<>(currentPath));
            return;
        }
        for(int neighbour: graph[node]){
            currentPath.add(neighbour);
            dfs(graph, currentPath, allPaths, neighbour);
            currentPath.remove(currentPath.size()-1);
        }
    }

    public static void main(String[] args){
        AllPathsSourceToTarget a = new AllPathsSourceToTarget();
        int[][] graph = new int[][]{{1,2}, {3,4}, {3}, {4}, {}};
        System.out.println(graph.length);
        List<List<Integer>> result = a.allPathsSourceTarget(graph);
        for(List<Integer> path: result){
            for(int i: path)
            {
                System.out.print(i +"->");
            }
            System.out.println("");
        }
    }
}
