package g48962.diamond.model;

import g48962.diamond.exception.GameException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void addAndGetExplorerGoodNumberOfExplorers() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        assertEquals(2, game.getExplorers().size());
    }

    @Test
    public void addAndGetExplorerGoodExplorers() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("mcd");

        game.addExplorer(e1);
        game.addExplorer(e2);

        /*
         * If this test is false, check if you implement the
         * Explorer's equals method...
         */
        assertTrue(game.getExplorers().contains(e1)
                && game.getExplorers().contains(e2));
    }

    @Test
    public void treatChoiceToLeave() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(e1.getState() == State.LEAVING);
    }

    @Test(expected = GameException.class)
    public void treatChoiceToLeaveException() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        game.handleExplorerDecisionToLeave(e1);
    }

    @Test
    public void moveForwardExploringExplorerGetRubies() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        e2.startExploration();
        e1.startExploration();
        game.handleExplorerDecisionToLeave(e1);
        game.startNewExplorationPhase();
        game.moveForward();
        if (game.getCave().getCurrentEntrance().getLastDiscoveredTile() instanceof Treasure) {
            assertTrue(e2.getBag().getValue() > 0); //si c'est une carte treasure
        } else {
            assertTrue(e2.getBag().getValue() == 0); //si c'est une carte hazard
        }
    }

    @Test
    public void moveForwardLeavingExplorerDoNotGetRubies() throws
            GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        Explorer e2 = new Explorer("pbt");
        game.addExplorer(e1);
        game.addExplorer(e2);
        game.startNewExplorationPhase();
        game.handleExplorerDecisionToLeave(e1);
        game.moveForward();
        if (game.getCave().getCurrentEntrance().getLastDiscoveredTile() instanceof Treasure) {
            assertTrue(e2.getBag().getValue() > 0); //si c'est une carte treasure
        } else {
            assertTrue(e2.getBag().getValue() == 0); //si c'est une carte hazard
        }
    }

    @Test
    public void isExplorationPhaseOverNoExplorers() {
        Game game = new Game();
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void isExplorationPhaseOverExploringExplorer() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        game.startNewExplorationPhase();
        assertFalse(game.isExplorationPhaseOver());
    }

    @Test
    public void isExplorationPhaseOverExplorerIsLeaving() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("sdr");
        game.addExplorer(e1);
        game.handleExplorerDecisionToLeave(e1);
        assertTrue(game.isExplorationPhaseOver());
    }

    @Test
    public void getExploringExplorers() throws GameException {
        Game game = new Game();
        Explorer e1 = new Explorer("pbt");
        Explorer e2 = new Explorer("sdr");
        game.addExplorer(e1);
        game.addExplorer(e2);
        e1.startExploration();
        e2.startExploration();
        game.handleExplorerDecisionToLeave(e1);
        List<Explorer> exploringExplorers = game.getExploringExplorers();
        assertTrue(exploringExplorers.size() == 1
                && exploringExplorers.contains(e2));
    }

    /**
     * Test of handleExplorerDecisionToLeave method, of class Game.
     */
    @Test
    public void testHandleExplorerDecisionToLeave() throws Exception {
        System.out.println("handleExplorerDecisionToLeave");
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        Game instance = new Game();
        instance.addExplorer(explorer);
        instance.handleExplorerDecisionToLeave(explorer);
        assertEquals(explorer.getState(), State.LEAVING);
    }

    /**
     * Test of isThereEnoughExplorer method, of class Game.
     */
    @Test
    public void testIsThereEnoughExplorerFalse() throws GameException {
        System.out.println("isThereEnoughExplorer");
        Game instance = new Game();
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        instance.addExplorer(explorer);
        boolean expResult = false;
        boolean result = instance.isThereEnoughExplorer();
        assertEquals(expResult, result);
    }

    /**
     * Test of itIsPossibleToAddExplorer method, of class Game.
     */
    @Test
    public void testItIsPossibleToAddExplorer() throws GameException {
        System.out.println("itIsPossibleToAddExplorer");
        Game instance = new Game();
        String pseudonym1 = "Michel";
        String pseudonym2 = "Vincent";
        Explorer explorer1 = new Explorer(pseudonym1);
        Explorer explorer2 = new Explorer(pseudonym2);
        instance.addExplorer(explorer1);
        instance.addExplorer(explorer2);
        boolean expResult = true;
        boolean result = instance.itIsPossibleToAddExplorer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWinner method, of class Game.
     */
    @Test
    public void testGetWinner() throws Exception {
        System.out.println("getWinner");
        Game instance = new Game();
        String pseudonym = "Michel";
        String pseudonym2 = "Vincent";
        Explorer expResult1 = new Explorer(pseudonym);
        Explorer expResult2 = new Explorer(pseudonym2);
        instance.addExplorer(expResult1);
        instance.addExplorer(expResult2);
        instance.startNewExplorationPhase();
        expResult2.takeDecisionToLeave();
        instance.moveForward();
        if (instance.getCave().getCurrentEntrance().getLastDiscoveredTile() instanceof Treasure) {
            expResult1.takeDecisionToLeave();
            instance.endExplorationPhase();
            Explorer result = instance.getWinner();
            assertEquals(expResult1, result);
        }
    }

    /**
     * Test of makeExplorersLeave method, of class Game.
     */
    @Test
    public void testMakeExplorersLeave() throws GameException {
        System.out.println("makeExplorersLeave");
        Game instance = new Game();
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        instance.addExplorer(explorer);
        instance.startNewExplorationPhase();
        instance.moveForward();
        Deck deck = instance.getCave().getDeck();
        Tile tileDiscovered = deck.getTile();
        if (tileDiscovered instanceof Treasure) {
            System.out.println("trésor");
        } else if (tileDiscovered instanceof Hazard) {
            System.out.println("Monstre");
        }
        //instance.getCave().getCurrentEntrance().addTileToPath(tileDiscovered);
        explorer.takeDecisionToLeave();
        instance.makeExplorersLeave();
        assertEquals(explorer.getState(), State.CAMPING);
    }

    /**
     * Test of startNewExplorationPhase method, of class Game.
     */
    @Test
    public void testStartNewExplorationPhase() throws Exception {
        System.out.println("startNewExplorationPhase");
        Game instance = new Game();
        instance.startNewExplorationPhase();

    }

    /**
     * Test of endExplorationPhase method, of class Game.
     */
    @Test
    public void testEndExplorationPhase() throws Exception {
        System.out.println("endExplorationPhase");
        Game instance = new Game();
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        instance.addExplorer(explorer);
        instance.startNewExplorationPhase();
        instance.moveForward();
        Deck deck = instance.getCave().getDeck();
        Tile tileDiscovered = deck.getTile();
        if (tileDiscovered instanceof Treasure) {
            System.out.println("trésor");
        } else if (tileDiscovered instanceof Hazard) {
            System.out.println("Monstre");
        }
        instance.endExplorationPhase();
        assertTrue(instance.getCave().getCurrentEntrance().isLockedOut());
//        assertTrue(instance.getCave().getCurrentEntrance().equals()
//        (instance.getCave().getCurrentEntrance().isLockedOut()));
    }

    /**
     * Test of isOver method, of class Game.
     */
    @Test
    public void testIsOver() throws GameException {
        System.out.println("isOver");
        Game instance = new Game();
        instance.startNewExplorationPhase();
        boolean expResult = false;
        boolean result = instance.isOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of isExplorationPhaseAborted method, of class Game.
     */
    @Test
    public void testIsExplorationPhaseAborted() throws GameException {
        System.out.println("isExplorationPhaseAborted");
        Game instance = new Game();
        String pseudonym = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        instance.addExplorer(explorer);
        instance.startNewExplorationPhase();
        instance.moveForward();
        boolean expResult = false;
        boolean result = instance.isExplorationPhaseAborted();
        assertEquals(expResult, result);
    }

    /**
     * Test of samePseudonym method, of class Game.
     */
    @Test
    public void testSamePseudonym() throws GameException {
        System.out.println("samePseudonym");
        String pseudonym = "Michel";
        String pseudonym2 = "Michel";
        Explorer explorer = new Explorer(pseudonym);
        Explorer explorer2 = new Explorer(pseudonym2);
        Game instance = new Game();
        instance.addExplorer(explorer);
        boolean expResult = false;
        boolean result = instance.samePseudonym(explorer2);
        assertEquals(expResult, result);
    }
}
