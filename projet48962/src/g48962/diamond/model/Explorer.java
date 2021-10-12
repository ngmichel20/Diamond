package g48962.diamond.model;

import java.util.Objects;

/**
 * This class will represent the explorers.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Explorer {

    private final String pseudonym;
    private final Bag bag;
    private State state;
    private final Chest chest;

    /**
     * This is a constructor "Explorer". By default, an explorer is in the
     * "CAMPING"'s state.
     *
     * @param pseudonym is the pseudonym of an explorer.
     */
    public Explorer(String pseudonym) {
        this.pseudonym = pseudonym;
        this.bag = new Bag();
        this.state = State.CAMPING;
        this.chest = new Chest();

    }

    /**
     * This is the getter of pseudonym.
     *
     * @return pseudonym return the pseudonym of the explorer.
     */
    public String getPseudonym() {
        return pseudonym;
    }

    /**
     * This is the getter of bag.
     *
     * @return bag return the bag of the explorer.
     */
    public Bag getBag() {
        return bag;
    }

    /**
     * This is the getter of state.
     *
     * @return state return the state of the explorer.
     */
    public State getState() {
        return state;
    }

    /**
     * This method allows to add gem to the bag.
     *
     * @param gem is a gem.
     */
    public void addToBag(Gem gem) {
        bag.addGem(gem);
    }

    /**
     * This method allows to the explorer to leave the cave. It will change his
     * state(to "LEAVING") if he does.
     */
    public void takeDecisionToLeave() {
        state = State.LEAVING;
    }

    /**
     * This method allows to know the amount of gems of the bag's explorer.
     *
     * @return the amount of rubies in the bag.
     */
    public int getFortune() {
        return chest.getValue();
    }

    /**
     * This method changes the explorer's state from LEAVING to CAMPING. He's
     * going to the camp.
     */
    public void reachCamp() {
        if (state == State.LEAVING) {
            state = State.CAMPING;
            this.chest.saveBag(this.bag);
        }
    }

    /**
     * This method allows to a explorer to start the exploration. His state will
     * be in "EXPLORING".
     */
    public void startExploration() {
        state = State.EXPLORING;
    }

    /**
     * This method empties the explorer's bag and he's going to the camp.
     */
    public void runAway() {
        bag.loseContent();
        state = State.CAMPING;
    }

    /**
     * This is the method hashcode.
     *
     * @return hash an integer.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.pseudonym);
        hash = 17 * hash + Objects.hashCode(this.bag);
        hash = 17 * hash + Objects.hashCode(this.state);
        return hash;
    }

    /**
     * This is the method equals.
     *
     * @param obj an object with Object in identifier.
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
        final Explorer other = (Explorer) obj;
        if (!Objects.equals(this.pseudonym, other.pseudonym)) {
            return false;
        }
        if (!Objects.equals(this.bag, other.bag)) {
            return false;
        }
        return this.state == other.state;
    }
}
