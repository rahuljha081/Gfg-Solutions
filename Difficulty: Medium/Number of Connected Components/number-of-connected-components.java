class Solution {
    void bfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],Queue<Integer> q){
        while(!q.isEmpty()){
            int val=q.poll();
            vis[val]=true;
            for(int j=0;j<adj.get(val).size();j++){
                if(vis[adj.get(val).get(j)]==false){
                     q.add(adj.get(val).get(j));
                }
            }
        }
    }
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int to=edges.get(i).get(0);
            int from=edges.get(i).get(1);
            adj.get(to).add(from);
            adj.get(from).add(to);
        }
        boolean vis[]=new boolean[V];
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                
                q.add(i);
                count++;
                bfs(adj,vis,q);
            }
        }
        return count;
        
    }
}