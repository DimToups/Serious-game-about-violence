package fr.tyr.game;

import fr.tyr.resources.images.Images;

import javax.swing.*;

public class GameWindow extends JFrame {

    /**
     * Create the game window
     */
    public GameWindow(GraphicEngine graphicEngine){
        super("T3 - Tyr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Images.LOGO.getCopy());
        setVisible(true);

//        addWindowFocusListener(new WindowFocusListener() {
//            @Override
//            public void windowGainedFocus(WindowEvent e) {
//                Main.getLogger().info("Window gained focus");
//                graphicEngine.getFpsRunner().setAps(60);
//                graphicEngine.getTpsRunner().setAps(60);
//            }
//
//            @Override
//            public void windowLostFocus(WindowEvent e) {
//                Main.getLogger().info("Window lost focus");
//                graphicEngine.getFpsRunner().setAps(5);
//                graphicEngine.getTpsRunner().setAps(5);
//            }
//        });
    }
}
