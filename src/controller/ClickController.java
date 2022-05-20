package controller;


import model.ChessComponent;
import view.Chessboard;

import static model.ChessComponent.rounds;

public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;
    public ChessComponent other;
    public static boolean paw = false;
    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(ChessComponent chessComponent) {
        if (first == null) {
            if (handleFirst(chessComponent)) {
                chessComponent.setSelected(true);
                first = chessComponent;
                first.repaint();
            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取
                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                //repaint in swap chess method.
                chessboard.swapChessComponents(first, chessComponent);
                chessboard.swapColor();

                first.setSelected(false);
                first = null;
            }
        }
    }

    public void Enter(ChessComponent chessComponent){
        chessComponent.setEntered(true);
        other = chessComponent;
        other.repaint();
    }


    public void Exited(ChessComponent chessComponent){
        chessComponent.setEntered(false);
        other = chessComponent;
        other.repaint();
    }//设置鼠标滑过显示

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        if (chessComponent.getChessColor() == chessboard.getCurrentColor()) {
        }//这是在干什么？
        return chessComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {
        if (chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint())) {
            rounds = rounds + 0.5;
        }
        return chessComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }
}
