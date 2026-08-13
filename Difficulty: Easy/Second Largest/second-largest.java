class Solution {
    public int getSecondLargest(int[] nums) {
        // code here
        int second_max=-1;
        int max=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                second_max=max;
                max=nums[i];
            }
            else if(nums[i]<max&&nums[i]>second_max){
                second_max=nums[i];
            }
        }
        return second_max;
    }
}