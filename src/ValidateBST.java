import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            List<Integer> nodeList = new ArrayList<>();
            inOrder(root, nodeList);

            return isSorted(nodeList);
        }

        private boolean isSorted(List<Integer> nodeList) {
            for (int i = 0; i < nodeList.size() - 1; i++) {
                if (nodeList.get(i) > nodeList.get(i + 1)) {
                    return false;
                }
            }

            return true;
        }

        private void inOrder(TreeNode root, List<Integer> nodeList) {
            if (root == null) {
                return;
            }

            inOrder(root.left, nodeList);
            nodeList.add(root.val);
            inOrder(root.right, nodeList);
        }
    }
}
