package assignment4;

import java.util.LinkedList;
import java.util.List;


public class HashAVLSpellTable {
    private LinkedList<AVLTree>[] buckets;
    private int tableSize;
    private int numSpells;

    /**
     * HashAVLSpellTable constructor. The constructor accepts a size and sets the size of
       the table to be the accepted size. Initializes the number of spells in the table to 0,
       and more than a new table of the given size
     *
     * @param size The size of the table
     */

    public HashAVLSpellTable(int size) {
        this.tableSize = size;
        this.numSpells = 0;
        this.buckets = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * The method receives a category (string type) and calculates according to the ASCII
       table and according to the calculation the position of the spell in the table

     * @param category The category of the spell
     * @return The position of the spell within the hash table
     */

    private int hash(String category) {
        int hash = 0;
        for (int i = 0; i < category.length(); i++) {
            hash += category.charAt(i);
        }
        return hash % tableSize;
    }

    /**
     * The method inserts a new spell into the hash table.
       The method receives a spell s and inserts the spell into the hash table

     * @param s spell
     */

    public void addSpell(Spell s) {
        numSpells++;
        int i = 0;
        int index = hash(s.getCategory());
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            AVLTree new_tree = new AVLTree(s);
            buckets[index].add(i, new_tree);
        }
        else {
            while (i < buckets[index].size()) {
                if ((buckets[index].get(i).getCategory().equals(s.getCategory()))) {
                    buckets[index].get(i).insert(s);
                    return;
                }
                i++;
            }
            AVLTree new_tree = new AVLTree(s);
            buckets[index].add(i, new_tree);
        }
    }

    /**
     * The method searches for a spell. The method receives a category, spell name and
       power level and returns the requested spell. If the spell does not exist, the method returns Null

     * @param category category of the spell
     * @param spellName The name of the spell
     * @param powerLevel The power level of the spell

     * @return The requested spell, if the spell does not exist returns null
     */

    public Spell searchSpell(String category, String spellName, int powerLevel) {
        int index = hash(category);
        int i = 0;
        while (i < buckets[index].size()) {
            if ((buckets[index].get(i).getCategory().equals(category))) {
                return buckets[index].get(i).search(spellName, powerLevel);
            }
            i++;
        }
        return null;
    }

    /**
     * The method sends the table category to a helper method and returns the number of spells in the table.

     * @return he number of spells in the table
     */

    public int getNumberSpells() {
        return numSpells;
    }

    /**
     * The auxiliary method of finding the number of spells in the table. The method accepts a category
       (of type string) and returns the number of spells in the table, if none exist, returns 0

     * @param category category of the spell

     * @return The number of spells in the table
     */

    public int getNumberSpells(String category) {
        int index = hash(category);
        LinkedList<AVLTree> bucket = buckets[index];

        for (AVLTree avlTree : bucket) {
            if (avlTree.getCategory().equals(category))
                return avlTree.getSize();
        }
        return 0;
    }

    /**
     * The method returns the number of spells with the strongest power level. The number of spells is
       determined by the number of k that the method receives.

     * @param category category of the spell
     * @param k Desired number of strongest spells

     * @return The most powerful spells
     */

    public List<Spell> getTopK(String category, int k) {
        int index = hash(category);
        LinkedList<AVLTree> bucket = buckets[index];

        for (AVLTree avlTree : bucket) {
            if (avlTree.getCategory().equals(category))
                return avlTree.getTopK(k);
        }
        return null;
    }
}
