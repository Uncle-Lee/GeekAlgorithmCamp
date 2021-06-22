class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        if(digits[size - 1] + 1 >= 10) {
            for(int i = size - 1; i >= 0; i --) {
                if(digits[i] + 1 >= 10) {
                    digits[i] = digits[i] + 1 - 10;
                } else {
                    digits[i] += 1;
                    return digits;
                }
            }
            int[] result = new int[size + 1];
            result[0] = 1;
            return result;
        } else {
            digits[size - 1] += 1;
            return digits;
        }
    }
}