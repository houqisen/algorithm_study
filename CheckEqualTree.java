import java.util.HashMap;
import java.util.Map;

public class CheckEqualTree {
    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int value) {
            this.val = value;
        }
    }

    public static void main(String ... args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(1);
        /*
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(20);
*/
        System.out.println(checkEqualTree(root));
    }

    public static boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = getsum(root, map);
        if(sum == 0)return map.getOrDefault(sum, 0) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    
    public static int getsum(TreeNode root, Map<Integer, Integer> map ){
        if(root == null)return 0;
        int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
        map.put(cur, map.getOrDefault(cur,0) + 1);
        return cur;
    }
}