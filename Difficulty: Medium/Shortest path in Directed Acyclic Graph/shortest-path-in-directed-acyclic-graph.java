class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int wt=edges[i][2];
            adj.get(from).add(new Pair(to,wt));
        }
        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[V];
        for(int i=0;i<edges.length;i++){
            int to=edges[i][1];
            indegree[to]++;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int val=q.poll();
            topo.add(val);
            for(int i=0;i<adj.get(val).size();i++){
                int neigh=adj.get(val).get(i).node;
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }
        }
        int [] dis=new int[V];
        for(int i=0;i<dis.length;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0]=0;
        for(int i=0;i<topo.size();i++){
            int val=topo.get(i);
            for(int j=0;j<adj.get(val).size();j++){
                int neigh=adj.get(val).get(j).node;
                if(dis[val]!=Integer.MAX_VALUE){
                    if(dis[neigh]>dis[val]+adj.get(val).get(j).dist){
                         dis[neigh]=dis[val]+adj.get(val).get(j).dist;
                     }
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i]=-1;
            }
        }
        return dis;
       
    }
}