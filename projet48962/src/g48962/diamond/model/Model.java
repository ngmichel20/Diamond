package g48962.diamond.model;

import g48962.diamond.exception.GameException;
import java.util.List;

/**
 * Facade of Diamant.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 * Facade pattern
 * </a>
 * @see
 * <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 * @author EsiProf
 */
public interface Model {

    /**
     * This method can be used to add new player (explorer) in the game.
     *
     * @param explorer the explorer to add.
     * @throws g48962.diamond.exception.GameException
     * @throws RuntimeException if it is not possible to add explorers anymore.
     */
    void addExplorer(Explorer explorer) throws GameException;

    /**
     * Make all exploring explorers move forward in current entrance. If the
     * cave is un an unsafe's state, the explorers must run away.
     */
    void moveForward();

    /**
     * Declares if it's the end of an exploration's phase.
     *
     * @return true if it's the end of an exploration's phase.
     */
    boolean isExplorationPhaseOver();

    /**
     * Return the cave of the game.
     *
     * @return the game's cave.
     */
    Cave getCave();

    /**
     * Give all explorers of the game. They could be exploring or leaving.
     *
     * @return all the explorers of the game.
     */
    List<Explorer> getExplorers();

    /**
     * Give all explorers which are exploring.
     *
     * @return explorers in the cave.
     */
    List<Explorer> getExploringExplorers();

    /**
     * Consider the choice of the explorer to leave the cave.
     *
     * @param explorer The explorer who make the choice to leave.
     * @throws g48962.diamond.exception.GameException
     * @throws RuntimeException If the explorer is not in the current game.
     */
    void handleExplorerDecisionToLeave(Explorer explorer) throws GameException;

    /**
     * Doesn't do anything. Only start the game.
     */
    void start() throws GameException;

    /**
     * This method checks if there is enough explorers.
     *
     * @return true if there is at least 3 explorers.
     */
    boolean isThereEnoughExplorer();

    /**
     * This method allows to add if possible a new explorer in the game.
     *
     * @return true it is possible to add a new explorer.
     */
    boolean itIsPossibleToAddExplorer();

    /**
     * This method allows to have the explorer that owns the biggest fortune.
     *
     * @return the explorer that has the bigger amount of rubies.
     * @throws g48962.diamond.exception.GameException
     */
    Explorer getWinner() throws GameException;

    /**
     * This method allows to all the explorers to leave the cave if they wish
     * it.
     */
    void makeExplorersLeave();

    /**
     * This method opens a new entrance and the explorers are in a exploration's
     * state.
     *
     * @throws g48962.diamond.exception.GameException
     */
    void startNewExplorationPhase() throws GameException;

    /**
     * This method ends the exploration's phase. The current entrance is locked
     * out.
     *
     * @throws g48962.diamond.exception.GameException
     */
    void endExplorationPhase() throws GameException;

    /**
     * Declares if it's the end of the game.
     *
     * @return true if the game is not in an exploration's phase and if there
     * are no more entrance to explore.
     */
    boolean isOver();

    /**
     * This method allows to know if the exploration phase is safe or not.
     *
     * @return false if the exploration phase is not aborted.
     */
    boolean isExplorationPhaseAborted();

    /**
     * This method allows to know if there is the same pseudonym.
     */
    boolean samePseudonym(Explorer explorer);
}
