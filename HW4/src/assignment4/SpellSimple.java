package assignment4;

public class SpellSimple {
    private String name;
    private String words;

    /**
     * The spellSimple constructor. The builder gets a name and words to say to activate the spell

     * @param name The name of the spell
     * @param words the words of the spell
     */
    public SpellSimple(String name, String words) {
        this.name = name;
        this.words = words;
    }

    /**
     * @return The method returns the name of the spell
     */

    public String getName(){
        return this.name;
    }

    /**
     * @return The method returns the words of the spell
     */
    public String getWords(){
        return this.words;
    }
}