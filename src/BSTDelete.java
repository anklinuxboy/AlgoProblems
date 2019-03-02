public class BSTDelete {

    public static void main(String[] args) {
        BSTDelete bstDelete = new BSTDelete();
        TreeNode node = new TreeNode(0);

        TreeNode root = bstDelete.deleteNode(node, 0);
        System.out.println(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = search(root, key);
        if (node == null || (root.val == key && root.left == null && root.right == null)) {
            return null;
        }

        if (node.left == null) {
            switchParent(root, node, node.right);
        } else if (node.right == null) {
            switchParent(root, node, node.left);
        } else {
            TreeNode temp = minimum(node.right);
            if (temp != node.right) {
                switchParent(root, temp, temp.right);
                temp.right = node.right;
            }

            switchParent(root, node, temp);
            temp.left = node.left;
        }

        return root;
    }

    private TreeNode search(TreeNode root, int key) {
        TreeNode traverse = root;
        while (traverse != null) {
            if (traverse.val == key) {
                return traverse;
            } else if (traverse.val > key) {
                traverse = traverse.left;
            } else {
                traverse = traverse.right;
            }
        }

        return null;
    }

    private TreeNode minimum(TreeNode node) {
        TreeNode traverse = node;
        while (traverse.left != null) {
            traverse = traverse.left;
        }

        return traverse;
    }

    private void switchParent(TreeNode root, TreeNode u, TreeNode v) {
        if (u == null) {
            root = v;
            return;
        }

        TreeNode uParent = parent(root, u.val);
        if (u == uParent.left) {
            uParent.left = v;
        } else {
            uParent.right = v;
        }
        if (v != null) {
            TreeNode vParent = parent(root, v.val);
            if (vParent != null) {
                vParent = uParent;
            }
        }
    }

    private TreeNode parent(TreeNode root, int key) {
        TreeNode traverse = root;
        TreeNode parent = null;

        while (traverse != null && traverse.val != key) {
            parent = traverse;
            if (traverse.val > key) {
                traverse = traverse.left;
            } else {
                traverse = traverse.right;
            }
        }

        if (parent != null && parent.left != null && parent.right != null) {
            if (parent.left.val == key || parent.right.val == key) {
                return parent;
            }
        }

        return null;
    }
}
