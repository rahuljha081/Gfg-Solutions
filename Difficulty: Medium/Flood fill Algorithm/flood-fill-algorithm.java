class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int rowDirection[]={0,0,1,-1};
    int colDirection[]={1,-1,0,0};
    boolean isValid(int r,int c,int tr,int tc){
        if(r<tr&&c<tc&&r>=0&&c>=0) return true;
        return false;
    }
    void bfs(int[][] image,Queue<Pair> q,int newColor,int initialColor){
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr_row=p.row;
            int curr_col=p.col;
            for(int i=0;i<4;i++){
                int new_row=curr_row+rowDirection[i];
                int new_col=curr_col+colDirection[i];
                if(isValid(new_row,new_col,image.length,image[0].length)&&image[new_row][new_col]==initialColor){
                    image[new_row][new_col]=newColor;
                    q.add(new Pair(new_row,new_col));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        if(image[sr][sc] == newColor)
    return image;
        Queue<Pair> q=new LinkedList<>();
        int initialColor=image[sr][sc];
        q.add(new Pair(sr,sc));
        image[sr][sc]=newColor;
        bfs(image,q,newColor,initialColor);
        return image;
    }
}