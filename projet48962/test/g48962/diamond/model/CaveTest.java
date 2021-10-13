package g48962.diamond.model;

import g48962.diamond.exception.GameException;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class CaveTest {
    
    @Test
    public void discoverNewTreasureSameSharing() {
        Explorer e1 = new Explorer("e1");
        Explorer e2 = new Explorer("e2");
        Cave cave = new Cave();
        CaveEntrance instance = new CaveEntrance(cave);;
        instance.discoverNewTile(Arrays.asList(e1, e2));
        assertEquals(e1.getBag().getValue(), e2.getBag().getValue());
    }

    /**
     * Test of getNbExploredEntrance method, of class Cave.
     */
    @Test
    public void testGetNbExploredEntrance() {
        System.out.println("getNbExploredEntrance");
        Cave instance = new Cave();
        int expResult = 0;
        int result = instance.getNbExploredEntrance();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasNewEntranceToExplore method, of class Cave.
     */
    @Test
    public void testHasNewEntranceToExplore() throws GameException {
        System.out.println("hasNewEntranceToExplore");
        Cave instance = new Cave();
        instance.openNewEntrance();
        instance.lockOutCurrentEntrance();
        boolean expResult = true;
        boolean result = instance.hasNewEntranceToExplore();
        assertEquals(expResult, result);
    }

    /**
     * Test of openNewEntrance method, of class Cave.
     */
    @Test
    public void testOpenNewEntrance() throws Exception {
        System.out.println("openNewEntrance");
        Cave instance = new Cave();
        instance.openNewEntrance();
        assertFalse(instance.getCurrentEntrance().isLockedOut());
    }

    /**
     * Test of lockOutCurrentEntrance method, of class Cave.
     */
    @Test
    public void testLockOutCurrentEntrance() throws Exception {
        System.out.println("lockOutCurrentEntrance");
        Cave instance = new Cave();
        instance.openNewEntrance();
        instance.lockOutCurrentEntrance();
        assertTrue(instance.getCurrentEntrance().isLockedOut());
    }
    /**
     * Test of isLastEntranceUnsafe method, of class Cave.
     */
    @Test

    public void testIsLastEntranceUnsafe() throws GameException {
        System.out.println("isLastEntranceUnsafe");
        Cave instance = new Cave();
        instance.openNewEntrance();
        boolean expResult = false;
        boolean result = instance.isLastEntranceUnsafe();
        assertEquals(expResult, result);
    }

    /**
     * Test of incrementNbTakenRelics method, of class Cave.
     */
    @Test
    public void testIncrementNbTakenRelics() {
        System.out.println("incrementNbTakenRelics");
        Cave instance = new Cave();
        instance.incrementNbTakenRelics();
        assertEquals(1, instance.getNbTakenRelics());
    }
}
