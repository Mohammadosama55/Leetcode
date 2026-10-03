class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][]v=new boolean[row][col];
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        int maxarea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !v[i][j]){
                    int area=bfs(grid,v,i,j,dir);
                    maxarea=Math.max(area,maxarea);
                }
            }
        }
        return maxarea;
    }
    private int bfs(int [][]grid,boolean[][]v,int r,int c,int[][]dir){
        Queue<int[]>q=new LinkedList<>();
        v[r][c]=true;
        q.add(new int[]{r,c});
        int area=0;
        while(!q.isEmpty()){
            int []cell=q.poll();
            int cr=cell[0];
            int cc=cell[1];
            area++;
            for(int []d:dir){
                int nr=cr+d[0];
                int nc=cc+d[1];
                if(nr>=0&&nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1 && !v[nr][nc]){
                    v[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return area;
    }
}