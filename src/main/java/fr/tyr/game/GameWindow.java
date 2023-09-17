package fr.tyr.game;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {

    public GameWindow(GraphicEngine graphicEngine){
        super("Sorting Challenge");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.addWindowFocusListener( new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                graphicEngine.onFocusLost();
            }
            @Override
            public void windowGainedFocus(WindowEvent e) {
                graphicEngine.onFocusGained();
            }
        });

        this.setVisible(true);
    }

}
