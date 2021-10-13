/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g48962.diamond.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Michel
 */
public class HazardTest {

    /**
     * Test of getType method, of class Hazard.
     */
    @Test
    public void testGetTypeBatteringRam() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.BATTERING_RAM);
        assertEquals(HazardType.BATTERING_RAM, instance.getType());
    }

    @Test
    public void testGetTypeSnakes() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.SNAKES);
        assertEquals(HazardType.SNAKES, instance.getType());
    }

    @Test
    public void testGetTypeGiantSpider() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.GIANT_SPIDER);
        assertEquals(HazardType.GIANT_SPIDER, instance.getType());
    }

    @Test
    public void testGetTypeLavaField() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.LAVA_FIELD);
        assertEquals(HazardType.LAVA_FIELD, instance.getType());
    }

    @Test
    public void testGetTypeStoneBall() {
        System.out.println("getType");
        Hazard instance = new Hazard(HazardType.STONE_BALL);
        assertEquals(HazardType.STONE_BALL, instance.getType());
    }
}
