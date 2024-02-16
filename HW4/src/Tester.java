//import assignment4.*;
//
//public class Tester {
//    private static boolean testPassed = true;
//    private static int testNum = 0;
//
//
//    public static void main(String[] args){
//        /* TODO - write a function for each class separately */
//        // Each function here should test a different class. you should test here every class you created.
//
//
//        DoubleHashTableTest();
//        AVLTreeTest();
//        HashAVLSpellTable();
//
//
//        // Notifying the user that the code have passed all tests.
//        if (testPassed) {
//            System.out.println("All " + testNum + " tests passed!");
//        }
//    }
//    private static void test(boolean exp, String msg) {
//        testNum++;
//
//        if (!exp) {
//            testPassed = false;
//            System.out.println("Test " + testNum + " failed: "  + msg);
//        }
//    }
//
//    private static void DoubleHashTableTest(){
//
//        DoubleHashTable hash_Table = new DoubleHashTable(9);
//
//        SpellSimple spell1 = new SpellSimple("killing", "die now!");
//        SpellSimple spell2 = new SpellSimple("Paralysis", "Stand and don't move!");
//        SpellSimple spell3 = new SpellSimple("disappearance", "You are no longer here!");
//        SpellSimple spell4 = new SpellSimple("memory loss", "forgot!");
//        SpellSimple spell5 = new SpellSimple("flying", "You have wings!");
//        SpellSimple spell6 = new SpellSimple("speed", "I'm Usain Bolt!");
//        SpellSimple spell7 = new SpellSimple("Extra power", "Power now!");
//        SpellSimple spell8 = new SpellSimple("magnet", "Stick to me!");
//        SpellSimple spell9 = new SpellSimple("ossification", "You are a rock!");
//
//
//        hash_Table.put(spell1);
//        test(hash_Table.getLastSteps() == 0, "The last step is: 0, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell2);
//        test(hash_Table.getLastSteps() == 0, "The last step is: 0, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell3);
//        test(hash_Table.getLastSteps() == 0, "The last step is: 0, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell4);
//        test(hash_Table.getLastSteps() == 0, "The last step is: 0, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell5);
//        test(hash_Table.getLastSteps() == 1, "The last step is: 1, got: " + hash_Table.getLastSteps());
//
//        test(hash_Table.getSize() == 5, "The size of the table is: " + hash_Table.getSize() + ", should be: 5");
//
//        hash_Table.put(spell6);
//        test(hash_Table.getLastSteps() == 2, "The last step is: 2, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell7);
//        test(hash_Table.getLastSteps() == 5, "The last step is: 5, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell8);
//        test(hash_Table.getLastSteps() == 0, "The last step is: 0, got: " + hash_Table.getLastSteps());
//        hash_Table.put(spell9);
//        test(hash_Table.getLastSteps() == 2, "The last step is: 2, got: " + hash_Table.getLastSteps());
//
//        test(hash_Table.getSize() == 9, "The size of the table is: " + hash_Table.getSize() + ", should be: 9");
//
//        test(hash_Table.getCastWords("flying") == "You have wings!","The name of the spell words 'You have wings' is: " + hash_Table.getCastWords("flying") + ", should be: You have wings!");
//        test(hash_Table.getCastWords("killing") == "die now!", "The name of the spell words 'You have wings' is: " + hash_Table.getCastWords("killing") + ", should be: die now!");
//        test(hash_Table.getCastWords("disappearance") == "You are no longer here!", "The name of the spell words 'You have wings' is: " + hash_Table.getCastWords("disappearance") + ", should be: You are no longer here!");
//        test(hash_Table.getCastWords("Extra power") == "Power now!", "The name of the spell words 'You have wings' is: Power now!");
//        test(hash_Table.getCastWords("speed") == "I'm Usain Bolt!", "The name of the spell words 'You have wings' is: I'm Usain Bolt!");
//        test(hash_Table.getCastWords("ossification") == "You are a rock!", "The name of the spell words 'You have wings' is: You are a rock!");
//
//    }
//    private static void AVLTreeTest(){
//
//        Spell spell1 = new Spell("a", "heat", 10, "aaa!");
//        Spell spell2 = new Spell("b", "heat", 9, "bbb!");
//        Spell spell3 = new Spell("A", "pain", 8, "AAA!");
//        Spell spell4 = new Spell("d", "heat",5, "ddd!");
//        Spell spell5 = new Spell("B","pain", 6, "BBB!");
//        Spell spell6 = new Spell("C", "pain",7,"CCC!");
//        Spell spell7 = new Spell("e", "heat", 6, "eee!");
//        Spell spell8 = new Spell("D", "pain", 10,"DDD!");
//        Spell spell9 = new Spell("c", "heat", 7, "ccc!");
//        Spell spell10 = new Spell("f", "heat", 3, "fff!");
//        Spell spell11 = new Spell("E", "pain", 12, "EEE!");
//        Spell spell12 = new Spell("F", "pain", 2, "FFF!");
//        Spell spell13 = new Spell("g", "heat", 15, "ggg!");
//        Spell spell14 = new Spell("G", "pain", 4, "GGG!");
//
//
//
//        AVLTree heat_tree = new AVLTree(spell1); // 10
//
//        heat_tree.insert(spell4); // 5
//        heat_tree.insert(spell9); // 7
//        heat_tree.insert(spell7); // 6
//        heat_tree.insert(spell2); // 9
//
//        test(heat_tree.getSize() == 5, "The size of the tree is: " + heat_tree.getSize() + ", should be: 5");
//        test(heat_tree.getTreeHeight() == 2, "The height of the tree is: " +heat_tree.getTreeHeight()+", should be: 2");
//        test(heat_tree.getCategory() == "heat", "The category of the tree is: heat");
//        test(heat_tree.search("ghg", 30) == null, "The search need to return null");
//        test(heat_tree.search("d", 5) == spell4, "The search need to return spell4");
//        test(heat_tree.search("c", 7) == spell9, "The search need to return spell9");
//
//
//        heat_tree.insert(spell13); // 13
//        heat_tree.insert(spell10); // 3
//
//        test(heat_tree.getSize() == 7, "The size of the tree is: " + heat_tree.getSize() + ", should be: 7");
//        test(heat_tree.getTreeHeight() == 2, "The height of the tree is: " +heat_tree.getTreeHeight()+", should be: 2");
//        test(heat_tree.getCategory() == "heat", "The category of the tree is: heat");
//        test(heat_tree.search("G", 25) == null, "The search need to return null");
//        test(heat_tree.search("f", 3) == spell10, "The search need to return spell10");
//        test(heat_tree.search("g", 15) == spell13, "The search need to return spell13");
//
//
//        AVLTree pain_tree = new AVLTree(spell3); // 8
//
//        pain_tree.insert(spell6); // 7
//        pain_tree.insert(spell5); // 6
//
//        test(pain_tree.getSize() == 3, "The size of the tree is: " + pain_tree.getSize() + ", should be: 3");
//        test(pain_tree.getTreeHeight() == 1, "The height of the tree is: " + pain_tree.getTreeHeight() + ", should be: 1");
//        test(pain_tree.search("G", 25) == null, "The search need to return null");
//        test(pain_tree.search("A", 8) == spell3, "The search need to return spell3");
//        test(pain_tree.search("B", 6) == spell5, "The search need to return spell5");
//
//        pain_tree.insert(spell8); // 10
//        pain_tree.insert(spell14); // 4
//        pain_tree.insert(spell11); // 12
//        pain_tree.insert(spell12); // 2
//
//        test(pain_tree.getSize() == 7, "The size of the tree is: " + pain_tree.getSize() + ", should be: 7");
//        test(pain_tree.getTreeHeight() == 2, "The height of the tree is: " + pain_tree.getTreeHeight() + ", should be: 2");
//        test(pain_tree.search("fff", 12) == null, "The search need to return null");
//        test(pain_tree.search("E", 12) == spell11, "The search need to return spell11");
//        test(pain_tree.search("G", 4) == spell14, "The search need to return spell14");
//
//    }
//    private static void HashAVLSpellTable(){
//
//        Spell spell1 = new Spell("killing", "kill", 10, "Avada Kedavra!");
//        Spell spell2 = new Spell("flames", "heat", 9, "Burn!");
//        Spell spell3 = new Spell("bleeding", "pain", 8, "Sectomaspera!");
//        Spell spell4 = new Spell("memory loss", "memory",5, "forgot!");
//        Spell spell5 = new Spell("sword stab","pain", 6, "stabbing!");
//        Spell spell6 = new Spell("memory recall", "memory",7,"Remember!");
//        Spell spell7 = new Spell("ice", "cold", 6, "Mr. Ice!");
//        Spell spell8 = new Spell("torture", "pain", 10,"crushiuo!");
//        Spell spell9 = new Spell("fireball", "heat", 7, "go fireball!");
//
//
//        HashAVLSpellTable hash_AVL_Table = new HashAVLSpellTable(2);
//
//        hash_AVL_Table.addSpell(spell1);
//        hash_AVL_Table.addSpell(spell2);
//        hash_AVL_Table.addSpell(spell3);
//        hash_AVL_Table.addSpell(spell4);
//
//        test(hash_AVL_Table.getNumberSpells() == 4, "The number of spells should be: 4");
//
//        test(hash_AVL_Table.searchSpell("heat", "flames", 9) == spell2, "should be return spell2");
//        test(hash_AVL_Table.searchSpell("pain", "torture", 14) == null, "should be return null");
//        test(hash_AVL_Table.searchSpell("memory", "memory loss", 5) == spell4, "should be return spell4");
//
//        hash_AVL_Table.addSpell(spell5);
//        hash_AVL_Table.addSpell(spell6);
//        hash_AVL_Table.addSpell(spell7);
//        hash_AVL_Table.addSpell(spell8);
//        hash_AVL_Table.addSpell(spell9);
//
//        test(hash_AVL_Table.getNumberSpells() == 9, "The number of spells should be: 9");
//        test(hash_AVL_Table.searchSpell("pain", "flames", 3) == null, "should be return null");
//        test(hash_AVL_Table.searchSpell("cold", "ice", 6) == spell7, "should be return spell7");
//        test(hash_AVL_Table.searchSpell("heat", "fireball", 7) == spell9, "should be return spell9");
//
//    }
//}














import assignment4.*;

/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * This entry function will test all classes created in this assignment.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        /* TODO - write a function for each class separately */
        // Each function here should test a different class. you should test here every class you created.


        testDoubleHashTable();
        testHashAVLSpellTable();
        testAVLTree();

        // Notifying the user that the code have passed all tests.
        if (testPassed) {
            System.out.println("All " + testNum + " tests passed!");
        }
    }

    /**
     * This utility function will count the number of times it was invoked.
     * In addition, if a test fails the function will print the error message.
     *
     * @param exp The actual test condition
     * @param msg An error message, will be printed to the screen in case the test fails.
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: " + msg);
        }
    }


    /**
     * Checks the MaximumSegmentTreeByTree class.
     */
    private static void testDoubleHashTable() {
        DoubleHashTable table = new DoubleHashTable(7);

        // Add some spells to the table
        table.put(new SpellSimple("Abracadabra", "Avada Kedavra"));
        test(table.getLastSteps() == 0, "should be 0");
        table.put(new SpellSimple("Expecto Patronum", "I’m gonna stand here like a unicorn"));
        test(table.getLastSteps() == 0, "should be 0");
        table.put(new SpellSimple("Wingardium Leviosa", "Get up, stand up"));
        test(table.getLastSteps() == 0, "should be 0");
        table.put(new SpellSimple("Shazam", "24K Magic in the air"));
        test(table.getLastSteps() == 1, "should be 1");
        test(table.getSize() == 4, "the size need to be 4");
        table.put(new SpellSimple("cd", "cd"));
        test(table.getLastSteps() == 4, "should be 4");
        SpellSimple sp1 = new SpellSimple("one", "one");
        SpellSimple sp2 = new SpellSimple("two", "two");
        SpellSimple sp3 = new SpellSimple("three", "three");
        SpellSimple sp4 = new SpellSimple("four", "four");
        SpellSimple sp5 = new SpellSimple("five", "five");

        test(table.getCastWords("Shazam").equals("24K Magic in the air"), "should print 24K Magic in the air");
        test(table.getCastWords("Abracadabra").equals("Avada Kedavra"), "should print Avada Kedavra");
        test(table.getSize() == 5, "the size need to be 5");
    }

    private static void testHashAVLSpellTable() {
        Spell sp1 = new Spell("one", "poison", 1, "one");
        Spell sp2 = new Spell("two", "lightning", 2, "two");
        Spell sp3 = new Spell("three ", "lightning", 3, "three ");
        Spell sp4 = new Spell("four", "poison", 4, "four");
        Spell sp5 = new Spell("five", "lightning", 5, "five");
        Spell sp5_1 = new Spell("five.1", "poison", 5, "five.1");
        Spell sp6 = new Spell("six", "poison", 6, "six");
        Spell sp7 = new Spell("seven", "lightning", 7, "seven");
        Spell sp8 = new Spell("eight", "lightning", 8, "eight");
        Spell sp9 = new Spell("nine", "lightning", 9, "nine");
        Spell sp10 = new Spell("ten", "poison", 10, "ten");
        Spell sp11 = new Spell("Eleven", "poison", 11, "Eleven");
        Spell sp12 = new Spell("Twelve", "lightning", 12, "Twelve");
        Spell sp13 = new Spell("Thirteen", "poison", 13, "Thirteen");
        Spell sp17 = new Spell("Seventeen", "fire", 17, "Seventeen");
        Spell sp22 = new Spell("Twenty-two", "fire", 22, "Twenty-two");
        HashAVLSpellTable table_2 = new HashAVLSpellTable(10);
        table_2.addSpell(sp7);
        table_2.addSpell(sp2);
        table_2.addSpell(sp10);
        table_2.addSpell(sp13);
        table_2.addSpell(sp12);
        table_2.addSpell(sp3);
        table_2.addSpell(sp4);
        table_2.addSpell(sp5);
        table_2.addSpell(sp6);
        table_2.addSpell(sp5_1);
        table_2.addSpell(sp1);
        table_2.addSpell(sp8);
        table_2.addSpell(sp9);
        table_2.addSpell(sp11);
        test(table_2.getNumberSpells() == 14, "need to be 14");
        test(table_2.getNumberSpells("lightning") == 7, "need to be 7");
        test(table_2.getNumberSpells("poison") == 7, "need to be 7");
        Spell searchedSpell = table_2.searchSpell("lightning", "five", 5);
        Spell searchedSpell_2 = table_2.searchSpell("fire", "Twenty-two", 22);  //need to be null
        Spell searchedSpell_3 = table_2.searchSpell("poison", "Thirteen", 13);
        Spell searchedSpell_4 = table_2.searchSpell("poison", "six", 6);
        Spell searchedSpell_5 = table_2.searchSpell("lightning", "nine", 9);
        Spell searchedSpell_6 = table_2.searchSpell("fire", "one hundred", 100);  //need to be null
        test(searchedSpell != null, "the spell didnt found");
        test(searchedSpell_2 == null, "the spell didnt exist but he has been found");
        test(searchedSpell_3 != null, "the spell didnt found");
        test(searchedSpell_4 != null, "the spell didnt found");
        test(searchedSpell_5 != null, "the spell didnt found");
        test(searchedSpell_6 == null, "the spell didnt exist but he has been found");

        test(table_2.getTopK("lightning", 5).get(0).getName().equals("Twelve"), "need to be Twelve");
        test(table_2.getTopK("lightning", 5).get(1).getName().equals("nine"), "need to be nine");
        test(table_2.getTopK("lightning", 5).get(2).getName().equals("eight"), "need to be eight");
        test(table_2.getTopK("lightning", 5).get(3).getName().equals("seven"), "need to be seven");

        table_2.addSpell(sp17);
        table_2.addSpell(sp22);
        test(table_2.getNumberSpells() == 16, "need to be 16");
        test(table_2.getNumberSpells("fire") == 2, "need to be 2");

    }

    private static void testAVLTree() {
        Spell sp1 = new Spell("one", "fire", 1, "one");
        Spell sp2 = new Spell("two", "fire", 2, "two");
        Spell sp3 = new Spell("three", "fire", 3, "three");
        Spell sp4 = new Spell("four", "fire", 4, "four");
        Spell sp5 = new Spell("five", "fire", 5, "five");
        Spell sp6 = new Spell("six", "fire", 6, "six");
        Spell sp7 = new Spell("seven", "fire", 7, "seven");
        Spell sp8 = new Spell("eight", "fire", 8, "eight");
        Spell sp9 = new Spell("nine", "fire", 9, "nine");
        Spell sp10 = new Spell("ten", "fire", 10, "ten");
        Spell sp13 = new Spell("Thirteen", "fire", 13, "Thirteen");
        Spell sp17 = new Spell("Seventeen", "fire", 17, "Seventeen");
        Spell sp22 = new Spell("Twenty-two", "fire", 22, "Twenty-two");

        AVLTree t = new AVLTree(sp4);
        test(t.getTreeHeight() == 0, "the tree is height need to be 0 got: " + t.getTreeHeight());
        test(t.getCategory().equals("fire"), "the tree Category need to be fire");     //4
        t.insert(sp2);                                        //                       _ /   \__
        t.insert(sp6);                                        //                      2            6
        t.insert(sp1);                                        //                   __/ \          /
        t.insert(sp3);                                        //                 1      3       5
        t.insert(sp5);
        test(t.getTreeHeight() == 2, "the tree is height need to be 2 got: " + t.getTreeHeight());
        test(t.getSize() == 6, "the tree is size need to be 6");

        AVLTree t2 = new AVLTree(sp4);
        t2.insert(sp2);                                     //                       4
        t2.insert(sp6);                                     //                 _ /   \__
        t2.insert(sp1);                                     //                2            6
        t2.insert(sp3);                                     //             __/ \           / \
        t2.insert(sp5);                                    //            1      3         5   ___8
        t2.insert(sp7);                                    //                                   /  \
        t2.insert(sp8);                                   //                                   7     9
        t2.insert(sp9);
        test(t2.getTreeHeight() == 3, "the tree is height need to be 3 got: " + t2.getTreeHeight());
        test(t2.getSize() == 9, "the tree is size need to be 9");
        test(t2.getTopK(5).get(4).getName().equals("five"), "need to be five");
        test(t2.getTopK(5).get(0).getName().equals("nine"), "need to be nine");
        test(t2.getTopK(5).get(3).getName().equals("six"), "need to be six");

        AVLTree t3 = new AVLTree(sp3);
        t3.insert(sp2);                                         //                       2
        t3.insert(sp1);                                         //                 _ /   \__
        t3.insert(sp4);                                         //                1            3
        //                                            \
        test(t3.getTreeHeight() == 2, "the tree is height need to be 2 got: " + t3.getTreeHeight());          //     4
        test(t3.getSize() == 4, "the tree is size need to be 4");
        test(t3.getTopK(2).get(0).getName().equals("four"), "need to be four");
        test(t3.getTopK(2).get(1).getName().equals("three"), "need to be three");



        AVLTree t4 = new AVLTree(sp13); //work number 3 data structure
        t4.insert(sp6);                                     //                       8
        t4.insert(sp17);                                    //              __ /   \____
        t4.insert(sp4);                                     //             6                   13
        t4.insert(sp8);                                     //            /  \                 /  \
        t4.insert(sp22);                                    //      __    __        __    ___
        t4.insert(sp2);                                  //        2               7       9           17
        t4.insert(sp7);            //                             /  \                       \            \
        t4.insert(sp9);           //                             1     4                       10           22
        t4.insert(sp1);
        t4.insert(sp10);
        test(t4.getTreeHeight() == 3, "the tree is height need to be 3 got: " + t4.getTreeHeight());
        test(t4.getSize() == 11, "the tree is size need to be 11");
        test(t4.getTopK(8).get(3).getName().equals("ten"), "need to be ten");
        test(t4.getTopK(8).get(7).getName().equals("six"), "need to be six");
        test(t4.getTopK(8).get(4).getName().equals("nine"), "need to be nine");
        test(t4.getTopK(8).get(5).getName().equals("eight"), "need to be eight");



        AVLTree t5 = new AVLTree(sp5); //work number 3 data structure                    6
        t5.insert(sp1);  //                                                         _/  \_
        t5.insert(sp9);  //                                                        5             9
        t5.insert(sp6);   //                                                      /           _/  \__
        t5.insert(sp10);  //                                                     1           8          10
        t5.insert(sp8);
        test(t5.getTreeHeight() == 2, "the tree is height need to be 2 got: " + t5.getTreeHeight());
        test(t5.getSize() == 6, "the tree is size need to be 6");
        test(t5.getTopK(4).get(3).getName().equals("six"), "need to be six");
        test(t5.getTopK(4).get(0).getName().equals("ten"), "need to be ten");





        AVLTree t6 = new AVLTree(sp10); //work number 3 data structure                   6
        t6.insert(sp4);  //                                                          _/  \___
        t6.insert(sp13);  //                                                        5             10
        t6.insert(sp6);   //                                                       /            _/ \_
        t6.insert(sp5);  //                                                       4            8        13
        t6.insert(sp8);
        test(t6.getTreeHeight() == 2, "the tree is height need to be 2 got: " + t6.getTreeHeight());
        test(t6.getSize() == 6, "the tree is size need to be 6");
        test(t6.getTopK(20).size() == 6, "the top k need to be 6 items, got : " + t6.getTopK(20).size());
        test(t6.getTopK(3).get(1).getName().equals("ten"), "the second top 3 need to be ten");
        test(t6.getTopK(3).get(2).getName().equals("eight"), "the second top 3 need to be eight");



    }
}
