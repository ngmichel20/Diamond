package g48962.diamond.model;

import java.util.List;

/**
 * This class represents a hazard's room and implements the interface "Tile".
 *
 * @author Nguyen Khanh-Michel.
 */
public class Hazard implements Tile {

    private final HazardType type;
    private boolean explorersEscapeReason;

    /**
     * This is the constructor of Hazard class.
     *
     * @param type is a hazard type.
     */
    public Hazard(HazardType type) {
        this.type = type;
    }

    /**
     * This is the getter of HazardType.
     *
     * @return a hazard type.
     */
    public HazardType getType() {
        return type;
    }

    /**
     * This method is the getter of explorersEscapeReason.
     *
     * @return explorersEscapeReason it identifies the tiles that taunt the
     * escape of the explorers.
     */
    public boolean isExplorersEscapeReason() {
        return explorersEscapeReason;
    }

    /**
     * This method allows to put true to the attribut explorersEscapeReason.
     */
    public void escape() {
        this.explorersEscapeReason = true;
    }

    @Override
    public void explore(List<Explorer> explorers) {

    }

}
