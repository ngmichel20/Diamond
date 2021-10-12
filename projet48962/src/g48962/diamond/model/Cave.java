package g48962.diamond.model;

import g48962.diamond.exception.GameException;

/**
 * This is the class "Cave".
 *
 * @author Nguyen Khanh-Michel.
 */
public class Cave {

    private int nbExploredEntrance;
    private CaveEntrance currentEntrance;
    private final Deck deck;
    private int nbTakenRelics;

    /**
     * This is the constructor "Cave". It has the number of entrance explored
     * and a deck.
     */
    public Cave() {
        this.nbExploredEntrance = 0;
        this.deck = new Deck();
        this.nbTakenRelics = 0;
    }

    /**
     * This is the getter of nbExploredEntrance.
     *
     * @return nbExploredEntrance the number of entrance explored.
     */
    public int getNbExploredEntrance() {
        return nbExploredEntrance;
    }

    /**
     * This is the getter of currentEntrance.
     *
     * @return currentEntrance, the current entrance.
     */
    public CaveEntrance getCurrentEntrance() {
        return currentEntrance;
    }

    /**
     * This is the getter of deck.
     *
     * @return a deck.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * This is the getter of nbTakenRelics.
     *
     * @return the number of relics taken.
     */
    public int getNbTakenRelics() {
        return nbTakenRelics;
    }

    /**
     * This method allows to know if it has a new entrance to explore or not.
     *
     * @return true if there is less than five entrances to explore.
     */
    public boolean hasNewEntranceToExplore() {
        boolean lessThanFiveEntrances = true;
        if (this.nbExploredEntrance == 5) {
            lessThanFiveEntrances = false;
        }
        return lessThanFiveEntrances;
    }

    /**
     * This method allows to open a new entrance of the cave.
     *
     * @throws GameException
     */
    public void openNewEntrance() throws GameException {
        if (this.nbExploredEntrance == 0) {
            CaveEntrance newCaveEntrance = new CaveEntrance(this);
            currentEntrance = newCaveEntrance;
        } else {
            if (currentEntrance.isLockedOut() == false) {
                throw new GameException("La précédente entrée est toujours en "
                        + "phase de jeu.");
            }
            if (this.nbExploredEntrance == 5) {
                throw new GameException("Le nombre d'entrée a été atteint, la "
                        + "partie est finie !");
            }
            CaveEntrance newCaveEntrance = new CaveEntrance(this);
            currentEntrance = newCaveEntrance;
        }
    }

    /**
     * This method allows to lock out the current entrance of the cave and
     * increment the number of entrance explored.
     *
     * @throws GameException
     */
    public void lockOutCurrentEntrance() throws GameException {
        if (currentEntrance.isLockedOut() == true) {
            throw new GameException("La nouvelle entrée de la cave n'est pas "
                    + "encore ouverte.");
        }
        currentEntrance.lockOut();
        this.nbExploredEntrance++;
    }

    /**
     * This method allows to know is the last entrance was dangerous.
     *
     * @return true if the last entrance is unsafe.
     */
    public boolean isLastEntranceUnsafe() {
        boolean lastEntranceIsUnsafe = false;
        if (currentEntrance.isUnsafe() == true) {
            lastEntranceIsUnsafe = true;
        }
        return lastEntranceIsUnsafe;
    }

    /**
     * This method allows to increment the number of relics taken.
     */
    public void incrementNbTakenRelics() {
        nbTakenRelics++;
    }
}
