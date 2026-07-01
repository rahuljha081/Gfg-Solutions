class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int rowDirection[]={0,0,-1,1};
    int colDirection[]={1,-1,0,0};
    boolean isValid(int r,int c,int tr,int tc){
        if(r<tr&&c<tc&&r>=0&&c>=0)return true;
        return false;
    }
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        // code here
        if(mat[src[0]][src[1]]==0) return -1;
        if(src[0]==dest[0]&&src[1]==dest[1]) return 0;
        mat[src[0]][src[1]]=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src[0],src[1]));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr_row=p.row;
            int curr_col=p.col;
            for(int i=0;i<4;i++){
                int new_row=curr_row+rowDirection[i];
                int new_col=curr_col+colDirection[i];
                if(isValid(new_row,new_col,mat.length,mat[0].length)&&mat[new_row][new_col]==1){
                    if(new_row==dest[0]&&new_col==dest[1]){
                        return mat[curr_row][curr_col]+1;
                    }
                    mat[new_row][new_col]+=mat[curr_row][curr_col];
                    q.add(new Pair(new_row,new_col));
                }
            }
        }
        return -1;
    }
}