package g48962.diamond.model;

import java.util.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TreasureTest {

    /*Test
    public void contructorWithoutAttribut() {
        Treasure treasure = new Treasure();
        int initNbRubies = treasure.getInitNbGems();
        int rubies = treasure.getRubies();
        boolean rubiesEqualsInitNbRubies = rubies == initNbRubies;
        boolean inBoundaries = (1 <= rubies && rubies <= 15);

        assertTrue(rubiesEqualsInitNbRubies && inBoundaries);
    }*/

    @Test
    public void contructorWithAttribut() {
        Treasure treasure = new Treasure(42);
        int initNbRubies = treasure.getInitNbGems();
        int rubies = treasure.getGems().size();

        assertTrue(initNbRubies == rubies && rubies == 42);
    }
/*
    @Test
    public void exploredByNoExplorer() {
        Treasure treasure = new Treasure();
        treasure.explore(Arrays.asList());
    }*/

    @Test
    public void exploredBy1Explorer() {
        System.out.println("test");
        Explorer e1 = new Explorer("e1");
        Treasure treasure = new Treasure(4);
        treasure.explore(Arrays.asList(e1));
        assertEquals(0, treasure.getGems().size());
    }

    @Test
    public void exploredBy2Explorers() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Treasure treasure = new Treasure(3);
        treasure.explore(Arrays.asList(e1, e2));
        assertEquals(1, treasure.getGems().size());
    }

    /**
     * Test of getRubies method, of class Treasure.
     */
    @Test
    public void testGetRubies() {
        System.out.println("getRubies");
        Treasure instance = new Treasure(10);
        int expResult = 10;
        int result = instance.getGems().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitNbRubies method, of class Treasure.
     */
    @Test
    public void testGetInitNbRubies() {
        System.out.println("getInitNbRubies");
        Treasure instance = new Treasure(10);
        int expResult = 10;
        int result = instance.getInitNbGems();
        assertEquals(expResult, result);
    }

    /**
     * Test of restore method, of class Treasure.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        String pseudonym = "Michel";
        List<Explorer> explorers = new ArrayList<>();
        Explorer explorer = new Explorer(pseudonym);
        explorers.add(explorer);
        Treasure instance = new Treasure(10);
        int result = instance.getGems().size();
        instance.getInitNbGems();
        instance.explore(explorers);
        instance.restore();
        assertEquals(10, result);
    }

    /**
     * Test of transferGemsFrom method, of class Treasure.
     */
    @Test
    public void testTransferGemsFrom() {
        System.out.println("transferGemsFrom");
        Treasure o = new Treasure(5);
        Treasure instance = new Treasure(0);
        instance.transferGemsFrom(o);
        assertEquals(instance.getGems(), instance.getGems());
    }
}
