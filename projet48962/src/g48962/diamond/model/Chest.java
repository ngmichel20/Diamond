package g48962.diamond.model;

/**
 * This is the class of Chest.
 *
 * @author Nguyen Khanh Michel
 */
public class Chest extends Bag {

    /**
     * This is the constructor of Chest and it heritates the class Bag.
     */
    public Chest() {
        super();
    }

    /**
     * This method allows to transfer the gems from the bag to the chest.
     *
     * @param bag is the bag.
     */
    public void saveBag(Bag bag) {
        this.gems.addAll(bag.getGems());
        bag.loseContent();
    }

}
