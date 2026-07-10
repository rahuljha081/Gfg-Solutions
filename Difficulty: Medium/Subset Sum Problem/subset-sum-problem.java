class Solution {
    static boolean solve(int arr[],int sum,int n,int i,int dp[][]){
        if(i==n){
            if(sum==0) {
                return true;
            }else{
                return false;
            }
        }
        if(dp[i][sum]!=-1){
            if(dp[i][sum]==1) return true;
            return false;
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
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int dp[][]=new int[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;i++){
            for(int j=0;j<sum+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(arr,sum,arr.length,0,dp);
    }
}