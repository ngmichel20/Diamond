package g48962.diamond.model;

import g48962.diamond.exception.GameException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class allow to bring all the elements of the game already coded
 * together. It's the facade pattern.
 *
 * @author Nguyen Khanh Michel
 */
public class Game implements Model {

    private final List<Explorer> explorers;
    private final Cave cave;
    private CaveEntrance currentEntrance;

    /**
     * This constructor allows to create the game and instantiate the
     * attributes.
     */
    public Game() {
        explorers = new ArrayList<>();
        cave = new Cave();
    }

    @Override
    public void addExplorer(Explorer explorer) throws GameException {
        if (itIsPossibleToAddExplorer() == false) {
            throw new GameException("L'ajout de nouveau explorateur a atteint"
                    + " sa limite.");
        }
        explorers.add(explorer);
    }

    @Override
    public void moveForward() {
        List<Explorer> explorersExploring = new ArrayList<>();
        explorersExploring = getExploringExplorers();
        currentEntrance = cave.getCurrentEntrance();
        currentEntrance.discoverNewTile(explorersExploring);
        if (currentEntrance.isUnsafe()) {
            for (Explorer explorer : explorersExploring) {
                explorer.runAway();
            }
        }
    }

    @Override
    public boolean isExplorationPhaseOver() {
        boolean isExplorationPhaseOver = true;
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.EXPLORING) {
                isExplorationPhaseOver = false;
            }
        }
        return isExplorationPhaseOver;
    }

    @Override
    public Cave getCave() {
        return cave;
    }

    @Override
    public List<Explorer> getExplorers() {
        return explorers;
    }

    @Override
    public List<Explorer> getExploringExplorers() {
        List<Explorer> explorerExploring = new ArrayList<>();
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.EXPLORING) {
                explorerExploring.add(explorer);
            }
        }
        return explorerExploring;
    }

    @Override
    public void handleExplorerDecisionToLeave(Explorer explorer) throws
            GameException {
        if (!explorers.contains(explorer)) {
            throw new GameException("Le joueur ne fait pas partie "
                    + "de la liste du jeu.");
        }
        explorer.takeDecisionToLeave();
    }

    @Override
    public void start() throws GameException {
        if (isThereEnoughExplorer() == false) {
            throw new GameException("Il faut au minimum 3 explorateurs "
                    + "pour débuter le jeu.");
        }
    }

    @Override
    public boolean isThereEnoughExplorer() {
        boolean enoughExplorer = true;
        if (explorers.size() < 3) {
            enoughExplorer = false;

        }
        return enoughExplorer;
    }

    @Override
    public boolean itIsPossibleToAddExplorer() {
        boolean possibleToAddExplorer = true;
        if (explorers.size() > 7) {
            possibleToAddExplorer = false;
        }
        return possibleToAddExplorer;
    }

    @Override
    public Explorer getWinner() throws GameException {
        if (isExplorationPhaseOver() == false) {
            throw new GameException("La partie n'est pas finie !");
        }

        int maxFortune = 0;
        String pseudonym = "";
        Explorer explorer = new Explorer(pseudonym);
        for (int i = 0; i < explorers.size(); i++) {
            if (maxFortune < explorers.get(i).getFortune()) {
                maxFortune = explorers.get(i).getFortune();
                pseudonym = explorers.get(i).getPseudonym();
                explorer = new Explorer(pseudonym);
            }
        }
        return explorer;
    }

    @Override
    public void makeExplorersLeave() {
        List<Explorer> explorersLeaving = new ArrayList<>();
        currentEntrance.makeLastTileExplored();
        for (Explorer explorer : explorers) {
            if (explorer.getState() == State.LEAVING) {
                explorersLeaving.add(explorer);
            }
        }
        if (!explorersLeaving.isEmpty()) {
            currentEntrance.returnToCamp(explorersLeaving);
            for (Explorer explorer : explorersLeaving) {
                explorer.reachCamp();
            }
        }
    }

    @Override
    public void startNewExplorationPhase() throws GameException {
        if (cave.hasNewEntranceToExplore() == true) {
            cave.openNewEntrance();
            for (Explorer explorer : explorers) {
                explorer.startExploration();
            }
        }
    }

    @Override
    public void endExplorationPhase() throws GameException {
        cave.lockOutCurrentEntrance();
        List<Tile> tiles = currentEntrance.getPath();
        for (Tile tile : tiles) {
            if (tile instanceof Treasure) {
                ((Treasure) tile).restore();
                cave.getDeck().putBack(tile);
            } else if (tile instanceof Hazard) {
                if (!((Hazard) tile).isExplorersEscapeReason()) {
                    cave.getDeck().putBack(tile);
                }
            }
        }
    }

    @Override
    public boolean isOver() {
        boolean isOver = false;
        if (isExplorationPhaseOver()
                && cave.hasNewEntranceToExplore() == false) {
            isOver = true;
        }
        return isOver;
    }

    @Override
    public boolean isExplorationPhaseAborted() {
        boolean isExplorationPhaseAborted = false;
        if (currentEntrance.isUnsafe()) {
            isExplorationPhaseAborted = true;
        }
        return isExplorationPhaseAborted;
    }

    @Override
    public boolean samePseudonym(Explorer explorer) {
//        String pseudonym = "";
//        Explorer explorer = new Explorer(pseudonym);
        boolean isSamePseudonym = true;
//        for (int i = 0; i < this.explorers.size(); i++) {
//            for (int j = 1; j < this.explorers.size(); j++) {
//                if(explorers.get(i).getPseudonym().equals(explorers.get(j).getPseudonym())){
//                    System.out.println("Le nom de votre explorateur a déja été"
//                            + "utilisé, veuillez entrer un autre nom :");
//                    isSamePseudonym = false;
//                }
//            }
//        }
//        return isSamePseudonym;

        for (int i = 0; i < this.explorers.size(); i++) {
            if (explorer.getPseudonym().equals(explorers.get(i).getPseudonym())) {
                System.out.println("Le nom de votre explorateur a déja été "
                        + "utilisé ! Veuillez entrer un autre nom :");
                isSamePseudonym = false;
            }
        }
        return isSamePseudonym;
    }

}
