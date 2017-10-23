import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String ... args) {
        int[] nums = {10,9,2,5,3,4};
        System.out.println(test(nums));
    }

    private static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] sequence = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(sequence, 0, len, nums[i]);
            if (index < 0) {
                index = - index - 1;
            }
            sequence[index] = nums[i];
            if (index >= len) {
                len++;
            }
        }
        return len;
    }
}