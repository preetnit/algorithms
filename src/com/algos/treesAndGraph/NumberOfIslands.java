package com.algos.treesAndGraph;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        char[][] grid1 = {
                {'0','1','0','0','1'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };


        NumberOfIslands nI = new NumberOfIslands();
        System.out.println(nI.numIslands(grid1));
    }
    /*public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] isVisited = new boolean[m][n];
        int result = 0;

        Queue<String> queue = new LinkedList();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!isVisited[i][j] && grid[i][j] == '1') {
                    isVisited[i][j] = true;
                    queue.add(i+":"+j);
                    while(!queue.isEmpty()) {
                        String[] index = queue.poll().split(":");
                        int a = Integer.valueOf(index[0]);
                        int b = Integer.valueOf(index[1]);

                        pushInQueue(queue,a+1,b, isVisited, grid);
                        pushInQueue(queue,a-1,b, isVisited, grid);
                        pushInQueue(queue,a,b+1, isVisited, grid);
                        pushInQueue(queue,a,b-1, isVisited, grid);
                    }
                    result++;
                }
                isVisited[i][j] = true;
            }
        }
        return result;
    }

    void pushInQueue(Queue<String> queue, int a, int b, boolean[][] isVisited, char[][] grid){
        int m = isVisited.length;
        int n = isVisited[0].length;
        if(0<=a && a<m && 0<=b && b<n && !isVisited[a][b]) {
            isVisited[a][b] = true;
            if(grid[a][b] == '1')
                queue.add(a+":"+b);
        }
    }*/

    char arr[][];
    int count;
    int numIslands(char[][] grid)
    {
        arr=grid;
        count=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }


    void dfs(int i,int j) {
        if(i<0|| j<0 || i>=arr.length|| j>=arr[0].length|| arr[i][j]!='1')
            return;

        arr[i][j]='0';
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
    }
}
