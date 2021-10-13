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
public class CaveEntranceTest {

    /**
     * Test of getPath method, of class CaveEntrance.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        List<Tile> expResult = new ArrayList<>();
        List<Tile> result = instance.getPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLockedOut method, of class CaveEntrance.
     */
    @Test
    public void testIsLockedOut() {
        System.out.println("isLockedOut");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        boolean expResult = false;
        boolean result = instance.isLockedOut();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUnsafe method, of class CaveEntrance.
     */
    @Test
    public void testIsUnsafe() {
        System.out.println("isUnsafe");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        boolean expResult = false;
        boolean result = instance.isUnsafe();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastDiscoveredTile method, of class CaveEntrance.
     */
    @Test
    public void testGetLastDiscoveredTile() {
        System.out.println("getLastDiscoveredTile");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        Tile expResult = null;
        Tile result = instance.getLastDiscoveredTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTileToPath method, of class CaveEntrance.
     */
    @Test
    public void testAddTileToPath() {
        System.out.println("addTileToPath");
        Treasure treasure = new Treasure(10);
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.addTileToPath(treasure);
        assertTrue(instance.getPath().contains(treasure));
    }

    /**
     * Test of discoverNewTile method, of class CaveEntrance.
     */
    @Test
    public void testDiscoverNewTile() {
        System.out.println("discoverNewTile");
        List<Explorer> explorers = new ArrayList<>();
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.discoverNewTile(explorers);
    }

    /**
     * Test of returnToCamp method, of class CaveEntrance.
     */
    @Test
    public void testReturnToCamp() {
        System.out.println("returnToCamp");
        List<Explorer> explorers = new ArrayList<>();
        Treasure treasure = new Treasure(10);
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.addTileToPath(treasure);
        instance.returnToCamp(explorers);
    }

    /**
     * Test of lockOut method, of class CaveEntrance.
     */
    @Test
    public void testLockOut() {
        System.out.println("lockOut");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        instance.lockOut();
        assertTrue(instance.isLockedOut());
    }

    /**
     * Test of getFirstTreasureTile method, of class CaveEntrance.
     */
    @Test
    public void testGetFirstTreasureTile() {
        System.out.println("getFirstTreasureTile");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        Treasure expResult = null;
        Treasure result = instance.getFirstTreasureTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeLastTileExplored method, of class CaveEntrance.
     */
    @Test
    public void testMakeLastTileExplored() {
        System.out.println("makeLastTileExplored");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        List<Explorer> explorers = new ArrayList<>();
        explorers.add(explorer);
        int nbGems = 0;
        for (int i = 0; i < 5; i++) {
            instance.discoverNewTile(explorers);
            if (instance.getLastDiscoveredTile() instanceof Treasure) {
                Treasure treasure = (Treasure) instance.getLastDiscoveredTile();
                nbGems = nbGems + treasure.getGems().size();
            }
        }
        instance.makeLastTileExplored();
        assertEquals(instance.getFirstTreasureTile().getGems().size(), nbGems);
    }

}
