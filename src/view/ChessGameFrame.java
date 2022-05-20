package view;

import controller.GameController;
import model.ChessColor;
import model.ChessComponent;
import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;
    public final int CHESSBOARD_SIZE ;
    public static GameController gameController;
    private Chessboard chessboard;

    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了

       GamePanel gamePanel = new GamePanel();

        addChessboard();
        //显示轮次
        JLabel turnLabel = new JLabel();
        turnLabel.setText(gameController.getCurrentPlayer().name()+"'s Turn");
        turnLabel.setLocation(HEIGTH, HEIGTH / 10);
        turnLabel.setSize(200, 30);
        turnLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(turnLabel);

        addLoadButton();
        addSaveButton();
        //重开(做不出来）呜呜
        JButton restart = new JButton("Restart");
        restart.setLocation(HEIGTH, HEIGTH / 10 + 60);
        restart.setSize(200, 60);
        restart.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(restart);
        restart.addActionListener(e -> {
            System.out.println("click restart Btn");
            remove(this.chessboard);
            repaint();

            this.chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
            gameController = new GameController(chessboard);
            chessboard.setLocation(HEIGTH/10 , HEIGTH/10 );
            add(chessboard);
        });

        addAppearanceButton();
        addRetractButton();
        addReviewButton();
        super.add(gamePanel);
        //加入背景图片
        super.setVisible(true);
        setLayout(null);
        //addHello();
    }


    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
    chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
    gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGTH/10 , HEIGTH/10 );
    add(chessboard);
    }




    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    /**private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }*/

    private void addLoadButton() {//存档
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 180);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this,"Input Path here");
            gameController.loadGameFromFile(path);
        });
    }

    //private void addRestartButton(){//重开（未完成）

    //}

    private void addSaveButton(){//读档(未完成）
        JButton button = new JButton("Save");
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);


    }



    private void addAppearanceButton(){//外观（未完成）
        JButton button = new JButton("Appearance");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

    }

    private void addRetractButton(){//悔棋（未完成）
        JButton button = new JButton("Retract");
        button.setLocation(HEIGTH, HEIGTH / 10 + 300);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);


    }

    private void addReviewButton(){//复盘（未完成）
        JButton button = new JButton("Review");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

   /** private void addStartButton(){//点击开始游戏
        JButton button = new JButton("Let's Play!");
        button.setLocation(HEIGTH/10+600, HEIGTH / 10 + 10);
        button.setSize(300, 80);
        button.setFont(new Font("Rockwell", Font.BOLD, 30));
        button.addActionListener(e -> {
            System.out.println("click restart Btn");
        });

        add(button);
    }*/
}
