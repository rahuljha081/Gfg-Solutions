class Solution {
    static boolean solve(int [] arr,int sum,int n,int i,int dp[][]){
        if(dp[i][sum]!=-1){
            if(dp[i][sum]==0) return false;
            return true;
        }
        if(i==n){
            if(sum==0) return true;
            else return false;
        }
        boolean take=false;
        if(arr[i]<=sum){
            take=solve(arr,sum-arr[i],n,i+1,dp);
        }
        boolean skip=solve(arr,sum,n,i+1,dp);
        if(take||skip){
            dp[i][sum]=1;
        }else{
            dp[i][sum]=0;
        
        }
        return take||skip;
    }
    static boolean isSubsetSum(int arr[], int sum) {
        int dp[][]=new int[arr.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr, sum,arr.length,0,dp);
    }
}