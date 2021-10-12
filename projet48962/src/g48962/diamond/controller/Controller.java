package g48962.diamond.controller;

import g48962.diamond.exception.GameException;
import g48962.diamond.model.Explorer;
import g48962.diamond.model.Model;
import g48962.diamond.view.View;
import java.util.List;

/**
 * This is the Controller of the game.
 *
 * @author Nguyen Khanh-Michel.
 */
public class Controller {

    private final Model game;
    private final View view;

    /**
     * This is the constructor "Controller".
     *
     * @param game is the facade pattern of the game.
     * @param view is the view (the display) of the game.
     */
    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * This method allows to start the game.
     *
     * @throws g48962.diamond.exception.GameException
     */
    public void startGame() throws GameException {
        Explorer explorer = view.askExplorer();
        game.addExplorer(explorer);
        while (view.isThereNewExplorerToAdd()) {
            explorer = view.askExplorer();
            if (game.samePseudonym(explorer)) {
                game.addExplorer(explorer);
            }
        }
        while (!game.isOver()) {
            List<Explorer> explorers = game.getExplorers();
            game.startNewExplorationPhase();
            game.moveForward();
            view.displayGame();
            while (!game.isExplorationPhaseOver()
                    && !game.isExplorationPhaseAborted()) {
                for (Explorer explorer1 : explorers) {
                    if (!view.askExplorerChoiceToContinue(explorer1)) {
                        explorer1.takeDecisionToLeave();
                    }
                }
                game.makeExplorersLeave();
                if (!game.isExplorationPhaseOver()) {
                    explorers = game.getExploringExplorers();
                    game.moveForward();
                    view.displayGame();
                }
            }
            game.endExplorationPhase();
            if (game.getCave().getNbExploredEntrance() < 5) {
                view.displayRunAway();
            }
        }
        view.disPlayWinner();
    }
}
