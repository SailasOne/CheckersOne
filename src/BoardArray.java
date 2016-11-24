

import javax.swing.*;

public class BoardArray extends JFrame
{
    public static BoardCell[] EightWay = new BoardCell[8]; // a1, b2, c3, d4, e5, f6, g7, h8

    public static BoardCell[] SevenWayG1A7 = new BoardCell[7]; // g1, f2, e3, d4, c5, b6, a7
    public static BoardCell[] SevenWayH2B8 = new BoardCell[7]; // h2, g3, f4, e5, d6, c7, b8

    public static BoardCell[] SixWayC1H6 = new BoardCell[6]; // c1, d2, e3, f4, g5, h6
    public static BoardCell[] SixWayA3F8 = new BoardCell[6]; // a3, b4, c5, d6, e7, f8
    public static BoardCell[] ThreeWayC1A3 = new BoardCell[3]; // c1, b2, a3
    public static BoardCell[] ThreeWayH6F8 = new BoardCell[3]; // h6, g7, f8

    public static BoardCell[] FiveWayH4D8 = new BoardCell[5]; // h4, g5, f6, e7, d8
    public static BoardCell[] FiveWayE1A5 = new BoardCell[5]; // e1, d2, c3, b4, a5
    public static BoardCell[] FourWayA5D8 = new BoardCell[4]; // a5, b6, c7, d8
    public static BoardCell[] FourWayE1H4 = new BoardCell[4]; // e1, f2, g3, h4

    public BoardArray() {
        /*EightWay[0][7] = new BoardCell("h8", CellColor.WHITE, 0, 7, false,false,    true,false,false,false,false,false,false,false,false,false,false);
        EightWay[1][6] = new BoardCell("g7", CellColor.WHITE, 1, 6, false,false,    true,false,false,false,false,false,true,false,false,false,false);
        EightWay[2][5] = new BoardCell("f6", CellColor.WHITE, 2, 5, false,false,    true,false,false,false,false,false,false,true,false,false,false);
        EightWay[3][4] = new BoardCell("e5", CellColor.CLEAN, 3, 4, false,false,    true,false,true,false,false,false,false,false,false,false,false);
        EightWay[4][3] = new BoardCell("d4", CellColor.CLEAN, 4, 3, false,false,    true,true,false,false,false,false,false,false,false,false,false);
        EightWay[5][2] = new BoardCell("c3", CellColor.BLACK, 5, 2, false,false,    true,false,false,false,false,false,false,false,true,false,false);
        EightWay[6][1] = new BoardCell("b2", CellColor.BLACK, 6, 1, false,false,    true,false,false,false,false,true,false,false,false,false,false);
        EightWay[7][0] = new BoardCell("a1", CellColor.BLACK, 7, 0, false,false,    true,false,false,false,false,false,false,false,false,false,false);*/
        // a1, b2, c3, d4, e5, f6, g7, h8
        for (int i = 7,j=0,a=0; i>=0&&j<=7;i--,j++,a++) {
            GridLayoutManager.boardarray[i][j].eightWay=true;
            EightWay[a] = GridLayoutManager.boardarray[i][j];
        }
        /*SevenWayG1A7[7][6] = new BoardCell("g1", CellColor.BLACK, 7, 6, false,false,    false,true,false,false,false,false,false,false,false,false,false);
        SevenWayG1A7[6][5] = new BoardCell("f2", CellColor.BLACK, 6, 5, false,false,    false,true,false,false,false,false,false,false,false,false,true);
        SevenWayG1A7[5][4] = new BoardCell("e3", CellColor.BLACK, 5, 4, false,false,    false,true,false,true,false,false,false,false,false,false,false);
        SevenWayG1A7[4][3] = new BoardCell("d4", CellColor.CLEAN, 4, 3, false,false,    true,true,false,false,false,false,false,false,false,false,false);
        SevenWayG1A7[3][2] = new BoardCell("c5", CellColor.CLEAN, 3, 2, false,false,    false,true,false,false,false,false,false,false,false,false,false);
        SevenWayG1A7[2][1] = new BoardCell("b6", CellColor.WHITE, 2, 1, false,false,    false,true,false,false,false,false,false,false,false,false,false);
        SevenWayG1A7[1][0] = new BoardCell("a7", CellColor.WHITE, 1, 0, false,false,    false,true,false,false,false,false,false,false,false,false,false);*/
        // g1, f2, e3, d4, c5, b6, a7
        for(int i=7,j=6,a=0;i>=1&&j>=0;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].sevenWayG1A7=true;
            SevenWayG1A7[a]=GridLayoutManager.boardarray[i][j];
        }
        /*SevenWayH2B8[6][7] = new BoardCell("h2", CellColor.BLACK, 6, 7, false,false,    false,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[5][6] = new BoardCell("g3", CellColor.BLACK, 5, 6, false,false,    false,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[4][5] = new BoardCell("f4", CellColor.CLEAN, 4, 5, false,false,    false,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[3][4] = new BoardCell("e5", CellColor.CLEAN, 3, 4, false,false,    true,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[2][3] = new BoardCell("d6", CellColor.WHITE, 2, 3, false,false,    false,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[1][4] = new BoardCell("c7", CellColor.WHITE, 1, 4, false,false,    false,false,true,false,false,false,false,false,false,false,false);
        SevenWayH2B8[0][1] = new BoardCell("b8", CellColor.WHITE, 0, 1, false,false,    false,false,true,false,false,false,false,false,false,false,false);*/
        // h2, g3, f4, e5, d6, c7, b8
        for (int i=6,j=7,a=0;i>=0&&j>=1;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].sevenWayH2B8=true;
            SevenWayH2B8[a]=GridLayoutManager.boardarray[i][j];
        }
        /*SixWayC1H6[7][2] = new BoardCell("c1", CellColor.BLACK, 7, 2, false,false,  false,false,false,true,false,false,false,false,false,false,false);
        SixWayC1H6[6][3] = new BoardCell("d2", CellColor.BLACK, 6, 3, false,false,  false,false,false,true,false,false,false,false,false,false,false);
        SixWayC1H6[5][4] = new BoardCell("e3", CellColor.BLACK, 5, 4, false,false,  false,true,false,true,false,false,false,false,false,false,false);
        SixWayC1H6[4][5] = new BoardCell("f4", CellColor.CLEAN, 4, 5, false,false,  false,false,false,true,false,false,false,false,false,false,false);
        SixWayC1H6[3][6] = new BoardCell("g5", CellColor.CLEAN, 3, 6, false,false,  false,false,false,true,false,false,false,false,false,false,false);
        SixWayC1H6[2][7] = new BoardCell("h6", CellColor.WHITE, 2, 7, false,false,  false,false,false,true,false,false,false,false,false,false,false);*/
        // c1, d2, e3, f4, g5, h6
        for(int i=7,j=2,a=0;i>=2&&j<=7;i--,j++,a++){
            GridLayoutManager.boardarray[i][j].sixWayC1H6=true;
            SixWayC1H6[a]=GridLayoutManager.boardarray[i][j];
        }
        /*SixWayA3F8[5][0] = new BoardCell("a3", CellColor.BLACK, 5, 0, false,false,  false,false,false,false,true,false,false,false,false,false,false);
        SixWayA3F8[4][1] = new BoardCell("b4", CellColor.CLEAN, 4, 1, false,false,  false,false,false,false,true,false,false,false,false,false,false);
        SixWayA3F8[3][2] = new BoardCell("c5", CellColor.CLEAN, 3, 2, false,false,  false,false,false,false,true,false,false,false,false,false,false);
        SixWayA3F8[2][3] = new BoardCell("d6", CellColor.WHITE, 2, 3, false,false,  false,false,false,false,true,false,false,false,false,false,false);
        SixWayA3F8[1][2] = new BoardCell("e7", CellColor.WHITE, 1, 2, false,false,  false,false,false,false,true,false,false,false,false,false,false);
        SixWayA3F8[0][5] = new BoardCell("f8", CellColor.WHITE, 0, 5, false,false,  false,false,false,false,true,false,false,false,false,false,false);*/
        // a3, b4, c5, d6, e7, f8
        for (int i=5,j=0,a=0;i>=0&&j<=5;i--,j++,a++){
            GridLayoutManager.boardarray[i][j].sixWayA3F8=true;
            SixWayA3F8[a]=GridLayoutManager.boardarray[i][j];
        }
        /*ThreeWayC1A3[7][2] = new BoardCell("c1", CellColor.BLACK, 7, 2, false,false,    false,false,false,false,false,true,false,false,false,false,false);
        ThreeWayC1A3[6][1] = new BoardCell("b2", CellColor.BLACK, 6, 1, false,false,    true,false,false,false,false,true,false,false,false,false,false);
        ThreeWayC1A3[5][0] = new BoardCell("a3", CellColor.BLACK, 5, 0, false,false,    false,false,false,false,false,true,false,false,false,false,false);*/
        // c1, b2, a3
        for(int i=7,j=2,a=0;i>=5&&j>=0;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].threeWayC1A3=true;
            ThreeWayC1A3[a]=GridLayoutManager.boardarray[i][j];
        }
        /*ThreeWayH6F8[2][7] = new BoardCell("h6", CellColor.WHITE, 2, 7, false,false,    false,false,false,false,false,false,true,false,false,false,false);
        ThreeWayH6F8[1][6] = new BoardCell("g7", CellColor.WHITE, 1, 6, false,false,    true,false,false,false,false,false,true,false,false,false,false);
        ThreeWayH6F8[0][5] = new BoardCell("f8", CellColor.WHITE, 0, 5, false,false,    false,false,false,false,false,false,true,false,false,false,false);*/
        // h6, g7, f8
        for (int i=2,j=7,a=0;i>=0&&j>=5;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].threeWayH6F8=true;
            ThreeWayH6F8[a]=GridLayoutManager.boardarray[i][j];
        }
        /*FiveWayH4D8[4][7] = new BoardCell("h4", CellColor.CLEAN, 4, 7, false,false, false,false,false,false,false,false,false,true,false,false,false);
        FiveWayH4D8[3][6] = new BoardCell("g5", CellColor.CLEAN, 3, 6, false,false, false,false,false,false,false,false,false,true,false,false,false);
        FiveWayH4D8[2][5] = new BoardCell("f6", CellColor.WHITE, 2, 5, false,false, false,false,false,false,false,false,false,true,false,false,false);
        FiveWayH4D8[1][2] = new BoardCell("e7", CellColor.WHITE, 1, 2, false,false, false,false,false,false,false,false,false,true,false,false,false);
        FiveWayH4D8[0][3] = new BoardCell("d8", CellColor.WHITE, 0, 3, false,false, false,false,false,false,false,false,false,true,false,false,false);*/
        // h4, g5, f6, e7, d8
        for (int i=4,j=7,a=0; i>=0&&j>=3;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].fiveWayH4D8=true;
            FiveWayH4D8[a]=GridLayoutManager.boardarray[i][j];
        }
        /*FiveWayE1A5[7][4] = new BoardCell("e1", CellColor.BLACK, 7, 4, false,false, false,false,false,false,false,false,false,false,true,false,false);
        FiveWayE1A5[6][3] = new BoardCell("d2", CellColor.BLACK, 6, 3, false,false, false,false,false,false,false,false,false,false,true,false,false);
        FiveWayE1A5[5][2] = new BoardCell("c3", CellColor.BLACK, 5, 2, true,false, false,false,false,false,false,false,false,false,true,false,false);
        FiveWayE1A5[4][1] = new BoardCell("b4", CellColor.CLEAN, 4, 1, false,false, false,false,false,false,false,false,false,false,true,false,false);
        FiveWayE1A5[3][0] = new BoardCell("a5", CellColor.CLEAN, 3, 0, false,false, false,false,false,false,false,false,false,false,true,false,false);*/
        // e1, d2, c3, b4, a5
        for (int i=7,j=4,a=0; i>=3&&j>=0;i--,j--,a++){
            GridLayoutManager.boardarray[i][j].fiveWayE1A5=true;
            FiveWayE1A5[a]=GridLayoutManager.boardarray[i][j];
        }
        /*FourWayA5D8[3][0] = new BoardCell("a5", CellColor.CLEAN, 3, 0, false,false, false,false,false,false,false,false,false,false,false,true,false);
        FourWayA5D8[2][1] = new BoardCell("b6", CellColor.WHITE, 2, 1, false,false, false,false,false,false,false,false,false,false,false,true,false);
        FourWayA5D8[1][4] = new BoardCell("c7", CellColor.WHITE, 1, 4, false,false, false,false,false,false,false,false,false,false,false,true,false);
        FourWayA5D8[0][3] = new BoardCell("d8", CellColor.WHITE, 0, 3, false,false, false,false,false,false,false,false,false,false,false,true,false);*/
        // a5, b6, c7, d8
        for (int i=3,j=0,a=0;i>=0&&j<=3;i--,j++,a++){
            GridLayoutManager.boardarray[i][j].fourWayA5D8=true;
            FourWayA5D8[a]=GridLayoutManager.boardarray[i][j];
        }
        /*FourWayE1H4[7][4] = new BoardCell("e1", CellColor.BLACK, 7, 4, false,false, false,false,false,false,false,false,false,false,false,false,true);
        FourWayE1H4[6][5] = new BoardCell("f2", CellColor.BLACK, 6, 5, false,false, false,true,false,false,false,false,false,false,false,false,true);
        FourWayE1H4[5][6] = new BoardCell("g3", CellColor.BLACK, 5, 6, false,false, false,false,false,false,false,false,false,false,false,false,true);
        FourWayE1H4[4][7] = new BoardCell("h4", CellColor.CLEAN, 4, 7, false,false, false,false,false,false,false,false,false,false,false,false,true);*/
        // e1, f2, g3, h4
        for (int i=7,j=4,a=0;i>=4&&j<=7;i--,j++,a++){
            GridLayoutManager.boardarray[i][j].fourWayE1H4=true;
            FourWayE1H4[a]=GridLayoutManager.boardarray[i][j];
        }




        // g1, f2, e3, d4, c5, b6, a7

        // h2, g3, f4, e5, d6, c7, b8

        // c1, d2, e3, f4, g5, h6

        // a3, b4, c5, d6, e7, f8

        // c1, b2, a3

        // h6, g7, f8

        // h4, g5, f6, e7, d8

        // e1, d2, c3, b4, a5

        // a5, b6, c7, d8

        // e1, f2, g3, h4

    }
    public static void DeleteCaptured(int i, int j, int g, int h){
        if(g<i && h>j){
        GridLayoutManager.boardarray[g+1][h-1].captured=true;
        }
        else if(g<i && h<j){
            GridLayoutManager.boardarray[g+1][h+1].captured=true;
        }
        else if(g>i && h<j){
            GridLayoutManager.boardarray[g-1][h+1].captured=true;
        }
        else if(g>i && h>j){
            GridLayoutManager.boardarray[g-1][h-1].captured=true;
        }
    }
}
