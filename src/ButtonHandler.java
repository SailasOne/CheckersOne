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
                                if ((GridLayoutManager.boardarray[a][b].getCellColor().equals(CellColor.WHITE))&&GridLayoutManager.getPlayer().equals("white")) {
                                    GridLayoutManager.isCheckerChosen(a, b);
                                    GridLayoutManager.setOne(a);
                                    GridLayoutManager.setTwo(b);
                                }
                                else if((GridLayoutManager.boardarray[a][b].getCellColor().equals(CellColor.BLACK))&&GridLayoutManager.getPlayer().equals("black")){
                                    GridLayoutManager.isCheckerChosen(a, b);
                                    GridLayoutManager.setOne(a);
                                    GridLayoutManager.setTwo(b);
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 != 0) {
                             if (source == GridLayoutManager.squares2[i][j] &&
                                    (!(GridLayoutManager.boardarray[i][j].getCellColor()==CellColor.BLACK) && GridLayoutManager.getPlayer().equals("white"))){
                                GridLayoutManager.processClick(i, j, GridLayoutManager.getOne(), GridLayoutManager.getTwo());
                                return;
                            }
                            else if(source == GridLayoutManager.squares2[i][j]&&
                                    (!(GridLayoutManager.boardarray[i][j].getCellColor()==CellColor.WHITE)&&GridLayoutManager.getPlayer().equals("black")) ){

                                    GridLayoutManager.processClick(i, j, GridLayoutManager.getOne(), GridLayoutManager.getTwo());
                                    return;

                            }

                        }
                    }
                }
            } catch (IOException a) {
                a.getStackTrace();
            }
        if(source == Checkers.btn && !GridLayoutManager.getAttackInd()) {
            GridLayoutManager.SwapPlayer();
            Checkers.blackCount=0;
            Checkers.whiteCount=0;
            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if ((a + b) % 2 != 0) {
                        if(GridLayoutManager.boardarray[a][b].getCellColor()==CellColor.BLACK){
                            Checkers.blackCount++;
                        }
                        if(GridLayoutManager.boardarray[a][b].getCellColor()==CellColor.WHITE){
                            Checkers.whiteCount++;
                        }
                        if (GridLayoutManager.boardarray[a][b].getCaptured()){
                            if(GridLayoutManager.boardarray[a][b].getQueen()){GridLayoutManager.boardarray[a][b].setQueen(false);}
                            GridLayoutManager.boardarray[a][b].setCellColor(CellColor.CLEAN);
                            GridLayoutManager.boardarray[a][b].addWay(CellColor.CLEAN);
                            GridLayoutManager.squares2[a][b].setIcon(null);
                            GridLayoutManager.boardarray[a][b].setCaptured(false);
                        }
                        if (GridLayoutManager.boardarray[a][b].getCellBorder()) {
                                GridLayoutManager.boardarray[a][b].setCellBorder(false);
                                GridLayoutManager.boardarray[a][b].addWay(false);
                                GridLayoutManager.squares2[a][b].setBackground(Color.BLACK);
                            }
                        if (GridLayoutManager.squares2[a][b].getBackground().equals(Color.pink) || GridLayoutManager.squares2[a][b].getBackground().equals(Color.blue)){
                            GridLayoutManager.squares2[a][b].setBackground(Color.BLACK);
                        }
                        if(GridLayoutManager.boardarray[a][b].getCellColor()==CellColor.WHITE && a==7){
                            GridLayoutManager.boardarray[a][b].setQueen(true);
                            GridLayoutManager.boardarray[a][b].change(CellColor.WHITE);

                        }
                        if(GridLayoutManager.boardarray[a][b].getCellColor()==CellColor.BLACK && a==0){
                            GridLayoutManager.boardarray[a][b].setQueen(true);
                            GridLayoutManager.boardarray[a][b].change(CellColor.BLACK);
                        }
                    }
                }}

            GridLayoutManager.setCurrent("checkerBlack");
            GridLayoutManager.setOne(7);
            GridLayoutManager.setTwo(1);
            GridLayoutManager.setRow(7);
            GridLayoutManager.setCol(1);
            GridLayoutManager.setAttack(false);
            GridLayoutManager.setAttackInd(false);
            GridLayoutManager.setQueenTurn(false);
            Checkers.first="";
            Checkers.second="";

            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if ((a + b) % 2 != 0) {
                        if (GridLayoutManager.boardarray[a][b].tryCapture()) {
                            GridLayoutManager.setAttack(true);
                            GridLayoutManager.setAttackInd(true);
                        }
                    }
                }
            }
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


