package assignment4;
public class Spell {
    private String name;
    private String category;
    private int powerLevel;
    private String words;

    /**
     * The builder of the spell. The constructor accepts name (of type string),
       category (of type string), power level (of type string) and words (of type string)

     * @param name The name of the spell
     * @param category The category of the spell
     * @param powerLevel The power level of the spell
     * @param words the words of the spell
     */
    public Spell(String name, String category, int powerLevel, String words) {
        this.name = name;
        this.category = category;
        this.powerLevel = powerLevel;
        this.words = words;
    }

    /**
     * @return the name of the spell
     */

    public String getName() {
        return name;
    }

    /**
     * @return the category of the spell
     */

    public String getCategory() {
        return category;
    }

    /**
     * @return the power level of the spell
     */

    public int getPowerLevel() {
        return powerLevel;
    }

    /**
     * @return The method prints all the details in order: name,
               category, power level and the words of the spell
     */

    @Override
    public String toString() {
        return name + " (" + category + ") - Power Level: " + powerLevel + ", to cast say: " + words;
    }
}
