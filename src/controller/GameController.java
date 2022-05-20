package controller;

import model.ChessColor;
import model.ChessComponent;
import view.Chessboard;
import view.GamePanel;
import view.StartPanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Chessboard chessboard;
    private ChessColor currentPlayer;




    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
        this.currentPlayer = ChessColor.WHITE;
    }//初始化棋盘

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    //关于行棋方

    public ArrayList<String> strings = new ArrayList<>();
    public ArrayList<String> getStrings(){
        return strings;
    }



    public List<String> loadGameFromFile(String path) {
        try {
            List<String> chessData = Files.readAllLines(Path.of(path));
            chessboard.loadGame(chessData);
            return chessData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}
