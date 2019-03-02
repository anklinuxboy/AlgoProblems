import java.util.Stack;

public class KSmallestElementBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> leftTree = new Stack<>();

        TreeNode traverse = root;
        while (traverse != null) {
            leftTree.push(traverse.val);
            traverse = traverse.left;
        }

        int kthSmallest = 0;

        for (int i = 0; i < k; i++) {
            if (!leftTree.isEmpty())
                kthSmallest = leftTree.pop();
        }

        return kthSmallest;
    }
}
