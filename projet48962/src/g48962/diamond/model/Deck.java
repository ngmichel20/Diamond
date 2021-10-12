package g48962.diamond.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class represents the package's tiles.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Deck {

    private final List<Tile> tiles;

    /**
     * This is the constructor Deck. It has all the different tiles (Treasure
     * and Hazard).
     */
    public Deck() {
        this.tiles = new ArrayList<>();

        Treasure treasure1 = new Treasure(1);
        this.tiles.add(treasure1);
        Treasure treasure2 = new Treasure(2);
        this.tiles.add(treasure2);
        Treasure treasure3 = new Treasure(3);
        this.tiles.add(treasure3);
        Treasure treasure4 = new Treasure(4);
        this.tiles.add(treasure4);
        Treasure treasure5 = new Treasure(5);
        this.tiles.add(treasure5);
        Treasure treasure6 = new Treasure(5);
        this.tiles.add(treasure6);
        Treasure treasure7 = new Treasure(7);
        this.tiles.add(treasure7);
        Treasure treasure8 = new Treasure(7);
        this.tiles.add(treasure8);
        Treasure treasure9 = new Treasure(9);
        this.tiles.add(treasure9);
        Treasure treasure10 = new Treasure(11);
        this.tiles.add(treasure10);
        Treasure treasure11 = new Treasure(11);
        this.tiles.add(treasure11);
        Treasure treasure12 = new Treasure(13);
        this.tiles.add(treasure12);
        Treasure treasure13 = new Treasure(14);
        this.tiles.add(treasure13);
        Treasure treasure14 = new Treasure(15);
        this.tiles.add(treasure14);
        Treasure treasure15 = new Treasure(17);
        this.tiles.add(treasure15);

        for (int i = 0; i < 3; i++) {
            Hazard hazard1 = new Hazard(HazardType.BATTERING_RAM);
            this.tiles.add(hazard1);
        }

        for (int i = 0; i < 3; i++) {
            Hazard hazard2 = new Hazard(HazardType.GIANT_SPIDER);
            this.tiles.add(hazard2);
        }

        for (int i = 0; i < 3; i++) {
            Hazard hazard3 = new Hazard(HazardType.LAVA_FIELD);
            this.tiles.add(hazard3);
        }

        for (int i = 0; i < 3; i++) {
            Hazard hazard4 = new Hazard(HazardType.SNAKES);
            this.tiles.add(hazard4);
        }

        for (int i = 0; i < 3; i++) {
            Hazard hazard5 = new Hazard(HazardType.STONE_BALL);
            this.tiles.add(hazard5);
        }

        for (int i = 0; i < 5; i++) {
            Relic relic = new Relic();
            this.tiles.add(relic);
        }
    }

    /**
     * This method allows to have a random card from the deck.
     *
     * @return a random cad from the tile's list.
     */
    public Tile getTile() {
        Random random = new Random();
        int card = random.nextInt(this.tiles.size());
        Tile cardPicked = this.tiles.get(card);
        this.tiles.remove(card);
        return cardPicked;
    }

    /**
     * This method allows to put back a card in the deck.
     *
     * @param tile is a tile
     */
    public void putBack(Tile tile) {
        this.tiles.add(tile);
    }
}
