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
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null) return arr;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int value=-1;
            while(size>0){
                size--;
                Node node=q.poll();
                if(value==-1){
                    value=node.data;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            arr.add(value);
            
        }
        return arr;
    }
}