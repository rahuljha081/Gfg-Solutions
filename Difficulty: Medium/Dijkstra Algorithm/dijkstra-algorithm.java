class Solution {
    class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
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
            int dis=edges[i][2];
            adj.get(from).add(new Pair(to,dis));
            adj.get(to).add(new Pair(from,dis));
        }
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.distance-b.distance);
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr_node=p.node;
            int curr_dist=p.distance;
            for(int i=0;i<adj.get(curr_node).size();i++){
                int new_node=adj.get(curr_node).get(i).node;
                int new_dist=adj.get(curr_node).get(i).distance;
                if(dist[new_node]>curr_dist+new_dist){
                    dist[new_node]=curr_dist+new_dist;
                    q.add(new Pair(new_node,curr_dist+new_dist));
                }
            }
        }
        return dist;
    }
}