
public class NumberAnalyzerByArrays extends NumberAnalyzer{
    /**
     * Constructs a new NumberAnalyzer object with the given array of integers.
     *
     * @param numbers The array of integers to be analyzed.
     */
    private MaximumSegmentTreeByArray max_arr; // A variable of type MaximumSegmentTreeByArray
    private  MinimumSegmentTreeByArray min_arr; // A variable of type MinimumSegmentTreeByArray
    private SummationSegmentTreeByArray sum_arr; // A variable of type SummationSegmentTreeByArray

    /**
     *
     * @param numbers An array with given values
     */
    public NumberAnalyzerByArrays(Integer[] numbers) {
        super(numbers);
        int[] new_arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            new_arr[i] = numbers[i];
        }
        min_arr = new MinimumSegmentTreeByArray(new_arr);
        max_arr = new MaximumSegmentTreeByArray(new_arr);
        sum_arr = new SummationSegmentTreeByArray(new_arr);

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
        return max_arr.queryRange(left,right);
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
        return min_arr.queryRange(left,right);
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
        return sum_arr.queryRange(left,right);
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
        min_arr.update(index,value);
        max_arr.update(index,value);
        sum_arr.update(index,value);
    }
}
