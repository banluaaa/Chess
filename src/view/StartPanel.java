package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends GamePanel{
    BufferedImage stImage=null;
    int stWidth;
    int stHeight;
    public StartPanel() {
        try {
            stImage = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\ChessDemo(1)\\images\\start.png"));
            stWidth =900;
            stHeight = 700;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(stImage, 50, 10, stWidth, stHeight, null);
    }

    private class buttonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Let's Play")) {
                gameState = GameState.RUNNING;
            }
        }
    }

}
