class Solution {
    class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int wt=edges[i][2];
            adj.get(from).add(new Pair(to,wt));
            adj.get(to).add(new Pair(from,wt));
        }
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int curr_node=p.node;
            int curr_dist=p.dis;
            for(int i=0;i<adj.get(curr_node).size();i++){
                int neigh_node=adj.get(curr_node).get(i).node;
                int neigh_wt=adj.get(curr_node).get(i).dis;
                if(dist[neigh_node]>curr_dist+neigh_wt){
                    dist[neigh_node]=curr_dist+neigh_wt;
                    pq.add(new Pair(neigh_node,curr_dist+neigh_wt));
                }
            }
        }
        return dist;
    }
}