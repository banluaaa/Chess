package controller;

import view.ChessGameFrame;

import java.util.ArrayList;

public class replace extends Thread{
    public ArrayList<String> arrayList = new ArrayList<>();
    @Override
    public void run() {
        super.run();
        //
        for(int i = 0;i < ChessGameFrame.gameController.getStrings().size();i++){
            arrayList.add(ChessGameFrame.gameController.getStrings().get(i));
        }
        ChessGameFrame.gameController.getStrings().clear();
        //ChessGameFrame.gameController.readDataFromArrayList();
        for (int i = 0;i < arrayList.size();i++){
            try {
                sleep(500);
                ChessGameFrame.gameController.getStrings().add( arrayList.get(i) );
                //ChessGameFrame.gameController.readDataFromArrayList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

