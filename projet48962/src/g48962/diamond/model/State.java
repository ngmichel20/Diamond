package g48962.diamond.model;

/**
 * This enumeration is used for the explorer's state. He can keep exploring in
 * the cave or leaving it.
 *
 * @author Nguyen Khanh-Michel.
 */
public enum State {

    /**
     * This state allows to the explorer if he keeps exploring the cave.
     */
    EXPLORING,
    /**
     * This state allows to the explorer to know if he's leaving the cave.
     */
    LEAVING,
    /**
     * This state allows to the explorer to know if he's in the camp.
     */
    CAMPING,
}
