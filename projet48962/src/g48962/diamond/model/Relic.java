package g48962.diamond.model;

import java.util.List;

/**
 * This is the class of Relic.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Relic implements Tile {

    private int valueInDiamonds;

    /**
     * This is the constructor of Relic.
     */
    public Relic() {
        this.valueInDiamonds = 1;
    }

    /**
     * This is the getter of valueInDiamonds.
     *
     * @return the value in diamonds.
     */
    public int getValueInDiamonds() {
        return valueInDiamonds;
    }

    /**
     * This method allows to know if there is only one explorer in the list and
     * if his state is in leaving.
     *
     * @param explorers is a list of explorers.
     * @return true if there is only one explorer in the list (and his state is
     * leaving).
     */
    public boolean canBeTaken(List<Explorer> explorers) {
        boolean onlyOneExplo = false;
        for (Explorer explorer : explorers) {
            if (explorers.size() == 1 && explorer.getState() == State.LEAVING) {
                onlyOneExplo = true;
            }
        }
        return onlyOneExplo;
    }

    /**
     * This method converts the gem value to a diamond value.
     *
     * @param nbTakenRelics is the number of relics taken.
     */
    public void convertGemValue(int nbTakenRelics) {
        if (nbTakenRelics > 3) {
            this.valueInDiamonds = 2;
        }
    }

    @Override
    public void explore(List<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            if (this.valueInDiamonds == 2) {
                explorer.addToBag(Gem.DIAMOND);
                explorer.addToBag(Gem.DIAMOND);
            } else {
                explorer.addToBag(Gem.DIAMOND);
            }
        }
    }
}
