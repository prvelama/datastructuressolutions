package com.optimusride.hackerrank.solutions;
/*
Given a warehouse map, determine the number of distinct paths
from warehouse[0][0] to warehouse[n-1][m-1]
*/

public class UniquePaths {
    int count;
    public void numberOfUniquePaths(int[][] warehouse){
        int rows = warehouse.length;
        int columns = warehouse[0].length;
        count = 0;
        if(warehouse[0][0] == 0 || warehouse[rows-1][columns-1] == 0)
            return;
        visit(0, 0, warehouse);

    }

    public void visit(int i, int j, int[][] warehouse)
    {
        //System.out.println("visited "+ i + " "+ j);
        if(i == warehouse.length - 1 && j == warehouse[i].length - 1) {
            count++;
            return;
        }
        if(i >= warehouse.length || j >= warehouse[i].length)
            return;
        if(warehouse[i][j] == 0)
            return;
        visit(i, j+1, warehouse);
        visit(i+1, j, warehouse);

    }
    public static void main(String[] args)
    {
        UniquePaths paths = new UniquePaths();
        int[][] warehouse1 = new int[][]{{1,1,0,1},{1,1,1,1}};
        int[][] warehouse2 = new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        paths.numberOfUniquePaths(warehouse1);
        System.out.println("Number of distinct paths for warehouse1 = " + paths.count);
        paths.numberOfUniquePaths(warehouse2);
        System.out.println("Number of distinct paths for warehouse2 = " + paths.count);
    }
}
