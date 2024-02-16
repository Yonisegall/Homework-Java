public class MinimumSegmentTreeByTree extends SegmentTreeByTree{
    /**
     * Constructor for creating a Segment Tree from an input array
     *
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public MinimumSegmentTreeByTree(int[] arr) {
        super(arr);
    }

    /**
     *The function sends the root and returns the tree after an update
     *
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Minimum segment tree
     */
    @Override
    public int queryRange(int left, int right) {
        SegmentTreeNode node = queryRangeHelper(root,left,right);
        return node.getMin();
    }

    /**
     * The function returns the nodes of the tree as a string
     * @return A string of search results
     */
    public String toString() {
        return " [ " + pre_order_tree(root) + "] ";
    }

    /**
     * An abstract function that returns the type of tree
     *
     * @param node A tree of a certain type (max, min or sum)
     * @return Minimum type segment tree
     */
    @Override
    public String type_node(SegmentTreeNode node) {
        return (""+node.getMin()+"");
    }
}
