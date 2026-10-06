class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int o=image[sr][sc];
        if(o!=color){
                 dfs(image,sr,sc,color,o);
        }
       
        return image;
    }
    private void dfs(int[][]m,int r,int c,int col,int o)
    {
        if(r<0||r>=m.length||c<0||c>=m[0].length){
            return;
        }
        if(m[r][c]!=o){
            return;
        }
        
             m[r][c]=col;

       
       
        int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
        for(int d[]:dir){
            dfs(m,r+d[0],c+d[1],col,o);
        }

    }
}