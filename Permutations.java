import java.util.*;

public class Permutations {
    public static void main(String ... args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length == 0)
            return res;
        
        boolean [] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums, visited, list, res);
        return res;
    }
    
    private static void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}