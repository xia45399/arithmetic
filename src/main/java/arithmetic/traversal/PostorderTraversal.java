package arithmetic.traversal;

import arithmetic.pojo.TreeNode;

/**
 * 后序遍历
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.defaultTree();
        print(tree);
    }

    /**
     * 打印前序遍历
     */
    private static void print(TreeNode tree) {
        if (tree.left != null) {
            print(tree.left);
        }
        if (tree.right != null) {
            print(tree.right);
        }
        System.out.println(tree.val);

    }
}
