// User function Template for Java

class Solution {
    int equalSum(int[] arr) {
        // Write your code here
        int prefix[]=new int[arr.length];
        int suffix[]=new int[arr.length];
        prefix[0]=0;
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        suffix[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]+arr[i+1];
        }
        for(int i=0;i<arr.length;i++){
            if(prefix[i]==suffix[i]) return i;
        }
        return -1;
    }
}