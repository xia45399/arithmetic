package arithmetic.traversal;

import arithmetic.pojo.TreeNode;

/**
 * 中序遍历
 */
public class InorderTraversal {

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
        System.out.println(tree.val);
        if (tree.right != null) {
            print(tree.right);
        }

    }
}
