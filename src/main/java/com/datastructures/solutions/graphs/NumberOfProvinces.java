package main.java.com.datastructures.solutions.graphs;
/*
You are given an n x n matrix isConnected
where isConnected[i][j] = 1 if the ith city and the jth city are directly connected
and isConnected[i][j] = 0 otherwise. Return the total number of provinces.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int[] visited = new int[isConnected.length];
        for(int i=0; i < isConnected.length; i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                visit(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;

    }
    public void visit(int[][] isConnected, int[] visited, int i){

        for(int j=0; j < isConnected.length; j++){
            if(isConnected[i][j] == 1 && visited[j] == 0)
            {
                visited[i] = 1;
                visit(isConnected, visited, j);
            }
        }
    }

    public static void main(String[] args){
        NumberOfProvinces n = new NumberOfProvinces();
        //int[][] graph = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] graph = new int[][]{{1,0,0}, {0,1,0}, {0,0,1}};

        System.out.println(graph.length);
        System.out.println("Number of provinces = " + n.findCircleNum(graph));
    }
}
