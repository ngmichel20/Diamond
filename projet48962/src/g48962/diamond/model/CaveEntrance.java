package g48962.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to manage an entrance of the cave.
 *
 * @author Nguyen Khanh-Michel.
 */
public class CaveEntrance {

    private Tile lastDiscoveredTile;
    private final List<Tile> path;
    private boolean lockedOut;
    private final Cave cave;
    private boolean unsafe;
    private boolean treasureFound;
    private Treasure firstTreasureTile;

    /**
     * This a constructor "CaveEntrance" and he has a cave and a list of "path".
     *
     * @param cave is the cave of the game.
     */
    public CaveEntrance(Cave cave) {
        this.path = new ArrayList<>();
        this.cave = cave;
        this.treasureFound = false;
    }

    /**
     * This is the getter of path.
     *
     * @return path, a list of Tile.
     */
    public List<Tile> getPath() {
        return path;
    }

    /**
     * This is the getter of "lockedOut".
     *
     * @return false if the cave entrance is not locked out.
     */
    public boolean isLockedOut() {
        return lockedOut;
    }

    /**
     * This is the getter of unsafe.
     *
     * @return false if it's safe.
     */
    public boolean isUnsafe() {
        return unsafe;
    }

    /**
     * This is the getter of lastDiscoveredTile.
     *
     * @return lastDiscoveredTile return the last tilePick discovered.
     */
    public Tile getLastDiscoveredTile() {
        return lastDiscoveredTile;
    }

    /**
     * This is the getter of firstTreasureTile.
     *
     * @return a treasure.
     */
    public Treasure getFirstTreasureTile() {
        return firstTreasureTile;
    }

    /**
     * This method allows to add the tile picked to the path.
     *
     * @param tile is the tile picked.
     */
    void addTileToPath(Tile tile) {
        path.add(tile);
    }

    /**
     * This method allows togive fairly the treasure if a Treasure's tile is
     * picked. If a Hazard's tile is picked, it will check if it was already
     * picked first.
     *
     * @param explorers is the list of explorers.
     */
    public void discoverNewTile(List<Explorer> explorers) {
        Tile tilePick = this.cave.getDeck().getTile();
        if (tilePick instanceof Hazard) {
            for (Tile tile1 : path) {
                if (tile1 instanceof Hazard) {
                    if (((Hazard) tile1).getType().equals(((Hazard) tilePick).getType())) {
                        unsafe = true;
                        ((Hazard) tilePick).escape();
                    }
                }
            }
        }
        addTileToPath(tilePick);
        if (tilePick instanceof Treasure) {
            tilePick.explore(explorers);
            if (!treasureFound) {
                this.firstTreasureTile = (Treasure) tilePick;
                treasureFound = true;
            }
        }
        this.lastDiscoveredTile = tilePick;
    }

    /**
     * This method allows to all the explorers to explore the path at their
     * return to the camp.
     *
     * @param explorers is a list of explorers.
     */
    public void returnToCamp(List<Explorer> explorers) {
        List<Tile> tiles = this.path;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i) instanceof Relic) {
                Relic relic = (Relic) tiles.get(i);
                if (relic.canBeTaken(explorers)) {
                    cave.incrementNbTakenRelics();
                    int nbTakenRelics = cave.getNbTakenRelics();
                    relic.convertGemValue(nbTakenRelics);
                    relic.explore(explorers);
                    tiles.remove(i);
                    i = i - 1;
                }
            }
        }
        if (this.firstTreasureTile != null) {
            this.firstTreasureTile.explore(explorers);
        }
    }

    /**
     * This method allows to lock out a cave.
     */
    public void lockOut() {
        lockedOut = true;
    }

    /**
     * This method allows to put all the rubies of the last discovered treasure
     * from the path list to the first discovered treasure(of the path list).
     */
    public void makeLastTileExplored() {
        for (int i = this.path.size() - 1; i >= 0; i--) {
            if (this.path.get(i) != this.firstTreasureTile) {
                if (this.path.get(i) instanceof Treasure) {
                    this.firstTreasureTile.transferGemsFrom((Treasure) this.path.get(i));
                }
            }
        }
    }
}
