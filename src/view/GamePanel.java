package view;

import model.ChessComponent;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel {
    //新加类，表示各个面板
    BufferedImage bgImage = null;
    int x = 0;
    int y = 0;//画图的起始位置
    int bgWidth;
    int bgHeight;
    GameState gameState = GameState.START;
    private final int CHESS_COUNT = 8;


    public GamePanel() {
        try {
            bgImage = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\ChessDemo(1)\\images\\background.png"));
            bgWidth = 1000;
            bgHeight = 760;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bgImage, x, y, bgWidth, bgHeight, null);
    }
}
