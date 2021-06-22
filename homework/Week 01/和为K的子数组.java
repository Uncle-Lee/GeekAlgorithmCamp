class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;;
        for (int i = 0; i <= nums.length - 1; i++) {
            sum = nums[i];
            if(sum == k) {
                result++;
            }
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (sum + nums[j] == k) {
                    result++;
                }
                sum += nums[j];
            }
        }
        return result;
    }
}