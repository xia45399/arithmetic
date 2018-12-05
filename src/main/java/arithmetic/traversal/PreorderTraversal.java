package arithmetic.traversal;

import arithmetic.pojo.TreeNode;

/**
 * 前序遍历
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.defaultTree();
        print(tree);
    }

    /**
     * 打印前序遍历
     */
    private static void print(TreeNode tree) {


        System.out.println(tree.val);
        if (tree.left != null) {
            print(tree.left);
        }
        if (tree.right != null) {
            print(tree.right);
        }
    }
}
