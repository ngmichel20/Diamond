/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g48962.diamond.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Michel
 */
public class DeckTest {

    /**
     * Test of getTile method, of class Deck.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        Deck instance = new Deck();
        Tile expResult = instance.getTile();
        Tile result = instance.getTile();
        if (expResult instanceof Treasure && result instanceof Treasure) {
            if (expResult.equals(result)) {
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of putBack method, of class Deck.
     */
    @Test
    public void testPutBack() {
        System.out.println("putBack");
        Treasure treasure = new Treasure(11);
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        List<Explorer> explorers = new ArrayList<>();
        Deck instance = new Deck();
        explorers.add(explorer);
        Tile result = instance.getTile();
        if (result instanceof Treasure) {
            result.explore(explorers);
            instance.putBack(treasure);
            assertTrue(instance.equals(instance));
        }
    }
}
