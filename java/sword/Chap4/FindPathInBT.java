package sword.Chap4;

/**
 * Create by 王鹏龙 on 2019-07-22 20:36
 */
import java.util.ArrayList;

class FindPathInBST {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * @param root 二叉树根结点
     * @param target 目标值
     * @return 所有和目标值相同的路径上结点的集合
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root, target, path, res);
        return res;
    }

    /**
     *
     * @param root 根节点
     * @param curVal 当前结点的值
     * @param path 路径
     * @param res   结果
     */
    private void preOrder(TreeNode root, int curVal,ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        // 模拟结点进栈
        path.add(root.val);
        curVal -= root.val;
        // 只有在叶子结点处才判断是否和目标值相同，若相同加入列表中
        if (root.left == null && root.right == null) {
            if (curVal == 0) res.add(new ArrayList<>(path));
        }
        preOrder(root.left, curVal, path, res);
        preOrder(root.right, curVal, path, res);
        // 模拟结点出栈
        path.remove(path.size() - 1);
        curVal += root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(7);
        TreeNode r4 = new TreeNode(12);
        root.left = r1;
        r1.left = r2;
        r1.right = r3;
        root.right = r4;
        FindPathInBST f = new FindPathInBST();
        ArrayList<ArrayList<Integer>> a = f.FindPath(root,22);
        for (ArrayList<Integer> res : a) {
            res.toString();
            System.out.println(res.toString());
        }
    }
}
