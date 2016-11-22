import javax.swing.*;
import java.awt.*;
import java.io.IOException;

    public class GridLayoutManager extends JFrame
    {
        static Container contents;
        //Components
        public static JButton[][] squares2 = new JButton[8][8];
        //Colors
        static Color colorBlack = Color.BLACK; //Black square
        static int one = 7;
        static int two = 1;
        static int row = 7 ;
        static int col = 1;
        static boolean attackInd = false; //false default
        static boolean attack = false; //false default
        static  String player = "white";
        static String player2 = "black";
        static String timeCurrent = "";
        static String current = "checkerBlack";
        static boolean queenTurn = false;

        public static BoardCell[][] boardarray = new BoardCell[8][8];
        //Current position
        //Upper left corner of board is(0,0).
        public GridLayoutManager()
        {
            super("GUI GridLayout Manager - (click a valid square to move )");
            contents = getContentPane();
            contents.setLayout(new GridLayout(8,8));
            //Create event handlers
            ButtonHandler buttonHandler = new ButtonHandler();


            //Create and add board components
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    squares2[i][j] = new JButton();
                    squares2[i][j].setBorder(BorderFactory.createCompoundBorder());
                    squares2[i][j].setOpaque(true);
                    if ((i + j) % 2 != 0) {
                        squares2[i][j].setBackground(colorBlack);
                    }
                    contents.add(squares2[i][j]);
                    squares2[i][j].addActionListener(buttonHandler);
                }
            }
            boardarray[7][1] = new BoardCell("71",false, CellColor.CLEAN, 7, 1, false, false, false,false,false,false,false,false,false,false,false,false,false);

            boardarray[0][1] = new BoardCell("b8",false, CellColor.WHITE, 0, 1, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[0][3] = new BoardCell("d8",false, CellColor.WHITE, 0, 3, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[0][5] = new BoardCell("f8",false, CellColor.WHITE, 0, 5, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[0][7] = new BoardCell("h8",false, CellColor.WHITE, 0, 7, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[1][0] = new BoardCell("a7",false, CellColor.WHITE, 1, 0, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[1][2] = new BoardCell("c7",false, CellColor.WHITE, 1, 2, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[1][4] = new BoardCell("e7",false, CellColor.WHITE, 1, 4, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[1][6] = new BoardCell("g7",false, CellColor.WHITE, 1, 6, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[2][1] = new BoardCell("b6",false, CellColor.WHITE, 2, 1, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[2][3] = new BoardCell("d6",false, CellColor.WHITE, 2, 3, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[2][5] = new BoardCell("f6",false, CellColor.WHITE, 2, 5, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[2][7] = new BoardCell("h6",false, CellColor.WHITE, 2, 7, false, false, false,false,false,false,false,false,false,false,false,false,false);

            boardarray[3][0] = new BoardCell("a5",false, CellColor.CLEAN, 3, 0, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[3][2] = new BoardCell("c5",false, CellColor.CLEAN, 3, 2, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[3][4] = new BoardCell("e5",false, CellColor.CLEAN, 3, 4, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[3][6] = new BoardCell("g5",false, CellColor.CLEAN, 3, 6, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[4][1] = new BoardCell("b4",false, CellColor.CLEAN, 4, 1, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[4][3] = new BoardCell("d4",false, CellColor.CLEAN, 4, 3, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[4][5] = new BoardCell("f4",false, CellColor.CLEAN, 4, 5, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[4][7] = new BoardCell("h4",false, CellColor.CLEAN, 4, 7, false, false, false,false,false,false,false,false,false,false,false,false,false);

            boardarray[5][0] = new BoardCell("a3",false, CellColor.BLACK, 5, 0, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[5][2] = new BoardCell("c3",false, CellColor.BLACK, 5, 2, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[5][4] = new BoardCell("e3",false, CellColor.BLACK, 5, 4, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[5][6] = new BoardCell("g3",false, CellColor.BLACK, 5, 6, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[6][1] = new BoardCell("b2",false, CellColor.BLACK, 6, 1, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[6][3] = new BoardCell("d2",false, CellColor.BLACK, 6, 3, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[6][5] = new BoardCell("f2",false, CellColor.BLACK, 6, 5, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[6][7] = new BoardCell("h2",false, CellColor.BLACK, 6, 7, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[7][0] = new BoardCell("a1",false, CellColor.BLACK, 7, 0, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[7][2] = new BoardCell("c1",false, CellColor.BLACK, 7, 2, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[7][4] = new BoardCell("e1",false, CellColor.BLACK, 7, 4, false, false, false,false,false,false,false,false,false,false,false,false,false);
            boardarray[7][6] = new BoardCell("g1",false, CellColor.BLACK, 7, 6, false, false, false,false,false,false,false,false,false,false,false,false,false);
        }
        static String SwapPlayer(){
            String one,two;

            one = player;
            two = player2;
            player = two;
            player2 = one;
            return player;
        }

    static boolean isValidMove(int i, int j, int g, int h, boolean t) {
        int rowDelta;
        int colDelta;
        if (!t) {
            if(boardarray[g][h].queen){
                if(boardarray[g][h].walkingQueen(i,j)){return true;}
            }
            else {
                rowDelta = Math.abs(g - i);
                colDelta = Math.abs(h - j);
                if ((rowDelta == 1) && (colDelta == 1) || (i == g && j == h)) {
                    if (i < g) {
                        return true;
                    }
                }
            }
        } else if (t) {
            if(boardarray[g][h].queen){
                if(boardarray[g][h].walkingQueen(i,j)){return true;}
            }
            else {
                rowDelta = Math.abs(i - g);
                colDelta = Math.abs(j - h);
                if ((colDelta == 1) && (rowDelta == 1) || (i == g && j == h)) {
                    if (i > g) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean isCheckerChosen(int i, int j) {
        if (boardarray[i][j].color == CellColor.WHITE) {
            if (timeCurrent.equals("checkerWhite")) {
                if(queenTurn){
                    boardarray[one][two].queen=true;
                    boardarray[row][col].queen=false;
                    queenTurn=false;
                    boardarray[one][two].change(CellColor.WHITE);
                    boardarray[row][col].change(CellColor.CLEAN);
                    squares2[one][two].setBackground(colorBlack);
                }
                    else{
                boardarray[one][two].change(CellColor.WHITE);
                boardarray[row][col].change(CellColor.CLEAN);
                squares2[one][two].setBackground(colorBlack);}
            }
        } else if (boardarray[i][j].color == CellColor.BLACK) {
            if (timeCurrent.equals("checkerBlack")) {
                if(queenTurn){
                    boardarray[one][two].queen=true;
                    boardarray[row][col].queen=false;
                    queenTurn=false;
                    boardarray[one][two].change(CellColor.BLACK);
                    boardarray[row][col].change(CellColor.CLEAN);
                    squares2[one][two].setBackground(colorBlack);
                }
                else{
                boardarray[one][two].change(CellColor.BLACK);
                boardarray[row][col].change(CellColor.CLEAN);
                squares2[one][two].setBackground(colorBlack);}
            }
        }
        boardarray[i][j].choseChecker(true);
        if (boardarray[i][j].color == CellColor.WHITE ) {
            current = "checkerWhite";
            return true;
        }
        if (current.equals("checkerWhite")) {
            return true;
        } else {
            current = "checkerBlack";
            return false;
        }
    }


    static void processClick(int i, int j, int g, int h) throws IOException {
        if (boardarray[g][h].border && boardarray[i][j].color == CellColor.WHITE && !attack ||
                squares2[i][j].getBackground().equals(Color.cyan) && timeCurrent.equals("checkerWhite") && !attack) {
            if(queenTurn){
                boardarray[g][h].queen=true;
                boardarray[row][col].queen=false;
                queenTurn=false;
                boardarray[g][h].change(CellColor.WHITE);
                squares2[g][h].setBackground(colorBlack);
                boardarray[row][col].change(CellColor.CLEAN);
                boardarray[row][col].choseChecker(false);
                boardarray[i][j].choseChecker(true);
            }
            else{
            boardarray[g][h].change(CellColor.WHITE);
            squares2[g][h].setBackground(colorBlack);
            boardarray[row][col].change(CellColor.CLEAN);
            boardarray[row][col].choseChecker(false);
            boardarray[i][j].choseChecker(true);}
        } else if (boardarray[g][h].border && boardarray[i][j].color == CellColor.BLACK && !attack ||
                squares2[i][j].getBackground().equals(Color.cyan)&& timeCurrent.equals("checkerBlack") && !attack) {
            if(queenTurn){
                boardarray[g][h].queen=true;
                boardarray[row][col].queen=false;
                queenTurn=false;
                boardarray[g][h].change(CellColor.BLACK);
                squares2[g][h].setBackground(colorBlack);
                boardarray[row][col].change(CellColor.CLEAN);
                boardarray[row][col].choseChecker(false);
                boardarray[i][j].choseChecker(true);
            }
            else{
            boardarray[g][h].change(CellColor.BLACK);
            squares2[g][h].setBackground(colorBlack);
            boardarray[row][col].change(CellColor.CLEAN);
            boardarray[row][col].choseChecker(false);
            boardarray[i][j].choseChecker(true);}
        }
        else if (isCheckerChosen(g, h)) {

                if(attackInd && player.equals("white") || attack && player.equals("white")) {
                    if(boardarray[g][h].queen) {
                        if (!boardarray[g][h].Capture(i, j)) {
                            return;
                        }
                        boardarray[g][h].queen = false;
                        boardarray[g][h].change(CellColor.CLEAN);
                        boardarray[row][col].queen = false;
                        boardarray[row][col].change(CellColor.CLEAN);
                        boardarray[row][col].choseChecker(false);

                        attackInd = false;
                        boardarray[i][j].queen = true;
                        boardarray[i][j].change(CellColor.WHITE);
                        boardarray[i][j].choseChecker(true);
                        row = i;
                        col = j;
                    }
                    if (!boardarray[g][h].Capture(i, j)) {
                        return;
                    }
                    boardarray[g][h].change(CellColor.CLEAN);
                    boardarray[row][col].change(CellColor.CLEAN);
                    boardarray[row][col].choseChecker(false);
                    BoardArray.DeleteCaptured(i,j,g,h);
                    attackInd=false;
                    if(boardarray[i][j].color==CellColor.CLEAN && i==7){
                        boardarray[i][j].queen=true;
                    }
                    boardarray[i][j].change(CellColor.WHITE);
                    boardarray[i][j].choseChecker(true);
                    row = i;
                    col = j;
        }
            if(boardarray[i][j].color==CellColor.CLEAN && boardarray[g][h].color==CellColor.CLEAN && boardarray[g][h].border){return;}
            else{
                if (!isValidMove(i, j, g, h, true)) {
                    return;
                }
                timeCurrent = "checkerWhite";
                boardarray[g][h].change(CellColor.CLEAN);
                boardarray[row][col].change(CellColor.CLEAN);
                boardarray[row][col].choseChecker(false);
            boardarray[i][j].change(CellColor.WHITE);
            boardarray[i][j].choseChecker(true);
            row = i;
            col = j;}
        } else if (!isCheckerChosen(g, h)) {
            if(attackInd && player.equals("black") || attack && player.equals("black")) {
                if(boardarray[g][h].queen) {
                    if (!boardarray[g][h].Capture(i, j)) {
                        return;
                    }
                    boardarray[g][h].queen = false;
                    boardarray[g][h].change(CellColor.CLEAN);
                    boardarray[row][col].queen = false;
                    boardarray[row][col].change(CellColor.CLEAN);
                    boardarray[row][col].choseChecker(false);

                    attackInd = false;
                    boardarray[i][j].queen = true;
                    boardarray[i][j].change(CellColor.BLACK);
                    boardarray[i][j].choseChecker(true);
                    row = i;
                    col = j;
                }
                if (!boardarray[g][h].Capture(i, j)) {
                    return;
                }
                boardarray[g][h].change(CellColor.CLEAN);
                boardarray[row][col].change(CellColor.CLEAN);
                boardarray[row][col].choseChecker(false);
                BoardArray.DeleteCaptured(i,j,g,h);
                attackInd=false;
                if(boardarray[i][j].color==CellColor.CLEAN && i==0){
                    boardarray[i][j].queen=true;
                }
                boardarray[i][j].change(CellColor.BLACK);
                boardarray[i][j].choseChecker(true);
                row = i;
                col = j;
        }
            if(boardarray[i][j].color==CellColor.CLEAN && boardarray[g][h].color==CellColor.CLEAN && boardarray[g][h].border){return;}
            else{
                if (!isValidMove(i, j, g, h, false)) {
                    return;
                }
                timeCurrent = "checkerBlack";
                boardarray[g][h].change(CellColor.CLEAN);
                boardarray[row][col].change(CellColor.CLEAN);
                boardarray[row][col].choseChecker(false);
                boardarray[i][j].change(CellColor.BLACK);
                boardarray[i][j].choseChecker(true);
                row = i;
                col = j;
            }
        }
       else return;
    }
}
