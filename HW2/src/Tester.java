/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * This entry function will test all classes created in this assignment.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        /* TODO - write a function for each class separately */
        // Each function here should test a different class. you should test here every class you created.


//      SegmentTreesByTree
        testMaximumSegmentTreeByTree();
        testMinimumSegmentTreeByTree();
        testSummationSegmentTreeByTree();

//      SegmentTreesByArray
        testMaximumSegmentTreeByArray();
        testMinimumSegmentTreeByArray();
        testSummationSegmentTreeByArray();

//      NumberAnalyzers
        testNumberAnalyzerByTrees();
        testNumberAnalyzerByArrays();


        // Notifying the user that the code have passed all tests.
        if (testPassed) {
            System.out.println("All " + testNum + " tests passed!");
        }
    }

    /**
     * This utility function will count the number of times it was invoked.
     * In addition, if a test fails the function will print the error message.
     * @param exp The actual test condition
     * @param msg An error message, will be printed to the screen in case the test fails.
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: "  + msg);
        }
    }

    /**
     * Checks the MaximumSegmentTreeByTree class.
     */
    private static void testMaximumSegmentTreeByTree() {

        MaximumSegmentTreeByTree max_tree = new MaximumSegmentTreeByTree(new int[]{60,10,5,15,6});

        test(max_tree.queryRange(2,4) == 15, "The max of {60,10,5,15,6} between indexes [2:4] should be 15");
        test(max_tree.queryRange(0,2) == 60, "The max of {60,10,5,15,6} between indexes [0:2] should be 60");
        test(max_tree.toString().equals(" [ 60 60 60 60 10 5 15 15 6 ] "),"The toString of {60,10,5,15,6} should be ' [ 60 60 60 60 10 5 15 15 6 ] ' got: '" + max_tree.toString()+ " '");

        max_tree.update(1,80);

        test(max_tree.queryRange(0,3) == 80, "After update index 1 from {60,10,5,15,6} to 80, the max between indexes [0:3] should be 80");
        test(max_tree.queryRange(2,4) == 15, "After update index 1 from {60,10,5,15,6} to 80, the max between indexes [2:4] should be 15");
        test(max_tree.toString().equals(" [ 80 80 80 60 80 5 15 15 6 ] "),"The toString of {60,80,5,15,6} should be ' [ 80 80 80 60 80 5 15 15 6 ] ' got: '" + max_tree.toString()+ " '");
    }
    /**
     * Checks the MinimumSegmentTreeByTree class.
     */
    private static void testMinimumSegmentTreeByTree() {

        MinimumSegmentTreeByTree min_tree = new MinimumSegmentTreeByTree(new int[]{40,2,35,20});

        test(min_tree.queryRange(0,3) == 2, "The min of {40,2,35,20} between indexes [0:3] should be 2");
        test(min_tree.queryRange(2,3) == 20, "The min of {40,2,35,20} between indexes [2:3] should be 20");
        test(min_tree.toString().equals(" [ 2 2 40 2 20 35 20 ] "),"The toString of {40,2,35,20} should be ' [ 2 2 40 2 20 35 20 ] ' got: '" + min_tree.toString()+ " '");

        min_tree.update(3,1);

        test(min_tree.queryRange(0,1) == 2, "After update index 3 from {40,2,35,20} to 1, the min between indexes [0:1] should be 2");
        test(min_tree.queryRange(1,3) == 1, "After update index 3 from {40,2,35,20} to 1, the min between indexes [1:3] should be 1");
        test(min_tree.toString().equals(" [ 1 2 40 2 1 35 1 ] "),"The toString of {40,2,35,1} should be ' [ 1 2 1 40 2 35 1 ] ' got: '" + min_tree.toString()+ " '");
    }
    /**
     * Checks the SummationSegmentTreeByTree class.
     */
    private static void testSummationSegmentTreeByTree() {

        SummationSegmentTreeByTree sum_tree = new SummationSegmentTreeByTree(new int[]{2,5,13,3,9,7});

        test(sum_tree.queryRange(1,5) == 37, "The sum of {2,5,13,3,9,7} between indexes [1:5] should be 37");
        test(sum_tree.queryRange(0,2) == 20, "The sum of {2,5,13,3,9,7} between indexes [0:2] should be 20");
        test(sum_tree.toString().equals(" [ 39 20 7 2 5 13 19 12 3 9 7 ] "),"The toString of {2,5,13,3,9,7} should be ' [ 39 20 7 2 5 13 19 12 3 9 7 ] ' got: '" + sum_tree.toString()+ " '");

        sum_tree.update(2,1);

        test(sum_tree.queryRange(0,6) == 27, "After update index 2 from {2,5,13,3,9,7} to 1, the sum between indexes [0:6] should be 27");
        test(sum_tree.queryRange(2,4) == 13, "After update index 2 from {2,5,13,3,9,7} to 1, the sum between indexes [2:4] should be 13");
        test(sum_tree.toString().equals(" [ 27 8 7 2 5 1 19 12 3 9 7 ] "),"The toString of {2,5,1,3,9,7} should be ' [ 27 8 7 2 5 1 19 12 3 9 7 ] ' got: '" + sum_tree.toString()+ " '");
    }
    /**
     * Checks the MaximumSegmentTreeByArray class.
     */
    private static void testMaximumSegmentTreeByArray() {

        MaximumSegmentTreeByArray max_arr = new MaximumSegmentTreeByArray(new int[]{10,15,55,15,9,12});

        test(max_arr.queryRange(0,1) == 15, "The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");
        test(max_arr.queryRange(2,5) == 55, "The max of {10,15,55,15,9,12} between indexes [2:5] should be 55");
        test(max_arr.toString().equals(" [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] "),"The toString of {10,15,55,15,9,12} should be ' [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] ' got: '" + max_arr.toString()+ " '");

        max_arr.update(0,80);

        test(max_arr.queryRange(0,4) == 80, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [0:4] should be 80");
        test(max_arr.queryRange(3,5) == 15, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [3:5] should be 15");
        test(max_arr.toString().equals(" [ 80 80 15 80 55 15 12 80 15 - - 15 9 - - ] "),"The toString of {80,15,55,15,9,12} should be ' [ 80 80 15 80 55 15 12 80 15 - - 15 9 - - ] ' got: '" + max_arr.toString()+ " '");

    }
    /**
     * Checks the MinimumSegmentTreeByArray class.
     */
    private static void testMinimumSegmentTreeByArray() {

        MinimumSegmentTreeByArray min_arr = new MinimumSegmentTreeByArray(new int[]{2,5,3,9});

        test(min_arr.queryRange(3,4) == 9, "The min of {2,5,3,9} between indexes [3:4] should be 9");
        test(min_arr.queryRange(0,1) == 2, "The min of {2,5,3,9} between indexes [0:1] should be 2");
        test(min_arr.toString().equals(" [ 2 2 3 2 5 3 9 ] "),"The toString of {2,5,3,9} should be ' [ 2 2 3 2 5 3 9 ] ' got: '" + min_arr.toString()+ " '");

        min_arr.update(3,14);

        test(min_arr.queryRange(0,2) == 2, "After update index 3 from {2,5,3,9} to 14, the min between indexes [0:2] should be 2");
        test(min_arr.queryRange(1,3) == 3, "After update index 3 from {2,5,3,9} to 14, the min between indexes [1:3] should be 3");
        test(min_arr.toString().equals(" [ 2 2 3 2 5 3 14 ] "),"The toString of {2,5,3,14} should be ' [ 2 2 3 2 5 3 14 ] ' got: '" + min_arr.toString()+ " '");

    }
    /**
     * Checks the SummationSegmentTreeByArray class.
     */
    private static void testSummationSegmentTreeByArray() {

        SummationSegmentTreeByArray sum_arr = new SummationSegmentTreeByArray(new int[]{23,2,15,35,20});

        test(sum_arr.queryRange(0,2) == 40, "The sum of {23,2,15,35,20} between indexes [0:2] should be 40");
        test(sum_arr.queryRange(1,4) == 72, "The sum of {23,2,15,35,20} between indexes [1:4] should be 72");
        test(sum_arr.toString().equals(" [ 95 40 55 25 15 35 20 23 2 - - - - - - ] "),"The toString of {23,2,15,35,20} should be ' [ 95 40 55 25 15 35 20 23 2 - - - - - - ] ' got: '" + sum_arr.toString()+ " '");

        sum_arr.update(0,50);

        test(sum_arr.queryRange(2,4) == 70, "After update index 0 from {23,2,15,35,20} to 50, the sum between indexes [2:4] should be 70");
        test(sum_arr.queryRange(0,3) == 102, "After update index 0 from {23,2,15,35,20} to 50, the sum between indexes [0:3] should be 102");
        test(sum_arr.toString().equals(" [ 122 67 55 52 15 35 20 50 2 - - - - - - ] "),"The toString of {50,2,15,35,20} should be ' [ 122 67 55 52 15 35 20 50 2 - - - - - - ] ' got: '" + sum_arr.toString()+ " '");

    }
    /**
     * Checks the NumberAnalyzerByTrees class.
     */
    private static void testNumberAnalyzerByTrees() {

        Integer[] arr = {10,30,50,25,60};
        NumberAnalyzerByTrees num_tree = new NumberAnalyzerByTrees(arr);

        test(num_tree.getMax(0,1) == 30, "The max of {10,30,50,25,60} between indexes [0:1] should be 30");
        test(num_tree.getMax(2,4) == 60, "The max of {10,30,50,25,60} between indexes [2:4] should be 60");
        test(num_tree.getMin(1,3) == 25, "The min of {10,30,50,25,60} between indexes [1:3] should be 25");
        test(num_tree.getMin(0,2) == 10, "The min of {10,30,50,25,60} between indexes [0:2] should be 10");
        test(num_tree.getSum(1,2) == 80, "The sum of {10,30,50,25,60} between indexes [1:2] should be 90");
        test(num_tree.getSum(3,4) == 85, "The sum of {10,30,50,25,60} between indexes [3:4] should be 85");

        test(num_tree.compare(51, 2) < 0, "The compare of 51 and 2 should be -1");
        test(num_tree.compare(24, 24) == 0, "The compare of 24 and 24 should be 0");
        test(num_tree.compare(16, 4) > 0, "The compare of 16 and 4 should be 1");
        test(num_tree.compare(27, 13) > 0, "The compare of 27 and 13 should be 1");

        num_tree.update(2, 5);

        test(num_tree.getMax(3,4) == 60, "The max of {10,30,5,25,60} between indexes [3:4] should be 60");
        test(num_tree.getMax(1,3) == 30, "The max of {10,30,5,25,60} between indexes [1:3] should be 30");
        test(num_tree.getMin(0,3) == 5, "The min of {10,30,5,25,60} between indexes [0:3] should be 5");
        test(num_tree.getMin(3,4) == 25, "The min of {10,30,5,25,60} between indexes [3:4] should be 25");
        test(num_tree.getSum(2,3) == 30, "The sum of {10,30,5,25,60} between indexes [2:32] should be 30");
        test(num_tree.getSum(1,4) == 120, "The sum of {10,30,5,25,60} between indexes [1:4] should be 120");

    }
    /**
     * Checks the NumberAnalyzerByArrays class.
     */
    private static void testNumberAnalyzerByArrays() {

        Integer[] arr = {2,26,13,1,9,33,21,3};
        NumberAnalyzerByArrays num_arr = new NumberAnalyzerByArrays(arr);

        test(num_arr.getMax(0,3) == 26, "The max of {2,26,13,1,9,33,21,3} between indexes [0:3] should be 26");
        test(num_arr.getMax(4,7) == 33, "The max of {2,26,13,1,9,33,21,3} between indexes [4:7] should be 33");
        test(num_arr.getMin(3,6) == 1, "The min of {2,26,13,1,9,33,21,3} between indexes [3:6] should be 1");
        test(num_arr.getMin(0,2) == 2, "The min of {2,26,13,1,9,33,21,3} between indexes [0:2] should be 2");
        test(num_arr.getSum(1,3) == 40, "The sum of {2,26,13,1,9,33,21,3} between indexes [1:3] should be 40");
        test(num_arr.getSum(0,7) == 108, "The sum of {2,26,13,1,9,33,21,3} between indexes [0:7] should be 108");

        test(num_arr.compare(51, 2) < 0, "The compare of 51 and 2 should be -1");
        test(num_arr.compare(24, 24) == 0, "The compare of 24 and 24 should be 0");
        test(num_arr.compare(16, 4) > 0, "The compare of 16 and 4 should be 1");
        test(num_arr.compare(27, 13) > 0, "The compare of 27 and 13 should be 1");

        num_arr.update(3,67);

        test(num_arr.getMax(3,7) == 67, "The max of {2,26,13,67,9,33,21,3} between indexes [3:7] should be 67");
        test(num_arr.getMax(1,2) == 26, "The max of {2,26,13,67,9,33,21,3} between indexes [1:2] should be 26");
        test(num_arr.getMin(3,6) == 9, "The min of {2,26,13,67,9,33,21,3} between indexes [3:6] should be 9");
        test(num_arr.getMin(1,3) == 13, "The min of {2,26,13,67,9,33,21,3} between indexes [1:3] should be 13");
        test(num_arr.getSum(3,5) == 109, "The sum of {2,26,13,67,9,33,21,3} between indexes [3:5] should be 109");
        test(num_arr.getSum(0,7) == 174, "The sum of {2,26,13,67,9,33,21,3} between indexes [0:7] should be 174");

    }
}
