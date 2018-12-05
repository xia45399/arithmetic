package arithmetic.pojo;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 1
     * 2         3
     * 4    5    6    7
     * 8   9
     *
     * @return
     */
    public static TreeNode defaultTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);
        return node;
    }
}
