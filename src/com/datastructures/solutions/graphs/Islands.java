package com.datastructures.solutions.graphs;

//Find the number of islands
public class Islands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return -1;
        int[][] visited = new int[grid.length][grid[0].length];
        int totalIslands = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '0')
                    continue;
                else if(visited[i][j] == 1)
                    continue;
                visitIsland(grid, i, j, visited);
                totalIslands++;

                }
            }
            return totalIslands;

        }

        private void visitIsland(char[][] grid, int i, int j, int[][] visited)
        {
            if(i < 0 || i >= grid.length || j < 0 || j>=grid[i].length)
                return;
            if(grid[i][j] == '0')
                return;
            if(visited[i][j] == 1)
                return;
            visited[i][j] = 1;
            visitIsland(grid, i, j-1, visited);
            visitIsland(grid, i, j+1, visited);
            visitIsland(grid, i-1, j, visited);
            visitIsland(grid, i+1, j, visited);
            return;
        }
    public static void main(String[] args)
    {
        Islands island = new Islands();
        char[][] graph1 = new char[][]{{'1','1','1','1','0'},
                                        {'1','1','0','1','0'},
                                        {'1','1','0','0','0'},
                                        {'0','0','0','0','0'}};
        char[][] graph2 = new char[][]{{'1','1','0','0','0'},
                                        {'1','1','0','0','0'},
                                        {'0','0','1','0','0'},
                                         {'0','0','0','1','1'}};

        System.out.println("Number of islands for graph1 = " + island.numIslands(graph1));
        System.out.println("Number of islands for graph2 = " + island.numIslands(graph2));

    }
    }
