class Solution {
    int dp[][];
    int solve(int [] arr,int totalSum,int tempSum,int diff,int n,int i){
         if(i==n){
            if(tempSum <= totalSum - tempSum &&Math.abs(tempSum-(totalSum-tempSum))==diff){
             return 1;
             }
             return 0;
        }
        if(dp[i][tempSum]!=-1){
            return dp[i][tempSum];
        }
        int take=solve(arr,totalSum,tempSum+arr[i],diff,n,i+1);
        int skip=solve(arr,totalSum,tempSum,diff,n,i+1);
        return dp[i][tempSum]=take+skip;
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int totalSum=0;
        for(int num:arr){
            totalSum+=num;
        }
         dp=new int[arr.length][totalSum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,totalSum,0,diff,arr.length,0);
        
    }
}
