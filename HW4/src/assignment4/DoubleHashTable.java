package assignment4;

public class DoubleHashTable {
    private SpellSimple[] table;
    private int capacity;
    private int size;
    private int steps = 0;

    /**
     * The DoubleHashTable constructor. The constructor receives a capacity number and updates the
       variable according to the number and creates a new table with the given size.

     * @param capacity The size given to the size of the table
     */
    public DoubleHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new SpellSimple[capacity];
    }

    /**
     * The method returns a Boolean value. The method receives a spell and inserts it into the table.
       If the spell goes in then the method returns true and if not, returns false.

     * @param spell A spell we would like to enter

     * @return True or false if the spell went in or not
     */

    public boolean put(SpellSimple spell) {
        steps = 0;
        if (getSize() == capacity)
            return false;
        boolean result = false;
        while (steps < capacity){
            int index = (hash1(spell.getName()) + steps * hash2(spell.getName())) % capacity;
            if (table[index] == null){
                table[index] = spell;
                result = true;
                break;
            }
            else {
                steps++;
            }
        }
        return result;
    }

    /**
     * The method receives the name of a spell and returns the words that must be said to
       perform the spell. If it doesn't exist, it returns an empty list.

     * @param name Name of the spell

     * @return the words of the desired spell
     */

    public String getCastWords(String name) {
        steps = 0;
        String result = null;
        while (steps < capacity){
            int index = (hash1(name) + steps * hash2(name)) % capacity;
            if ((table[index].getName().equals(name))){
                result = table[index].getWords();
                break;
            }
            else{
                steps++;
            }
        }
        return result;
    }

    /**
     * @return he size of the table - that is, the number of spells in the table
     */

    public int getSize() {
        size = 0;
        for (SpellSimple spellSimple : table) {
            if (spellSimple != null)
                size++;
        }
        return size;
    }

    /**
     * @return The last step the hash function took in inserting or searching the table
     */

    public int getLastSteps(){
        return steps;
    }

    /**
     * Hash method 1. The method receives the name of a spell and according to the ASCII table,
      returns a certain position in the table where the spell will enter.

     * @param name The name of the spell
     * @return The initial position in the table where the spell will enter
     */

    private int hash1(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++){
            hash += name.charAt(i) * 31;
        }
        return hash % capacity;
    }

    /**
     * The second hashing method. The method receives the name of a spell, and according to the ASCII
     * table and calculation, returns the next step after the first hash function
     *
     * @param name The name of the spell
     * @return The next step in entering or looking up a spell into the table
     */

    private int hash2(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i) * 13;
        }
        return (1 + hash % (capacity - 2));
    }
}