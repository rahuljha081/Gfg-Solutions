class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int total_Wt=0;
        int curr=0;
        for(int i=0;i<bt.length;i++){
            total_Wt=total_Wt+curr;
            curr+=bt[i];
        }
        return total_Wt/bt.length;
    }
}
