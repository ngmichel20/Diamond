package g48962.diamond.model;

import java.util.*;

/**
 * This class contains all the gems that will be fairly shared during the game
 * between the explorers.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Treasure implements Tile {

    private List<Gem> gems;
    private final int initNbGems;

    /**
     * This is a constructor that initializes the attributes with an amount of
     * gems given.
     *
     * @param nbGem is the number of gems.
     */
    public Treasure(int nbGem) {
        this.initNbGems = nbGem;
        this.gems = new ArrayList<>();
        for (int i = 0; i < this.initNbGems; i++) {
            this.gems.add(Gem.RUBY);
        }
    }

    /**
     * Constructor from the "Iteration 1".
     */
    public Treasure() {
        this((new Random()).nextInt(15) + 1);
    }

    /**
     * This is the getter of gems.
     *
     * @return gems return the gems.
     */
    public List<Gem> getGems() {
        return gems;
    }

    /**
     * This is the getter of initNbGems.
     *
     * @return initNbGems return the amount of gems during his creation.
     */
    public int getInitNbGems() {
        return initNbGems;
    }

    /**
     * This method shared fairly the gems found to all the explorers.
     *
     * @param explorers is a list of all the explorers that play.
     */
    @Override
    public void explore(List<Explorer> explorers) {
        if (!explorers.isEmpty()) {
            int gemsSize = gems.size();
            for (Explorer explorer : explorers) {
                for (int i = 0; i < (gemsSize / explorers.size()); i++) {
                    explorer.addToBag(gems.get(0));
                    gems.remove(0);
                }
            }
        }
    }

    /**
     * Reset the value of the treasure to his initial value.
     */
    public void restore() {
        this.gems.clear();
        for (int i = 0; i < this.initNbGems; i++) {
            this.gems.add(Gem.RUBY);
        }
    }

    /**
     * This method allows to transfer gems from the instance in parameter to the
     * current tile.
     *
     * @param o is an instance of Treasure
     */
    public void transferGemsFrom(Treasure o) {
        if (o != this.gems) {
            int gemsSize = o.getGems().size();
            for (int i = 0; i < gemsSize; i++) {
                this.gems.add(Gem.RUBY);
                o.getGems().remove(0);
            }
        }
    }
}
