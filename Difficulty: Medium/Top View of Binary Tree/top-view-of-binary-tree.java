/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Pair{
        int idx;
        Node node;
        Pair(int idx,Node node){
            this.idx=idx;
            this.node=node;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                size--;
                Pair p=q.poll();
                if(!map.containsKey(p.idx)){
                       map.put(p.idx, p.node.data);
                 } 
                if(p.node.left!=null){
                    q.add(new Pair(p.idx-1,p.node.left));
                }
                if(p.node.right!=null){
                    q.add(new Pair(p.idx+1,p.node.right));
                }
            }
        }
        for(int val:map.keySet()){
            arr.add(map.get(val));
        }
        return arr;
        
    }
}