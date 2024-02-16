/**
 * An abstract base class for a segment tree data structure implemented using a tree structure.
 * Subclasses must implement the {@code queryRange} method to provide specific range query functionality.
 */
public abstract class SegmentTreeByTree implements SegmentTree {

    protected SegmentTreeNode root; // A variable named "root" that will hold the tree
    protected int size; // A variable named "size" that will hold the size of the original array

    /**
     * Constructor for creating a Segment Tree from an input array
     *
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public SegmentTreeByTree(int[] arr) {
        build(arr);
    }

    /**
     * Builds the segment tree from the given array of integers.
     *
     * @param arr the array of integers to build the segment tree from
     */
    @Override
    public void build(int[] arr) {
        size = arr.length;
        int start = 0;
        int end = arr.length - 1;
        root = rec_build_helper(arr, start, end);
    }

    /**
     * A helper function for the constructor
     *
     * @param arr The function receives the array from the original function
     * @param start initialized to 0 (the first member of the array)
     * @param end initialized as the size of the array (the last member of the array)
     * @return The tree segments into the root
     */
    public SegmentTreeNode rec_build_helper(int[] arr, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, arr[start], arr[start], arr[start], null, null);
        }
        int middle = (start + end) / 2;
        SegmentTreeNode left = rec_build_helper(arr, start, middle);
        SegmentTreeNode right = rec_build_helper(arr, middle + 1, end);
        return new SegmentTreeNode(start, end, Math.min(left.getMin(), right.getMin()), Math.max(left.getMax(),
                   right.getMax()), left.getSum() + right.getSum(), left, right);
    }

    /**
     * Updates the element at the specified index in the original array and updates the segment tree accordingly.
     *
     * @param index the index of the element to update
     * @param value the new value of the element at the specified index
     */
    @Override
    public void update(int index, int value) {
        rec_update_helper(index, root, value, 0, size-1);
    }

    /**
     * Update helper function
     *
     * @param index The index we want to change
     * @param node The tree on which we want to make the change
     * @param value The value we want to be in place of the previous value
     * @param start The initial range in which we would like to make the change
     * @param end The final range in which we would like to make the change
     */
    public void rec_update_helper(int index, SegmentTreeNode node, int value, int start, int end) {

        if (node.getStart() == node.getEnd() && node.getStart() == index) {
            node.setSum(value);
            node.setMax(value);
            node.setMin(value);
            return;
        }
        int middle = (start + end) / 2;
        if (index <= middle)
            rec_update_helper(index, (SegmentTreeNode) node.getLeft(), value, start, middle);
        else
            rec_update_helper(index, (SegmentTreeNode) node.getRight(), value, middle + 1, end);

        SegmentTreeNode left = (SegmentTreeNode) node.getLeft();
        SegmentTreeNode right = (SegmentTreeNode) node.getRight();

        node.setMin(Math.min(left.getMin(), right.getMin()));
        node.setMax(Math.max(left.getMax(), right.getMax()));
        node.setSum(left.getSum() + right.getSum());
    }

    /**
     * Returns the number of elements in the original array that the segment tree was built from.
     *
     * @return the size of the original array
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Queries the Segment Tree for the minimum value in the given range. to be implemented by subclasses.
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return Minimum value in the given range
     */
    @Override
    public abstract int queryRange(int left, int right);
    /**
     * Helper method for querying the Segment Tree 
     * @param node Current node of the Segment Tree
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return A SegmentTreeNode that contains the minimum, maximum and summation values for the given range
     */
    protected SegmentTreeNode queryRangeHelper(SegmentTreeNode node, int left, int right) {
        if (node.getStart() >= left && node.getEnd() <= right){
            return node;
        }
        int middle = (node.getStart() + node.getEnd())/2;
        if (right <= middle){
            return(queryRangeHelper((SegmentTreeNode)node.getLeft(), left, right));
        } else if (left > middle) {
            return (queryRangeHelper((SegmentTreeNode)node.getRight(),left,right ));
        }
        else {
            SegmentTreeNode n_left = queryRangeHelper((SegmentTreeNode)node.getLeft(),left, middle);
            SegmentTreeNode n_right = queryRangeHelper((SegmentTreeNode)node.getRight(), middle + 1, right);
            int min = Math.min(n_left.getMin(), n_right.getMin());
            int max = Math.max(n_left.getMax(), n_right.getMax());
            int sum = n_left.getSum() + n_right.getSum();
            return (new SegmentTreeNode(left, right, min, max, sum, n_left, n_right));
        }
    }

    /**
     * The function performs a "pre order" search
     * @param node The tree on which we want to perform the search
     * @return the search results in order as a string
     */
    public String pre_order_tree(SegmentTreeNode node){
        if (node == null)
            return "";
        return type_node(node) + " " + pre_order_tree((SegmentTreeNode) node.getLeft())
                + pre_order_tree((SegmentTreeNode)node.getRight());
    }

    /**
     * The function receives from the inheritors the tree type
     * @param node A tree of a certain type (max, min or sum)
     * @return to the original function the string of the search
     */
    protected abstract String type_node(SegmentTreeNode node);
}

