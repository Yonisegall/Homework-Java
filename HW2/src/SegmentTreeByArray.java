/**
 * This abstract class represents a segment tree implementation using an array
 * and provides methods to build, update, and query the tree.
 */
public abstract class SegmentTreeByArray implements SegmentTree {
     
	 protected int[] tree; // A variable named "tree" that will hold the array that represents the tree
	 protected int size; // A variable named "size" that will hold the size of the original array

    /**
     * Constructor for initializing the segment tree with the given input array.
     * @param arr the input array
     */
    public SegmentTreeByArray(int[] arr) {
        build(arr);
    }

    /**
     * Builds the segment tree from the input array.
     * @param arr the input array
     */
    @Override
    public void build(int[] arr) {
        size = arr.length;
        int start = 0;
        int end = size - 1;
        tree = new int[2 * (int) Math.pow(2,Math.ceil(Math.log(size)/Math.log(2)))- 1];
        for (int i = 0; i < tree.length; i ++){
            tree[i] = Integer.MAX_VALUE;
        }
        build_rec_helper(arr, start+1, end+1, 1);
    }

    /**
     * A helper function for the constructor
     *
     * @param arr The function receives the array from the original function
     * @param start initialized to 0 (the first member of the array)
     * @param end initialized as the size of the array (the last member of the array)
     * @param i A number that runs over the indexes in the new array that represents the tree
     */
    public void build_rec_helper (int[] arr, int start, int end, int i) {
        if (start == end)
            tree[i - 1] = arr[start-1];
        else {
            int middle = (start + end) / 2;
            build_rec_helper(arr, start, middle, i * 2);
            build_rec_helper(arr, middle + 1, end, (i * 2) + 1);
            tree[i - 1] = array_type(tree[i * 2 - 1], tree[i * 2]);
        }
    }

    /**
     * An abstract function that "asks" the inheritors what type they are (minimum, maximum and summation)
     * @param a The left son of the current node
     * @param b The right son of the current node
     */
    protected abstract int array_type(int a, int b);

    /**
     * Updates the value at the specified index and updates the segment tree accordingly.
     * @param index the index of the element to update in the array
     * @param value the new value to replace the existing value
     */
    @Override
    public void update(int index, int value) {
        update_helper(index, value, 1, 0, size - 1);
    }

    /**
     * Update helper function
     *
     * @param index The index we want to change
     * @param value The value we want to be in place of the previous value
     * @param i A number that runs over the indexes in the new array that represents the tree
     * @param start The initial range in which we would like to make the change
     * @param end The final range in which we would like to make the change
     */
    public void update_helper(int index, int value, int i, int start, int end){
        if (start  == index  && end  == index)
            tree[i-1] = value;
        else {
            int middle = (start + end)/2;
            if (index <= middle)
                update_helper(index, value, i*2, start, middle);
            else
                update_helper(index, value, i*2+1, middle + 1, end);
            int left = tree[i*2-1];
            int right = tree[i*2];
            tree[i-1] = array_type(left, right);
        }
    }

    /**
     * Queries the segment tree for a range of elements.
     * @param left the left index of the range
     * @param right the right index of the range
     * @return the result of the query operation
     */
    @Override
    public int queryRange(int left, int right) {
        return query(1, 1, size , left, right);
    }

    /**
     * Abstract method for query operation, to be implemented by subclasses.
     * @param node the current node
     * @param start the start index
     * @param end the end index
     * @param left the left index
     * @param right the right index
     * @return the result of the query operation
     */
    protected abstract int query(int node, int start, int end, int left, int right);

    /**
     * The members inside the array representing the segment tree are printed according to their indexes in the array.
	 * When the members are surrounded by "[ ]" and exactly one space between each number and between the brackets. 
	 * For example, for the tree [10,4,6,1,3,2,4] " [ 10 4 6 1 3 2 4 ] " will be returned 
     */
    @Override
    public String toString() {
        String result = " [";
        int i = 0;
        while (i < tree.length){
            if (tree[i] == Integer.MAX_VALUE)
                result +=  " -";
            else
                result += " " + tree[i] ;
            i++;
        }
        return result + " ] ";
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
}
