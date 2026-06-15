// User function Template for Java

class Solution {
    int equalSum(int[] arr) {
        // Write your code here
        int prefLeft[]=new int[arr.length];
        int prefRight[]=new int[arr.length];
        prefLeft[0]=0;
        for(int i=1;i<arr.length;i++){
            prefLeft[i]=prefLeft[i-1]+arr[i-1];
        }
        prefRight[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            prefRight[i]=prefRight[i+1]+arr[i+1];
        }
        for(int i=0;i<arr.length;i++){
            if(prefLeft[i]==prefRight[i]){
                return i;
            }
        }
        return -1;
    }
}