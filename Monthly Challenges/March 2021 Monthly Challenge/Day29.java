import java.util.LinkedList;
import java.util.List;

public class Day29 {
    private List<Integer> flippedNodesIds;
    private int voyageInOrderIdx = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flippedNodesIds = new LinkedList<>();
        voyageInOrderIdx = 0;

        search(root, voyage);
        if (!flippedNodesIds.isEmpty() && flippedNodesIds.get(0) == -1) {
            setNoAnswer();
        }

        return flippedNodesIds;
    }

    public void search(TreeNode node, int[] voyage) {
        if (node == null) {
            return;
        }

        if (node.val != voyage[voyageInOrderIdx++]) {
            setNoAnswer();
            return;
        }

        if (voyageInOrderIdx < voyage.length && node.left != null && node.left.val != voyage[voyageInOrderIdx]) {
            flippedNodesIds.add(node.val);
            search(node.right, voyage);
            search(node.left, voyage);
        } else {
            search(node.left, voyage);
            search(node.right, voyage);
        }
    }

    private void setNoAnswer() {
        flippedNodesIds = new LinkedList<>();
        flippedNodesIds.add(-1);
    }
}
