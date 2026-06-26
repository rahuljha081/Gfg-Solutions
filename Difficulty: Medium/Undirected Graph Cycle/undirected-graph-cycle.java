class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean vis[]=new boolean[V];
        Queue<Pair> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for(int j=0;j<V;j++){
           if(vis[j]==false){
            q.add(new Pair(j,-1));
            vis[j]=true;
            while(!q.isEmpty()){
                Pair p=q.poll();
                int val=p.node;
                int par=p.parent;
                for(int i=0;i<adj.get(val).size();i++){
                    int neigh=adj.get(val).get(i);
                    if(vis[neigh]==true){
                        if(neigh!=par)
                        return true;
                    }else{
                        vis[neigh]=true;
                        q.add(new Pair(neigh,val));
                    }
                }
            }
          }
       }
        return false;
    }
}