class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; 
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node = curr.node;
            int currDist = curr.wt;
            if (currDist > dist[node]) continue;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int neigh = adj.get(node).get(i).node;
                int wtt = adj.get(node).get(i).wt;
                if (dist[neigh] > dist[node] + wtt) {
                    dist[neigh] = dist[node] + wtt;
                    parent[neigh] = node;
                    pq.add(new Pair(neigh, dist[neigh]));
                }
            }
        }
         if (dist[n] == Integer.MAX_VALUE) return Arrays.asList(-1);
        List<Integer> path = new ArrayList<>();
        int node = n;
        while(parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0,dist[n]);
        return path;
    }
}