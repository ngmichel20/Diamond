package g48962.diamond.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorerTest {

    @Test
    public void getPseudonym() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals("Sdr", explorer.getPseudonym());
    }

    @Test
    public void getStateBeforeTakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(State.CAMPING, explorer.getState());
    }

    @Test
    public void getStateAftertakeDecisionToLeave() {
        Explorer explorer = new Explorer("Sdr");
        explorer.takeDecisionToLeave();
        assertEquals(State.LEAVING, explorer.getState());
    }

    @Test
    public void getBagBeforAddingToBag() {
        Explorer explorer = new Explorer("Sdr");
        assertEquals(0, explorer.getBag().getValue());
    }

    @Test
    public void addToBag1Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(Gem.DIAMOND);
        assertEquals(5, explorer.getBag().getValue());
    }

    @Test
    public void addToBag2Times() {
        Explorer explorer = new Explorer("Sdr");
        explorer.addToBag(Gem.DIAMOND);
        explorer.addToBag(Gem.RUBY);
        assertEquals(6, explorer.getBag().getValue());
    }

    @Test
    public void equalsTrue() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("mcd");
        assertTrue(e1.getPseudonym().equals(e2.getPseudonym()));
    }

    @Test
    public void equalsFalseDifferent() {
        Explorer e1 = new Explorer("mcd");
        Explorer e2 = new Explorer("pbt");
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Explorer e1 = new Explorer("mcd");
        String e2 = "mcd";
        assertFalse(e1.equals(e2));
    }

    @Test
    public void equalsFalseNull() {
        Explorer e1 = new Explorer("mcd");
        assertFalse(e1.equals(null));
    }

    /**
     * Test of getBag method, of class Explorer.
     */
    @Test
    public void testGetBag() {
        System.out.println("getBag");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        Bag expResult = new Bag();
        Bag result = instance.getBag();
        assertEquals(expResult.getGems(), result.getGems());
    }

    /**
     * Test of getState method, of class Explorer.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        State expResult = State.CAMPING;
        State result = instance.getState();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of takeDecisionToLeave method, of class Explorer.
     */
    @Test
    public void testTakeDecisionToLeave() {
        System.out.println("takeDecisionToLeave");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        instance.takeDecisionToLeave();
        assertEquals(instance.getState(), State.LEAVING);
    }

    /**
     * Test of getFortune method, of class Explorer.
     */
    @Test
    public void testGetFortune() {
        System.out.println("getFortune");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        instance.addToBag(Gem.DIAMOND);
        instance.takeDecisionToLeave();
        instance.reachCamp();
        int result = instance.getFortune();
        assertEquals(5, result);
    }

    /**
     * Test of reachCamp method, of class Explorer.
     */
    @Test
    public void testReachCamp() {
        System.out.println("reachCamp");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        instance.reachCamp();
        assertEquals(instance.getState(), State.CAMPING);
    }

    /**
     * Test of startExploration method, of class Explorer.
     */
    @Test
    public void testStartExploration() {
        System.out.println("startExploration");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        instance.startExploration();
        assertEquals(instance.getState(), State.EXPLORING);
    }

    /**
     * Test of runAway method, of class Explorer.
     */
    @Test
    public void testRunAway() {
        System.out.println("runAway");
        String pseudonym = "Michel";
        Explorer instance = new Explorer(pseudonym);
        instance.addToBag(Gem.DIAMOND);
        instance.runAway();
        assertEquals(instance.getState(), State.CAMPING);
        assertEquals(instance.getBag().getValue(), 0);
    }
}
