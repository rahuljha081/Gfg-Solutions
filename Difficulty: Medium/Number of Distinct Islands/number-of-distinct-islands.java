class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    boolean isValid(int r,int c,int tr,int tc){
        if(r<tr&&c<tc&&r>=0&&c>=0) return true;
        return false;
    }
    int rowDirection[]={0,0,-1,1};
    int colDirection[]={1,-1,0,0};
    ArrayList<ArrayList<Integer>> solve(char[][] grid,boolean vis[][],Queue<Pair>q,int baserow,int basecol){
        ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr_row=p.row;
            int curr_col=p.col;
            int rowD=curr_row-baserow;
            int colD=curr_col-basecol;
            temp.add(new ArrayList<>(Arrays.asList(rowD, colD)));
            for(int i=0;i<4;i++){
                int new_row=curr_row+rowDirection[i];
                int new_col=curr_col+colDirection[i];
                if(isValid(new_row,new_col,grid.length,grid[0].length)&&vis[new_row][new_col]==false&&grid[new_row][new_col]=='L'){
                    q.add(new Pair(new_row,new_col));
                    vis[new_row][new_col]=true;
                }
            }
        }
        return temp;
    }
    public int countDistinctIslands(char[][] grid) {
        // code here
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        HashSet<ArrayList<ArrayList<Integer>>> set=new HashSet<>();
        int count=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==false&&grid[i][j]=='L'){
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                    ArrayList<ArrayList<Integer>> arr=solve(grid,vis,q,i,j);
                    if(!set.contains(arr)){
                        count++;
                        set.add(arr);
                    }
                }
            }
        }
        return count;
    }
}