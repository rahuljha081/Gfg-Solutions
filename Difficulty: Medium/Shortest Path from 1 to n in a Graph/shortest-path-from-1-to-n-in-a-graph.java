class Solution {
    class Pair{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<Integer> res=new ArrayList<>();
        int dist[]=new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[1]=0;
        int parent[]=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int dis=edges[i][2];
            adj.get(from).add(new Pair(to,dis));
            adj.get(to).add(new Pair(from,dis));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int curr_node=p.node;
            int curr_dist=p.distance;
            for(int i=0;i<adj.get(curr_node).size();i++){
                int new_node=adj.get(curr_node).get(i).node;
                int new_dist=adj.get(curr_node).get(i).distance+dist[curr_node];
                if(dist[new_node]>new_dist){
                    parent[new_node]=curr_node;
                    dist[new_node]=new_dist;
                    pq.add(new Pair(new_node,new_dist));
                }
            }
        }
        if(dist[n]==Integer.MAX_VALUE) return Arrays.asList(-1);
        int j=n;
        while(parent[j]!=j){
            res.add(j);
            j=parent[j];
        }
        res.add(1);
        Collections.reverse(res);
        res.add(0,dist[n]);
        return res;
    }
}