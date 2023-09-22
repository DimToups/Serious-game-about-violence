package fr.tyr;

import fr.tyr.game.GameEngine;
import fr.tyr.game.GameWindow;
import fr.tyr.game.GraphicEngine;
import fr.tyr.tools.LogFormatter;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static Logger logger;

    public static void main(String[] args) {
        boolean devMode = false;
        if(args.length > 0)
            devMode = args[0].equals("--dev");
        setupLogger(devMode);
        logger.info("Creating game engine");
        GameEngine gameEngine = new GameEngine(devMode);
        logger.info("Creating graphic engine");
        GraphicEngine graphicEngine = new GraphicEngine(gameEngine);
        logger.info("Creating game window");
        GameWindow gameWindow = new GameWindow(graphicEngine);
        gameWindow.add(graphicEngine);
        gameWindow.setVisible(true);
        logger.info("Game initialized");
    }

    private static void setupLogger(boolean devMode){
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger = Logger.getLogger(Main.class.getName());
        if(!devMode){
            logger.setUseParentHandlers(false);
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.WARNING);
            consoleHandler.setFormatter(new LogFormatter());
            logger.addHandler(consoleHandler);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
