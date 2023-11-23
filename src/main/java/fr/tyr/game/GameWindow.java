package fr.tyr.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    /**
     * Create the game window
     */
    public GameWindow(){
        super("T3 - Tyr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
