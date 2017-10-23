import java.util.*;

public class ThreeSum {
    public static void main(String ... args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        lists.stream().forEach(l -> l.stream().forEach(ll -> System.out.print(ll + " ")));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++) {
            if (i==0 || (i > 0 && nums[i] != nums[i-1])) {  //avoid duplicates
                int lo = i+1, hi = nums.length-1;
                while(lo < hi) {
                    if (nums[lo] + nums[hi] == -nums[i]) {
                        lists.add(Arrays.asList(nums[lo], nums[hi], nums[i]));
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; 
                        hi--;
                    } else if (nums[lo] + nums[hi] > -nums[i]) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        
        return lists;
    }
}