class Solution {
    public int findShortestSubArray(int[] nums) {

        //int[] 数组共使用3位,
        //int[0]记录当前key出现的次数
        //int[1]记录该key出现的起始位置
        //int[2]记录该key出现的终点位置
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();

        //扫描记录每个元素的出现次数和起始终止位置
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        //循环寻找出现次数最多的元素，次数一样，找到长度最短的
        int maxNum = 0, minLen = 0;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] v = entry.getValue();
            if(maxNum < v[0]) {
                maxNum = v[0];
                minLen = v[2] - v[1] + 1;
            } else if(maxNum == v[0]) {
                if(minLen > v[2] - v[1] + 1) {
                    minLen = v[2] - v[1] + 1;
                }
            }
        }
        return minLen;
    }
}