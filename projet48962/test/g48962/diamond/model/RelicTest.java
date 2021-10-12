/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g48962.diamond.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michel
 */
public class RelicTest {
    
    /**
     * Test of canBeTaken method, of class Relic.
     */
    @Test
    public void testCanBeTaken() {
        System.out.println("canBeTaken");
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);        
        List<Explorer> explorers = new ArrayList<>();
        explorers.add(explorer);
        explorer.takeDecisionToLeave();
        Relic instance = new Relic();
        boolean expResult = true;
        boolean result = instance.canBeTaken(explorers);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertGemValue method, of class Relic.
     */
    @Test
    public void testConvertGemValue() {
        System.out.println("convertGemValue");
        int nbTakenRelics = 0;
        Relic instance = new Relic();
        instance.convertGemValue(nbTakenRelics);
        int valueInDiamonds = instance.getValueInDiamonds();
        assertEquals(valueInDiamonds, 1);
    }

    /**
     * Test of explore method, of class Relic.
     */
    @Test
    public void testExplore() {
        System.out.println("explore");
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        List<Explorer> explorers = new ArrayList<>();
        explorers.add(explorer);
        Relic instance = new Relic();
        instance.convertGemValue(0);
        instance.explore(explorers);
        assertEquals(explorers.get(0).getBag().getValue(), 5);
    }
    
}
