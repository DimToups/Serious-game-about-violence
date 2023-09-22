package fr.tyr.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GraphicEngine graphicEngine){
        super("T3 - Tyr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
