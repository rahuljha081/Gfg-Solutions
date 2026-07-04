class Solution {
    int solve(int[] height,int i,int n,int dp[]){
        if(i>=n-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int one=Math.abs(height[i]-height[i+1])+solve(height,i+1,n,dp);
        int two=Integer.MAX_VALUE;
        if(i<n-2){
             two=Math.abs(height[i]-height[i+2])+solve(height,i+2,n,dp);
        }
        return dp[i]=Math.min(one,two);
    }
    int minCost(int[] height) {
        // code here
        
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(height,0,n,dp);
    }
}