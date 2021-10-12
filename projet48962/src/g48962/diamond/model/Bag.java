package g48962.diamond.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is the bag of rubies for each of the explorers.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Bag {

    /**
     * This is the attributs gems and it is protected.
     */
    protected List<Gem> gems;

    /**
     * This is a constructor "Bag". He is empty during his creation.
     */
    public Bag() {
        this.gems = new ArrayList<>();
    }

    /**
     * This is the getter of gems.
     *
     * @return a list of gems.
     */
    public List<Gem> getGems() {
        return gems;
    }

    /**
     * This method is used to know the amount of gems in the bag.
     *
     * @return value the amount of gems in the bag.
     */
    public int getValue() {
        int total = 0;
        for (Gem gem : gems) {
            total = total + gem.getValue();
        }
        return total;
    }

    /**
     * This method allows to add gems to the bag.
     *
     * @param gem a gem.
     */
    public void addGem(Gem gem) {
        this.gems.add(gem);
    }

    /**
     * This method empties the bag's contents.
     */
    public void loseContent() {
        this.gems.clear();
    }

    /**
     * This is the method hashcode.
     *
     * @return hash an integer.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.gems);
        return hash;
    }

    /**
     * This is the method equals.
     *
     * @param obj an object with Object in identifier.
     *
     * @return true if the obj is obj.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bag other = (Bag) obj;
        return this.gems == other.gems;
    }
}
