/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    void RightV(ArrayList<Integer> arr,Node root,HashSet<Integer> set){
        if(root==null) return;
         if(root.left==null&&root.right==null) return;
        if(root.right!=null){
            RightV(arr,root.right,set);
        }else{
             RightV(arr,root.left,set);
        }
        if(!set.contains(root.data)){
                arr.add(root.data);
                set.add(root.data);
          }
    }
    void BottomV(ArrayList<Integer> arr,Node root,HashSet<Integer> set){
        if(root==null) return;
         BottomV(arr,root.left,set);
        if(root.left==null&&root.right==null){
            
            if(!set.contains(root.data)){
                arr.add(root.data);
                set.add(root.data);
            }
        }
       
        BottomV(arr,root.right,set);
    }
    void leftB(ArrayList<Integer> arr,Node root,HashSet<Integer> set){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        if(!set.contains(root.data)){
            arr.add(root.data);
            set.add(root.data);
        }
        if(root.left!=null){
            leftB(arr,root.left,set);
            
        }else{
            leftB(arr,root.right,set);
        }
        
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        if(root == null) return arr;
        HashSet<Integer> set=new HashSet<>();
        arr.add(root.data);
        set.add(root.data);
        leftB(arr,root.left,set);
        BottomV(arr,root,set);
        RightV(arr,root.right,set);
        return arr;
    }
    
}