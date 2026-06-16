class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int wt=edges[i][2];
            adj.get(from).add(new Pair(to,wt));
            adj.get(to).add(new Pair(from,wt));
        }
        int [] ans=new int[V];
        for(int i=0;i<ans.length;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        ans[src]=0;
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int val=p.node;
            for(int i=0;i<adj.get(val).size();i++){
                int neigh=adj.get(val).get(i).node;
                int wtt=adj.get(val).get(i).dist;
                if(ans[neigh]>ans[val]+wtt){
                    ans[neigh]=ans[val]+wtt;
                    pq.add(new Pair(neigh,ans[val]+wtt));
                }
            }
        }
        return ans;
    }
}