package g48962.diamond.main;

import g48962.diamond.controller.Controller;
import g48962.diamond.exception.GameException;
import g48962.diamond.model.Game;
import g48962.diamond.view.View;

/**
 * This class is the main, the one who will run the game.
 *
 * @author Nguyen Khanh-Michel
 */
public class Main {

    /**
     * This is the main method.
     *
     * @param args l.
     */
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Controller controller = new Controller(game, view);
        try {
            controller.startGame();
        } catch (GameException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
