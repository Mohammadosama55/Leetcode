class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int d[]:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 &&nr<row && nc>=0 && nc<col && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }

        }
        return mat;
        
        
    }
}