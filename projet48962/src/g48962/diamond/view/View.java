package g48962.diamond.view;

import g48962.diamond.exception.GameException;
import g48962.diamond.model.Explorer;
import g48962.diamond.model.Model;
import g48962.diamond.model.CaveEntrance;
import g48962.diamond.model.Hazard;
import g48962.diamond.model.HazardType;
import g48962.diamond.model.Relic;
import g48962.diamond.model.Tile;
import g48962.diamond.model.Treasure;
import java.util.List;
import java.util.Scanner;

/**
 * This is the View of the game.
 *
 * @author Nguyen Khanh-Michel.
 */
public class View {

    private final Scanner in;
    private final Model game;

    /**
     * This is the constructor of View.
     *
     * @param game is the model of the game.
     */
    public View(Model game) {
        this.in = new Scanner(System.in);
        this.game = game;
    }

    /**
     * This method asks to the user his pseudonym for his explorer.
     *
     * @return the explorer created after the pseudonym given.
     */
    public Explorer askExplorer() {
        System.out.println("Entrez le nom de votre explorateur: ");
        String pseudonym = in.next();
        Explorer explorer = new Explorer(pseudonym);

        return explorer;
    }

    /**
     * This method asks to the user if there is a new explorer to add.
     *
     * @return true if there is a new explorer to add.
     * @throws g48962.diamond.exception.GameException
     */
    public boolean isThereNewExplorerToAdd() throws GameException {
        boolean explorerToAdd = false;

        System.out.println("Voulez-vous ajouter un nouveau explorateur ?");
        String answer = in.next();
        while (!answer.equals("Oui") && !answer.equals("oui")
                && !answer.equals("Non") && !answer.equals("non")) {
            System.out.println("Veuillez entrer oui ou non,"
                    + " voulez-vous ajouter une nouveau explorateur ?");
            answer = in.next();
        }
        if (answer.equals("Oui") || answer.equals("oui")) {
            explorerToAdd = true;
        } else if (answer.equals("Non") || answer.equals("non")) {
            if (game.isThereEnoughExplorer() == false) {
                System.out.println("Il faut minimum 3 explorateurs.");
                return true;
            }
            return false;
        }
        return explorerToAdd;
    }

    /**
     * This method asks to every explorer if they want to keep exploring or not.
     *
     * @param explorer is the explorer.
     * @return true if the explorer from the parameter wants to keep exploring.
     */
    public boolean askExplorerChoiceToContinue(Explorer explorer) {
        boolean keepExploring = true;

        System.out.println(explorer.getPseudonym()
                + " voulez-vous continuer à explorer la grotte ?");
        String answer = in.next();
        while (!answer.equals("Oui") && !answer.equals("oui")
                && !answer.equals("Non") && !answer.equals("non")) {
            System.out.println(explorer.getPseudonym()
                    + ", veuillez entrer oui ou non,"
                    + " voulez-vous continuer à explorer la grotte ?");
            answer = in.next();
        }
        if (answer.equals("Oui") || answer.equals("oui")) {
            keepExploring = true;
        } else if (answer.equals("Non") || answer.equals("non")) {
            keepExploring = false;
        }
        return keepExploring;
    }

    /**
     * This method displays the phases of the game.
     */
    public void displayPhases() {
        System.out.println("-----------------------------------------------"
                + "---------------------");
        System.out.println(game.getCave().getNbExploredEntrance() + 1
                + " Phase d'exploration sur 5. ");
    }

    /**
     * This method displays the card picked.
     *
     * @param currentEntrance is the currentEntrance.
     */
    public void displayCardPicked(CaveEntrance currentEntrance) {
        System.out.println("Carte piochée : ");
        Tile lastDiscoveredTile = currentEntrance.getLastDiscoveredTile();
        if (lastDiscoveredTile instanceof Treasure) {
            lastDiscveredTileIsTreasure(lastDiscoveredTile);
        } else if (lastDiscoveredTile instanceof Hazard) {
            lastDiscoveredTileIsHazard(lastDiscoveredTile);
        } else if (lastDiscoveredTile instanceof Relic) {
            lastDiscoveredTileIsRelic();
        }
        if (lastDiscoveredTile instanceof Treasure) {
            lastDiscoveredTileIsTreasureLeft(lastDiscoveredTile);
        }
    }

    /**
     * This method displays the last discovered tile when the tile is a
     * Treasure.
     *
     * @param lastDiscoveredTile is the last discovred tile.
     */
    public void lastDiscveredTileIsTreasure(Tile lastDiscoveredTile) {
        Treasure lastDiscoveredTreasure = (Treasure) lastDiscoveredTile;
        int initNbRubies = lastDiscoveredTreasure.getInitNbGems();
        System.out.println("-----------------------------------------------"
                + "---------------------");
        System.out.println("Nombre de rubis lors de sa création: "
                + initNbRubies);
    }

    /**
     * This method displays the last discovered tile when the tile is a Hazard.
     *
     * @param lastDiscoveredTile is the last discovered tile.
     */
    public void lastDiscoveredTileIsHazard(Tile lastDiscoveredTile) {
        Hazard lastDiscoveredHazard = (Hazard) lastDiscoveredTile;
        HazardType hazard = lastDiscoveredHazard.getType();
        System.out.println("-----------------------------------------------"
                + "---------------------");
        System.out.println("Une carte danger est apparue : " + hazard
                + " !");
        System.out.println("-----------------------------------------------"
                + "---------------------");
    }

    /**
     * This method displays the relic.
     */
    public void lastDiscoveredTileIsRelic() {
        System.out.println("-----------------------------------------------"
                + "---------------------");
        System.out.println("Une carte relique est apparue : Relique !");
        System.out.println("-----------------------------------------------"
                + "---------------------");
    }

    /**
     * This method displays the rubies left on the card Treasure.
     *
     * @param lastDiscoveredTile is the last discovered tile.
     */
    public void lastDiscoveredTileIsTreasureLeft(Tile lastDiscoveredTile) {
        Treasure lastDiscoveredTreasure = (Treasure) lastDiscoveredTile;
        int nbRubies = lastDiscoveredTreasure.getGems().size();
        System.out.println("Nombre de rubis présent sur la carte Trésor: "
                + nbRubies);
        System.out.println("-----------------------------------------------"
                + "---------------------");
    }

    /**
     * This method allows to displays the list of the explorers et their bags.
     */
    public void displayListExplorersBagAndChest() {
        System.out.println("Liste des noms des explorateurs et du nombre "
                + "de rubis dans leur sac : ");
        List<Explorer> explorers = game.getExplorers();
        for (Explorer explorer : explorers) {
            System.out.println(explorer.getPseudonym() + " a "
                    + explorer.getBag().getValue() + " rubis"
                    + " dans son sac. Coffre : " + explorer.getFortune());
        }
        System.out.println("---------------------------------------------------"
                + "-----------------");
    }

    /**
     * This method will display the game's state. It has the last discovered
     * tile and also shows every explorer.
     */
    public void displayGame() {
        CaveEntrance currentEntrance = game.getCave().getCurrentEntrance();
        displayPhases();
        displayCardPicked(currentEntrance);
        displayListExplorersBagAndChest();
        turnResumeDisplay();
    }

    /**
     * This method displays to the user that the game is over and also all the
     * explorers.
     *
     * @throws g48962.diamond.exception.GameException
     */
    public void disPlayWinner() throws GameException {
        boolean isOver = game.isOver();
        if (isOver == true) {
            System.out.println("-----------------------------------------------"
                    + "---------------------");
            System.out.println("-----------------------------------------------"
                    + "---------------------");
            displayListExplorersBagAndChest();
            System.out.println("Le jeu est terminé !");
            System.out.println("Le vainqueur de la partie est "
                    + game.getWinner().getPseudonym() + " !");
            System.out.println("-----------------------------------------------"
                    + "---------------------");
            System.out.println("-----------------------------------------------"
                    + "---------------------");
        }
    }

    /**
     * This method asks to the view the tile's path discovered by the explorers
     * and the exploreres's state who are keep exploring.
     */
    public void turnResumeDisplay() {
        CaveEntrance currentEntrance = game.getCave().getCurrentEntrance();
        List<Tile> tile = currentEntrance.getPath();
        List<Explorer> explorers = game.getExploringExplorers();
        System.out.println("Liste des tuiles découvertes lors de "
                + "l'exploration : ");
        for (Tile tile1 : tile) {
            displayPath(tile1);
        }
        System.out.println("");
        System.out.print("Explorateurs en cours d'exploration : ");
        for (Explorer explorer : explorers) {
            System.out.print(explorer.getPseudonym() + "  ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------------"
                + "---------------------");
    }

    /**
     * This method allows to warn the users that the exploration is over.
     */
    public void displayRunAway() {
        System.out.println("---------------------------------------------------"
                + "-----------------");
        System.out.println("---------------------------------------------------"
                + "-----------------");
        System.out.println("La phase d'exploration est terminée !");
        System.out.println("Une nouvelle phase d'exploration va débuter !");
    }

    /**
     * This method allows to display the path.
     *
     * @param tile is a tile.
     */
    public void displayPath(Tile tile) {
        if (tile instanceof Treasure) {
            System.out.println("{" + ((Treasure) tile).getInitNbGems() + "}");
        } else if (tile instanceof Hazard) {
            System.out.println("{" + ((Hazard) tile).getType() + "}");
        } else if (tile instanceof Relic) {
            System.out.println("{" + "Relique" + "}");
        }
    }
}
