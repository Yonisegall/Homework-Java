package assignment4;

import java.util.List;
import java.util.LinkedList;

public class AVLTree {

    private Node root;
    private int size;
    private String category;

    // private Node class for the AVL Tree nodes
    private class Node {
        private Spell spell;
        private Node left;
        private Node right;
        private int height;

        /**
         * Constructor of node
         * @param spell The node receives a spell and creates the four
         *              variables for it: the spell, right child, left child and height
         */
        private Node(Spell spell) {
            this.spell = spell;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }

    /**
     * Constructor of an AVL tree
     * @param spell The constructor receives a spell and creates
     *              three variables: root, height and category
     */
    public AVLTree(Spell spell) {
        this.root = new Node(spell);
        this.size = 1;
        this.category = spell.getCategory();

    }

    /**
     * The method sends the root of the tree to the auxiliary
       method and receives back the height of the tree

     * @return Returns the height of the tree
     */
    public int getTreeHeight() {
        return get_Tree_Height(root);
    }

    /**
     *
     * @param node The method receives a certain node and returned its height unless it is null

     * @return Returns the height of the tree to the main method
     */
    public int get_Tree_Height(Node node) {
        if (node == null)
            return -1;
        else
            return node.height;
    }

    /**
     * The method returns the size of the node in the tree
     * @return The number of node in the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * The method returns the category of the tree
     * @return The category of the tree
     */
    public String getCategory() {
        return category;
    }

    /**
     * The method receives a spell name and power level and returns the spell found in the tree.
       The method sends the helper method and receives back the desired spell

     * @param spellName Name of a spell
     * @param powerLevel Spell power level

     * @return the desired spell
     */
    public Spell search(String spellName, int powerLevel) {
        return search_Node(root, spellName, powerLevel);
    }

    /**
     * The helper method of the search method. The method receives a node (root of the tree),
       a name of a spell, a power level of a spell and returns the desired spell if it is in the tree

     * @param node the root of the tree
     * @param spellName name of a spell
     * @param powerLevel power level of a spell
     *
     * @return the desired spell if it is in the tree
     */
    public Spell search_Node(Node node, String spellName, int powerLevel) {
        if (node == null) {
            return null;
        }

        if (node.spell.getName().equals(spellName) && node.spell.getPowerLevel() == powerLevel) {
            return node.spell;
        }

        if (node.spell.getPowerLevel() > powerLevel) {
            return search_Node(node.left, spellName, powerLevel);
        } else {
            return search_Node(node.right, spellName, powerLevel);
        }
    }

    /**
     * The method inserts a spell into the AVL tree. The method receives a
     * spell and sends it to a helper method with the spell and the root of the tree.

     * @param spell A spell that we would like to insert
     */

    public void insert(Spell spell) {
        root = insert_Node(root, spell);
    }

    /**
     * The method receives a certain node and checks its balance.
     * The method returns the ratio between the sons of the given node
     *
     * @param node The given node that we want to check
     *
     * @return A number that is the ratio between the height of the right son and the height of the left son
     */


    private int get_Balance_Factor(Node node) {
        if (node == null) {
            return 0;
        }
        return get_Tree_Height(node.left) - get_Tree_Height(node.right);
    }

    /**
     * The method receives a certain node and performs a rotation to the right.
     * The method returns the node after the rotation
     *
     * @param y the desired node
     *
     * @return the node after the rotation
     */

    private Node right_Rotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        y.height = 1 + Math.max(get_Tree_Height(y.left), get_Tree_Height(y.right));
        x.height = 1 + Math.max(get_Tree_Height(x.left), get_Tree_Height(x.right));

        return x;
    }

    /**
     * The method receives a certain node and performs a rotation to the left.
     * The method returns the node after the rotation
     *
     * @param x the desired node
     *
     * @return the node after the rotation
     */

    private Node left_Rotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        x.height = 1 + Math.max(get_Tree_Height(x.left), get_Tree_Height(x.right));
        y.height = 1 + Math.max(get_Tree_Height(y.left), get_Tree_Height(y.right));

        return y;
    }

    /**
     * The auxiliary method of the income method. The method receives a certain nod
       (the root of the tree) and a spell. The method inserts the desired spell into
       the tree according to the given node. She then returns the tree with the entry of the spell.

     * @param node The desired tree in which we want to insert the spell
     * @param spell The spell we want to put into the tree
     *
     * @return The given tree after casting the spell
     */

    public Node insert_Node(Node node, Spell spell) {
        if (node == null) {
            size++;
            return new Node(spell);
        }

        if (spell.getPowerLevel() < node.spell.getPowerLevel()) {
            node.left = insert_Node(node.left, spell);
        } else {
            node.right = insert_Node(node.right, spell);
        }

        node.height = 1 + Math.max(get_Tree_Height(node.left), get_Tree_Height(node.right));

        int balanceFactor = get_Balance_Factor(node);

        if (balanceFactor > 1) {
            if (spell.getPowerLevel() < node.left.spell.getPowerLevel()) {
                return right_Rotate(node);
            } else {
                node.left = left_Rotate(node.left);
                return right_Rotate(node);
            }
        }

        if (balanceFactor < -1) {
            if (spell.getPowerLevel() > node.right.spell.getPowerLevel()) {
                return left_Rotate(node);
            } else {
                node.right = right_Rotate(node.right);
                return left_Rotate(node);
            }
        }

        return node;
    }

    /**
     * The method receives a certain number and returns a list of the number
      of the strongest spells in the tree according to the given number.

     * @param k desired number of spells
     *
     * @return list of the k most powerful spells in the tree
     */

        public List<Spell> getTopK(int k) {
        List<Spell> top_Spells = new LinkedList<>();
        getTopK_Helper(root, top_Spells, k);
        return top_Spells;
    }

    /**
     * getTopK helper method. The method receives a tree root, an empty list and the desired number k of the
     * strong spells. The method puts the number of powerful spells into the list.

     * @param node the root of the desired tree
     * @param top_Spells The list to which we will put the powerful spells
     * @param k Desired number of powerful spells
     */

    public void getTopK_Helper(Node node, List<Spell> top_Spells, int k) {
        if (node != null) {
            getTopK_Helper(node.right, top_Spells, k);
            if (top_Spells.size() < k || node.spell.getPowerLevel() == top_Spells.get(top_Spells.size() - 1).getPowerLevel()) {
                top_Spells.add(node.spell);
                if (top_Spells.size() > k) {
                    top_Spells.remove(top_Spells.size() - 1);
                }
            } else {
                return;
            }
            getTopK_Helper(node.left, top_Spells, k);
        }
    }
}







//    public void inorder(){
//        inorder_help(this.root);
//    }
//    private void inorder_help(AVLTree.Node node){
//        if(node == null)
//            return;
//        inorder_help(node.left);
//        System.out.println("the name : "+node.spell.getName()+ ", and the height : "+node.height+" ");
//        if(node.left == null)
//            System.out.println(" he's left son : null");
//        else System.out.println(" he's left son : "+node.left.spell.getName());
//        if(node.right == null)
//            System.out.println(" he's right son : null");
//        else System.out.println(" he's right son : "+node.right.spell.getName());
//        System.out.println();
//        inorder_help(node.right);
//    }
//}


