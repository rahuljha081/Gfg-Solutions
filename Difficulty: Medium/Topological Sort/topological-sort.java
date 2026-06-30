class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[V];
        for(int i=0;i<edges.length;i++){
            int to=edges[i][1];
            indegree[to]++;
        }
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val=q.poll();
            res.add(val);
            for(int i=0;i<adj.get(val).size();i++){
                indegree[adj.get(val).get(i)]--;
                if(indegree[adj.get(val).get(i)]==0){
                    q.add(adj.get(val).get(i));
                }
            }
        }
        return res;
    }
}