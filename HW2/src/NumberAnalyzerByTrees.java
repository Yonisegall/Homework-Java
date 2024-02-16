
public class NumberAnalyzerByTrees extends NumberAnalyzer{
    /**
     * Constructs a new NumberAnalyzer object with the given array of integers.
     *
     * @param numbers The array of integers to be analyzed.
     */
    private MaximumSegmentTreeByTree max_tree; // A variable of type MaximumSegmentTreeByTree
    private  MinimumSegmentTreeByTree min_tree; // A variable of type MinimumSegmentTreeByTree
    private SummationSegmentTreeByTree sum_tree; // A variable of type SummationSegmentTreeByTree

    /**
     * The constructor receives an array with values and creates the variables according
       to the values in the given array
     *
     * @param numbers An array with given values
     */
    public NumberAnalyzerByTrees(Integer[] numbers) {
        super(numbers);
        int[] new_arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            new_arr[i] = numbers[i];
        }
        min_tree = new MinimumSegmentTreeByTree(new_arr);
        max_tree = new MaximumSegmentTreeByTree(new_arr);
        sum_tree = new SummationSegmentTreeByTree(new_arr);
    }

    /**
     * The function accepts a left and right range and returns the value from which
       all the given values in the range come from

     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return the maximum tree according to the given range
     */
    @Override
    public Integer getMax(int left, int right) {
        return max_tree.queryRange(left,right);
    }

    /**
     * The function accepts a left and right range and returns the value from which
       all the given values in the range come from

     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return the minimum tree according to the given range
     */
    @Override
    public Integer getMin(int left, int right) {
        return min_tree.queryRange(left,right);
    }

    /**
     * The function accepts a left and right range and returns the value from which
      all the given values in the range come from

     * @param left  The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return the summation tree according to the given range
     */
    @Override
    public Integer getSum(int left, int right) {
        return sum_tree.queryRange(left,right);
    }

    /**
     * The function receives an index and a value and updates the index to be the new value
     *
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    @Override
    public void update(int index, int value) {
        numbers[index] = value;
        max_tree.update(index,value);
        min_tree.update(index,value);
        sum_tree.update(index,value);

    }
}