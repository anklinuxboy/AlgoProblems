public class MaximumBinaryTree {
    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

        TreeNode node = maximumBinaryTree.constructMaximumBinaryTree(nums);

        maximumBinaryTree.inOrder(node);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        MaxNumber maxNumber = findMax(nums, 0, nums.length - 1);
        int value = maxNumber.value;
        int index = maxNumber.index;

        TreeNode root = new TreeNode(value);
        buildMaxBinary(root, nums, 0, index - 1, index);
        buildMaxBinary(root, nums, index + 1, nums.length - 1, index);

        return root;
    }

    private void buildMaxBinary(TreeNode node, int[] nums, int start, int stop, int partition) {
        if (start < 0 || stop >= nums.length || start > stop) return;

        MaxNumber maxNumber = findMax(nums, start, stop);
        int value = maxNumber.value;
        int index = maxNumber.index;

        TreeNode child = new TreeNode(value);
        if (start < partition) node.left = child;
        if (start > partition) node.right = child;

        buildMaxBinary(child, nums, start, index - 1, index);
        buildMaxBinary(child, nums, index + 1, stop, index);
    }

    private MaxNumber findMax(int[] nums, int start, int stop) {
        int maxIndex = start;
        int maxValue = nums[start];

        for (int i = start; i <= stop; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        return new MaxNumber(maxValue, maxIndex);
    }

    private class MaxNumber {
        int value;
        int index;

        MaxNumber(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
