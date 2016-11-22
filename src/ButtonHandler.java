import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

            try {
                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) {
                        if ((a + b) % 2 != 0) {
                            if (source == GridLayoutManager.squares2[a][b]) {
                                if ((GridLayoutManager.boardarray[a][b].color.equals(CellColor.WHITE))&&GridLayoutManager.player.equals("white")) {
                                    GridLayoutManager.isCheckerChosen(a, b);
                                    GridLayoutManager.one = a;
                                    GridLayoutManager.two = b;
                                }
                                else if((GridLayoutManager.boardarray[a][b].color.equals(CellColor.BLACK))&&GridLayoutManager.player.equals("black")){
                                    GridLayoutManager.isCheckerChosen(a, b);
                                    GridLayoutManager.one = a;
                                    GridLayoutManager.two = b;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 != 0) {
                             if (source == GridLayoutManager.squares2[i][j] &&
                                    (!(GridLayoutManager.boardarray[i][j].color==CellColor.BLACK) && GridLayoutManager.player.equals("white"))){
                                GridLayoutManager.processClick(i, j, GridLayoutManager.one, GridLayoutManager.two);
                                return;
                            }
                            else if(source == GridLayoutManager.squares2[i][j]&&
                                    (!(GridLayoutManager.boardarray[i][j].color==CellColor.WHITE)&&GridLayoutManager.player.equals("black")) ){

                                    GridLayoutManager.processClick(i, j, GridLayoutManager.one, GridLayoutManager.two);
                                    return;

                            }

                        }
                    }
                }
            } catch (IOException a) {
                a.getStackTrace();
            }
        if(source == Checkers.btn && !GridLayoutManager.attackInd) {
            GridLayoutManager.SwapPlayer();
            Checkers.blackCount=0;
            Checkers.whiteCount=0;
            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if ((a + b) % 2 != 0) {
                        if(GridLayoutManager.boardarray[a][b].color==CellColor.BLACK){
                            Checkers.blackCount++;
                        }
                        if(GridLayoutManager.boardarray[a][b].color==CellColor.WHITE){
                            Checkers.whiteCount++;
                        }
                        if (GridLayoutManager.boardarray[a][b].captured){
                            if(GridLayoutManager.boardarray[a][b].queen){GridLayoutManager.boardarray[a][b].queen=false;}
                            GridLayoutManager.boardarray[a][b].color=CellColor.CLEAN;
                            GridLayoutManager.boardarray[a][b].addWay(CellColor.CLEAN);
                            GridLayoutManager.squares2[a][b].setIcon(null);
                            GridLayoutManager.boardarray[a][b].captured=false;
                        }
                        if (GridLayoutManager.boardarray[a][b].border) {
                                GridLayoutManager.boardarray[a][b].border=false;
                                GridLayoutManager.boardarray[a][b].addWay(false);
                                GridLayoutManager.squares2[a][b].setBackground(Color.BLACK);
                            }
                        if (GridLayoutManager.squares2[a][b].getBackground().equals(Color.pink) || GridLayoutManager.squares2[a][b].getBackground().equals(Color.blue)){
                            GridLayoutManager.squares2[a][b].setBackground(Color.BLACK);
                        }
                        if(GridLayoutManager.boardarray[a][b].color==CellColor.WHITE && a==7){
                            GridLayoutManager.boardarray[a][b].queen = true;
                            GridLayoutManager.boardarray[a][b].change(CellColor.WHITE);

                        }
                        if(GridLayoutManager.boardarray[a][b].color==CellColor.BLACK && a==0){
                            GridLayoutManager.boardarray[a][b].queen = true;
                            GridLayoutManager.boardarray[a][b].change(CellColor.BLACK);
                        }
                    }
                }}

            GridLayoutManager.current="checkerBlack";
            GridLayoutManager.timeCurrent="";
            GridLayoutManager.one = 7;
            GridLayoutManager.two = 1;
            GridLayoutManager.row = 7;
            GridLayoutManager.col = 1;
            GridLayoutManager.attack=false;
            GridLayoutManager.queenTurn=false;
            Checkers.first="";
            Checkers.second="";

            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if ((a + b) % 2 != 0) {
                        if (GridLayoutManager.boardarray[a][b].tryCapture()) {
                            GridLayoutManager.attack=true;
                            GridLayoutManager.attackInd=true;
                        }
                    }
                }
            }
            /*for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if ((a + b) % 2 != 0) {
                        if(GridLayoutManager.isValidMove(a,b,a+1,b-1,true) || GridLayoutManager.isValidMove(a,b,a+1,b+1,true))
                        {
                            Checkers.first = "first";
                        }
                        if(GridLayoutManager.isValidMove(a,b,a-1,b-1,false) || GridLayoutManager.isValidMove(a,b,a-1,b+1,false)){
                            Checkers.second = "second";
                        }
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if ((i + j) % 2 != 0) {
                                    if(GridLayoutManager.isValidMove(a,b,i,j,true)) {
                                        Checkers.first="first";
                                    }
                                    if(GridLayoutManager.isValidMove(a,b,i,j,false)) {
                                        Checkers.first="second";
                                    }
                                    }
                                }
                                }

                    }
                }
            }*/
            //if(Checkers.first.equals("first") && !Checkers.second.equals("second")){}
            //else if(Checkers.second.equals("second") &&!Checkers.first.equals("first")){}
            //else if(Checkers.first.equals("first") && Checkers.second.equals("second")){}
            if(Checkers.whiteCount==0){
                JFrame w = new JFrame();
                w.setSize(250,250);
                JLabel label = new JLabel("Победа Черных!");
                w.add(label, BorderLayout.NORTH);
                w.setLocationRelativeTo(null);
                w.setVisible(true);
            }
            else if(Checkers.blackCount==0){
                JFrame w = new JFrame();
                w.setSize(250,250);
                JLabel label = new JLabel("Победа Белых!");
                w.add(label, BorderLayout.NORTH);
                w.setLocationRelativeTo(null);
                w.setVisible(true);

            }


            }
            return;
    }
}


