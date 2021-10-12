package g48962.diamond.model;

/**
 * This is the class Gem.
 *
 * @author Nguyen Khanh-Michel.
 */
public enum Gem {

    /**
     * The value of a diamond is 5.
     */
    DIAMOND(5),
    /**
     * The value of a ruby is 1.
     */
    RUBY(1);

    private final int value;

    /**
     * This is the constructor of Gem.
     */
    private Gem(int value) {
        this.value = value;
    }

    /**
     * This is the getter of value.
     *
     * @return value, a value
     */
    public int getValue() {
        return value;
    }

}
