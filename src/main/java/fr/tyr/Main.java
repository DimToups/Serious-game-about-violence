package fr.tyr;

import fr.tyr.game.GameEngine;
import fr.tyr.game.GraphicEngine;
import fr.tyr.game.GameWindow;

public class Main {
    public static void main(String[] args) {
        boolean devMode = false;
        if(args.length > 0)
            devMode = args[0].equals("--dev");
        GameEngine gameEngine = new GameEngine(devMode);
        GraphicEngine graphicEngine = new GraphicEngine(gameEngine);
        GameWindow gameWindow = new GameWindow(graphicEngine);
        gameWindow.add(graphicEngine);
        gameWindow.setVisible(true);
    }
}
