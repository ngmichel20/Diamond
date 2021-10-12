package g48962.diamond.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Nguyen Khanh-Michel.
 */
public class BagTest {
    
    @Test
    public void getNbRubiesCaseNoRuby() {
        Bag bag = new Bag();
        assertEquals(0, bag.getValue());
    }

    @Test
    public void addGemsOneTime() {
        Bag bag = new Bag();
        Gem gem = Gem.RUBY;
        bag.addGem(gem);
        assertEquals(1, bag.getValue());
    }

    @Test
    public void addGemsTwoTime() {
        Bag bag = new Bag();
        bag.addGem(Gem.DIAMOND);
        bag.addGem(Gem.RUBY);
        assertEquals(6, bag.getValue());
    }

    @Test
    public void equalsTestTrueAfterInit() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        assertEquals(bag1.getValue(), bag2.getValue());
    }

    @Test
    public void equalsTestTrueAfterAdding() {
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        bag1.addGem(Gem.RUBY);
        bag2.addGem(Gem.RUBY);
        assertEquals(bag1.getValue(), bag2.getValue());
    }

    @Test
    public void equalsFalseOtherObject() {
        Bag bag1 = new Bag();
        String bag2 = "bag2";
        assertFalse(bag1.equals(bag2));
    }

    @Test
    public void equalsFalseNull() {
        Bag bag1 = new Bag();
        assertFalse(bag1.equals(null));
    }

    /**
     * Test of getNbRubies method, of class Bag.
     */
    @Test
    public void testGetNbRubies() {
        System.out.println("getNbRubies");
        int expResult = 5;
        Bag instance = new Bag();
        instance.addGem(Gem.DIAMOND);
        assertEquals(expResult, instance.getValue());
    }

    /**
     * Test of addGem method, of class Bag.
     */
//    @Test
//    public void testAddRubies() {
//        System.out.println("addRubies");
//        int nbRubies = 0;
//        Bag instance = new Bag();
//        nbRubies = nbRubies + 5;
//        instance.addGem(nbRubies);
//        assertEquals(5, instance.getGems());
//    }

    /**
     * Test of loseContent method, of class Bag.
     */
    @Test
    public void testLoseContent() {
        System.out.println("loseContent");
        Bag instance = new Bag();
        instance.addGem(Gem.DIAMOND);
        instance.loseContent();
        assertEquals(0, instance.getValue());
    }
    @Test
    public void getValue(){
        System.out.println("getValue");
        int total = 6;
        Bag instance = new Bag();
        instance.addGem(Gem.RUBY);
        instance.addGem(Gem.DIAMOND);
        assertEquals(total, instance.getValue());
    }

    /**
     * Test of equals method, of class Bag.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Object();
        Bag instance = new Bag();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
}
