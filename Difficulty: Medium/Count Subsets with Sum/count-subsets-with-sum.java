class Solution {
    static int solve(int [] arr,int target,int n,int i,int dp[][]){
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        if(i==n){
            if(target==0){
                return 1;
            }else {
                return 0;
            }
        }
        int take=0;
        if(arr[i]<=target){
            take=solve(arr,target-arr[i],n,i+1,dp);
        }
        int skip=solve(arr,target,n,i+1,dp);
        return dp[i][target]=take+skip;
    }
    static int perfectSum(int[] arr, int target) {
        // code here
        int dp[][]=new int[arr.length+1][target+1];
                for(int i=0;i<dp.length;i++){
                    Arrays.fill(dp[i],-1);
                }
        return solve(arr,target,arr.length,0,dp);
    }
}