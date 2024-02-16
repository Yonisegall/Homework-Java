public class SummationSegmentTreeByArray extends SegmentTreeByArray{
    /**
     * Constructor for initializing the segment tree with the given input array.
     *
     * @param arr the input array
     */
    public SummationSegmentTreeByArray(int[] arr) {
        super(arr);
    }

    /**
     * The function returns the summation value to the original function
     *
     * @param a The left son of the current node
     * @param b The right son of the current node
     * @return the summation between a and b
     */
    @Override
    protected int array_type(int a, int b) {
        return a + b;
    }

    /**
     * The function receives an array with a certain range and returns
     the value from which the other values in the given range come from

     * @param node the current node
     * @param start the start index
     * @param end the end index
     * @param left the left index
     * @param right the right index
     * @return the new "root" of the tree in the given range
     */
    @Override
    protected int query(int node, int start, int end, int left, int right) {
        if (start >= left + 1 && end <= right + 1){
            return tree[node-1];
        }
        int middle = (start+end)/2;
        if (right < middle) {
            return query(node * 2, start, middle, left, right);
        }
        else if (left >= middle){
            return query(node * 2+ 1,middle +1, end, left, right);
        }
        else {
            int left_new = query(node * 2, start, middle, left, right);
            int right_new = query(node * 2+ 1,middle +1, end, left, right);
            return (left_new + right_new);
        }
    }
}
