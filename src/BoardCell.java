
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.nio.file.Paths;


public class BoardCell extends JButton implements Movable,Capturable {
    private String name;
    private int x;
    private int y;
    private CellColor color;
    private boolean queen;
    private boolean border;
    private boolean captured;

    private boolean eightWay;  // a1, b2, c3, d4, e5, f6, g7, h8

    private boolean sevenWayG1A7; // g1, f2, e3, d4, c5, b6, a7
    private boolean sevenWayH2B8; // h2, g3, f4, e5, d6, c7, b8

    private boolean sixWayC1H6; // c1, d2, e3, f4, g5, h6
    private boolean sixWayA3F8; // a3, b4, c5, d6, e7, f8
    private boolean threeWayC1A3; // c1, b2, a3
    private boolean threeWayH6F8; // h6, g7, f8

    private boolean fiveWayH4D8; // h4, g5, f6, e7, d8
    private boolean fiveWayE1A5; // e1, d2, c3, b4, a5
    private boolean fourWayA5D8; // a5, b6, c7, d8
    private boolean fourWayE1H4; // e1, f2, g3, h4

    private static final String LOCAL_DIR = Paths.get(".").toAbsolutePath().normalize().toString();

    private static ImageIcon resizeIcon(String ImgPath){
        return new ImageIcon(new ImageIcon(ImgPath).getImage().getScaledInstance(75,75,java.awt.Image.SCALE_SMOOTH));
    }

    private static ImageIcon checkerBlack = resizeIcon(LOCAL_DIR + "/checkerblack.png");
    private static ImageIcon checkerWhite = resizeIcon(LOCAL_DIR + "/checkerwhite.png");

    private static ImageIcon queenWhite = resizeIcon(LOCAL_DIR + "/queenAlienWhite2.png");
    private static ImageIcon queenBlack = resizeIcon(LOCAL_DIR + "/queenAlienBlack.png");

    BoardCell(String name,boolean captured, CellColor color, int x, int y, boolean queen, boolean border, boolean eightWay, boolean sevenWayG1A7, boolean sevenWayH2B8,
                     boolean sixWayC1H6, boolean sixWayA3F8, boolean threeWayC1A3, boolean threeWayH6F8, boolean fiveWayH4D8, boolean fiveWayE1A5, boolean fourWayA5D8,
                    boolean fourWayE1H4){
        this.name = name;
        this.captured=captured;
        this.color = color;
        this.x = x;
        this.y = y;
        this.queen = queen;
        this.border = border;
        this.eightWay = eightWay;
        this.sevenWayG1A7 = sevenWayG1A7;
        this.sevenWayH2B8 = sevenWayH2B8;
        this.sixWayC1H6 = sixWayC1H6;
        this.sixWayA3F8 = sixWayA3F8;
        this.threeWayC1A3 = threeWayC1A3;
        this.threeWayH6F8 = threeWayH6F8;
        this.fiveWayH4D8 = fiveWayH4D8;
        this.fiveWayE1A5 = fiveWayE1A5;
        this.fourWayA5D8 = fourWayA5D8;
        this.fourWayE1H4 = fourWayE1H4;
        addIcon(this.x,this.y, this.color, this.queen);
    }

    void setEightWay(boolean eightWay) {
        this.eightWay = eightWay;
    }

    void setSevenWayG1A7(boolean sevenWayG1A7) {
        this.sevenWayG1A7 = sevenWayG1A7;
    }

    void setSevenWayH2B8(boolean sevenWayH2B8) {
        this.sevenWayH2B8 = sevenWayH2B8;
    }

    void setSixWayC1H6(boolean sixWayC1H6) {
        this.sixWayC1H6 = sixWayC1H6;
    }

    void setSixWayA3F8(boolean sixWayA3F8) {
        this.sixWayA3F8 = sixWayA3F8;
    }

    void setThreeWayC1A3(boolean threeWayC1A3) {
        this.threeWayC1A3 = threeWayC1A3;
    }

    void setThreeWayH6F8(boolean threeWayH6F8) {
        this.threeWayH6F8 = threeWayH6F8;
    }

    void setFiveWayH4D8(boolean fiveWayH4D8) {
        this.fiveWayH4D8 = fiveWayH4D8;
    }

    void setFiveWayE1A5(boolean fiveWayE1A5) {
        this.fiveWayE1A5 = fiveWayE1A5;
    }

    void setFourWayA5D8(boolean fourWayA5D8) {
        this.fourWayA5D8 = fourWayA5D8;
    }

    void setFourWayE1H4(boolean fourWayE1H4) {
        this.fourWayE1H4 = fourWayE1H4;
    }

    boolean getCaptured(){
        return this.captured;
    }
    void setCaptured(boolean captured){
        this.captured=captured;
    }
    boolean getCellBorder(){
        return this.border;
    }
    void setCellBorder(boolean border){
        this.border=border;
    }
    CellColor getCellColor(){
        return this.color;
    }
    void setCellColor(CellColor color){
        this.color=color;
    }
    boolean getQueen() {
        return this.queen;
    }
    void setQueen (boolean queen){
        this.queen=queen;
    }

    boolean walkingQueen(int a, int b){
            if (this.eightWay) {
                if (this.walkingQueenInner(BoardArray.getEightWay(), a, b)) {
                return true;
                }
            }
            if (this.sevenWayG1A7) {
                if (this.walkingQueenInner(BoardArray.getSevenWayG1A7(), a, b)) {
                    return true;
                }
            }
            if (this.sevenWayH2B8) {
                if (this.walkingQueenInner(BoardArray.getSevenWayH2B8(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayC1H6) {
                if (this.walkingQueenInner(BoardArray.getSixWayC1H6(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayA3F8) {
                if (this.walkingQueenInner(BoardArray.getSixWayA3F8(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayC1A3) {
                if (this.walkingQueenInner(BoardArray.getThreeWayC1A3(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayH6F8) {
                if (this.walkingQueenInner(BoardArray.getThreeWayH6F8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayH4D8) {
                if (this.walkingQueenInner(BoardArray.getFiveWayH4D8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayE1A5) {
                if (this.walkingQueenInner(BoardArray.getFiveWayE1A5(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayA5D8) {
                if (this.walkingQueenInner(BoardArray.getFourWayA5D8(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayE1H4) {
                if (this.walkingQueenInner(BoardArray.getFourWayE1H4(), a, b)) {
                    return true;
                }
            }
        return false;
    }

    boolean walkingQueenInner(BoardCell[] Way, int a, int b){
        int n=0;
        for(int i=0; i<Way.length;i++) {
            if (this == Way[i]) {

                if (this.color == CellColor.WHITE || this.color == CellColor.BLACK) {
                    if (i < Way.length - 1 && Way[n = i + 1].color == CellColor.CLEAN ) {
                        while (n < Way.length && Way[n].color == CellColor.CLEAN) {
                            if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                GridLayoutManager.boardarray[a][b].queen=true;
                                GridLayoutManager.setQueenTurn(true);
                                this.queen=false;
                                return true;
                            }
                            n++;
                        }
                    }
                    if (i>0 && Way[n = i - 1].color == CellColor.CLEAN) {
                        while (n >= 0 && Way[n].color == CellColor.CLEAN) {
                            if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                GridLayoutManager.boardarray[a][b].queen=true;
                                GridLayoutManager.setQueenTurn(true);
                                this.queen=false;
                                return true;
                            }
                            n--;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean tryCaptureInnerQueen(BoardCell[] Way) {
        for(int i=0; i<Way.length;i++) {
            int n = 0;
            //int d = 0;
            if (this == Way[i]) {
                if (GridLayoutManager.getPlayer().equals("white")) {
                    if (this.color == CellColor.WHITE && i < Way.length - 2 && i >= 0) {
                        if (Way[n = i + 1].color == CellColor.BLACK &&!Way[n].captured) {
                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                            //d = n;
                            n++;
                            while (!(n == Way.length) && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        return true;
                                }
                                n++;
                            }
                        }
                        else if(Way[n=i+1].color == CellColor.CLEAN) {
                            while (n < Way.length - 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n < Way.length ) {
                                    n++;
                                    if (Way[n].color == CellColor.BLACK &&!Way[n].captured && n < Way.length ) {
                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        //d = n;
                                        n++;
                                        while (n < Way.length && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n < Way.length) {
                                                GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                                    return true;

                                            }
                                            n++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.color == CellColor.WHITE && i <= Way.length && i >= 2) {
                        if (Way[n = i - 1].color == CellColor.BLACK &&!Way[n].captured) {
                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                            //d = n;
                            n--;
                            while (n>=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        return true;

                                }
                                n--;
                            }
                        }
                        else if(Way[n=i-1].color == CellColor.CLEAN) {
                            while (n >= 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n >= 2) {
                                    n--;
                                    if (Way[n].color == CellColor.BLACK && !Way[n].captured && n>=1) {
                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        //d = n;
                                        n--;
                                        while (n >=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n >= 0) {
                                                GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                                    return true;

                                            }
                                            n--;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if (GridLayoutManager.getPlayer().equals("black")) {
                    if (this.color == CellColor.BLACK && i < Way.length-2 && i >= 0) {

                        if (Way[n = i + 1].color == CellColor.WHITE && !Way[n].captured) {
                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                            n++;
                            while (!(n == Way.length) && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        return true;

                                }
                                n++;
                            }
                        }
                        while (n < Way.length - 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                            if (Way[n].color == CellColor.CLEAN && n < Way.length ) {
                                n++;
                                if (Way[n].color == CellColor.WHITE && !Way[n].captured && n < Way.length ) {
                                    GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                    n++;
                                    while (n < Way.length && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                        if (Way[n].color == CellColor.CLEAN && n < Way.length) {
                                                GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                                    return true;


                                                }
                                            n++;
                                        }
                                    }
                                }
                            }
                        }
                    if (this.color == CellColor.BLACK && i < Way.length && i >= 2) {
                        if (Way[n = i - 1].color == CellColor.WHITE && !Way[n].captured) {
                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                            n--;
                            while (n >= 0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        return true;

                                }

                                n--;
                            }
                        }
                        else if(Way[n=i-1].color == CellColor.CLEAN) {
                            while (n >= 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n >= 2) {
                                    n--;
                                    if (Way[n].color == CellColor.WHITE && !Way[n].captured && n>=1) {
                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                        n--;
                                        while (n >=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n >= 0) {
                                                GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.blue);
                                                    return true;
                                            }
                                            n--;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean CaptureInnerQueen(BoardCell[] Way, int a, int b){
        for(int i=0; i<Way.length;i++) {
            int n = 0;
            int d = 0;
            if (this == Way[i]) {
                if (GridLayoutManager.getPlayer().equals("white")) {
                    if (this.color == CellColor.WHITE && i < Way.length - 2 && i >= 0) {
                        if (Way[n = i + 1].color == CellColor.BLACK &&!Way[n].captured) {
                            d = n;
                            n++;
                            while (!(n == Way.length) && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                        GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                        while(!(Way[n]==Way[i])){
                                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                            n--;
                                        }
                                        return true;
                                    }
                                    n++;
                                }
                            }
                        }
                        else if(Way[n=i+1].color == CellColor.CLEAN) {
                            while (n < Way.length - 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n < Way.length ) {
                                    n++;
                                    if (Way[n].color == CellColor.BLACK &&!Way[n].captured && n < Way.length ) {
                                        d = n;
                                        n++;
                                        while (n < Way.length && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n < Way.length) {
                                                if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                                    GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                                    while (!(Way[n] == Way[i])) {
                                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                                        n--;
                                                    }
                                                    return true;
                                                }
                                                n++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.color == CellColor.WHITE && i <= Way.length && i >= 2) {
                        if (Way[n = i - 1].color == CellColor.BLACK &&!Way[n].captured) {
                            d = n;
                            n--;
                            while (n>=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                        GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                        while(!(Way[n]==Way[i])){
                                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                            n++;
                                        }
                                        return true;
                                    }
                                    n--;
                                }
                            }
                        }
                        else if(Way[n=i-1].color == CellColor.CLEAN) {
                            while (n >= 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n >= 2) {
                                    n--;
                                    if (Way[n].color == CellColor.BLACK && !Way[n].captured && n>=1) {
                                        d = n;
                                        n--;
                                        while (n >=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n >= 0) {
                                                if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                                    GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                                    while (!(Way[n] == Way[i])) {
                                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                                        n++;
                                                    }
                                                    return true;
                                                }
                                                n--;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if (GridLayoutManager.getPlayer().equals("black")) {
                    if (this.color == CellColor.BLACK && i < Way.length-2 && i >= 0) {
                        if (Way[n = i + 1].color == CellColor.WHITE && !Way[n].captured) {
                            d = n;
                            n++;
                            while (!(n == Way.length) && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                        GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                        while(!(Way[n]==Way[i])){
                                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                            n--;
                                        }
                                        return true;
                                    }
                                    n++;
                                }
                            }
                        }
                        else if(Way[n=i+1].color == CellColor.CLEAN) {
                            while (n < Way.length - 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n < Way.length ) {
                                    n++;
                                    if (Way[n].color == CellColor.WHITE && !Way[n].captured && n < Way.length ) {
                                        d = n;
                                        n++;
                                        while (n < Way.length && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n < Way.length) {
                                                if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                                    GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                                    while (!(Way[n] == Way[i])) {
                                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                                        n--;
                                                    }
                                                    return true;
                                                }
                                                n++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.color == CellColor.BLACK && i < Way.length && i >= 2) {
                        if (Way[n = i - 1].color == CellColor.WHITE && !Way[n].captured) {
                            d = n;
                            n--;
                            while (n >= 0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                if (Way[n].color == CellColor.CLEAN) {
                                    if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                        GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                        while(!(Way[n]==Way[i])){
                                            GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                            n++;
                                        }
                                        return true;
                                    }
                                    n--;
                                }
                            }
                        }
                        else if(Way[n=i-1].color == CellColor.CLEAN) {
                            while (n >= 2 && !(Way[n].color == CellColor.WHITE) && !(Way[n].color == CellColor.BLACK) ) {
                                if (Way[n].color == CellColor.CLEAN && n >= 2) {
                                    n--;
                                    if (Way[n].color == CellColor.WHITE && !Way[n].captured && n>=1) {
                                        d = n;
                                        n--;
                                        while (n >=0 && !(Way[n].color == CellColor.BLACK) && !(Way[n].color == CellColor.WHITE)) {
                                            if (Way[n].color == CellColor.CLEAN && n >= 0) {
                                                if (GridLayoutManager.boardarray[a][b] == Way[n]) {
                                                    GridLayoutManager.boardarray[Way[d].x][Way[d].y].captured = true;
                                                    while (!(Way[n] == Way[i])) {
                                                        GridLayoutManager.squares2[Way[n].x][Way[n].y].setBackground(Color.pink);
                                                        n++;
                                                    }
                                                    return true;
                                                }
                                                n--;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void addWayInner(BoardCell[] Way, boolean border){
        for(int i=0; i<Way.length;i++){
            if(this == Way[i]){
                Way[i].border=border;
            }
        }
    }
    public void addWayInner(BoardCell[] Way, CellColor color){
        for(int i=0; i<Way.length;i++){
            if(this == Way[i]){
                Way[i].color=color;
            }
        }
    }
    public boolean tryCaptureInner(BoardCell[] Way){
        for(int i=0; i<Way.length;i++){
            if(this==Way[i]){
                if(GridLayoutManager.getPlayer().equals("white")) {
                    if(i<Way.length-2 && i>=0) {
                        if (this.color == CellColor.WHITE && Way[i + 1].color == CellColor.BLACK
                                && Way[i + 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 1].x][Way[i + 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 2].x][Way[i + 2].y].setBackground(Color.pink);
                            return true;
                        }
                    }
                    if(i>=2 && i<Way.length) {
                        if (this.color == CellColor.WHITE && Way[i - 1].color == CellColor.BLACK
                                && Way[i - 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 1].x][Way[i - 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 2].x][Way[i - 2].y].setBackground(Color.pink);
                            return true;
                        }
                    }
                }
                if(Objects.equals(GridLayoutManager.getPlayer(), "black")) {
                    if(i<Way.length-2 && i>=0) {
                        if (this.color == CellColor.BLACK && Way[i + 1].color == CellColor.WHITE
                                && Way[i + 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 1].x][Way[i + 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 2].x][Way[i + 2].y].setBackground(Color.pink);
                            return true;
                        }
                    }
                    if(i>=2 && i<Way.length) {
                        if (this.color == CellColor.BLACK && Way[i - 1].color == CellColor.WHITE
                                && Way[i - 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 1].x][Way[i - 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 2].x][Way[i - 2].y].setBackground(Color.pink);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean CaptureInner(BoardCell[] Way, int a, int b){
        for(int i=0; i<Way.length;i++){
            if(this==Way[i]){
                if(GridLayoutManager.getPlayer().equals("white")) {
                    if(i<=Way.length-2 && i>=0) {
                        if (this.color == CellColor.WHITE && (Way[i + 1].color == CellColor.BLACK && !Way[i + 1].captured)
                                && Way[i + 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.cyan);
                            GridLayoutManager.boardarray[this.x][this.y].addWay(true);
                            GridLayoutManager.squares2[Way[i + 1].x][Way[i + 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 2].x][Way[i + 2].y].setBackground(Color.pink);
                            if(GridLayoutManager.boardarray[a][b]==Way[i+2]){
                                return true;
                            }
                        }
                    }
                    if(i>=2 && i<Way.length) {
                        if (this.color == CellColor.WHITE && (Way[i - 1].color == CellColor.BLACK &&!Way[i - 1].captured)
                                && Way[i - 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.cyan);
                            GridLayoutManager.boardarray[this.x][this.y].addWay(true);
                            GridLayoutManager.squares2[Way[i - 1].x][Way[i - 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 2].x][Way[i - 2].y].setBackground(Color.pink);
                            if(GridLayoutManager.boardarray[a][b]==Way[i-2]){
                                return true;
                            }
                        }
                    }
                }
                if(GridLayoutManager.getPlayer().equals("black")) {
                    if(i<=Way.length-2 && i>=0) {
                        if (this.color == CellColor.BLACK && (Way[i + 1].color == CellColor.WHITE&&!Way[i + 1].captured)
                                && Way[i + 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.cyan);
                            GridLayoutManager.boardarray[this.x][this.y].addWay(true);
                            GridLayoutManager.squares2[Way[i + 1].x][Way[i + 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i + 2].x][Way[i + 2].y].setBackground(Color.pink);
                            if(GridLayoutManager.boardarray[a][b]==Way[i+2]){
                                return true;
                            }
                        }
                    }
                    if(i>=2 && i<Way.length) {
                        if (this.color == CellColor.BLACK && (Way[i - 1].color == CellColor.WHITE&&!Way[i - 1].captured)
                                && Way[i - 2].color == CellColor.CLEAN) {
                            GridLayoutManager.squares2[this.x][this.y].setBackground(Color.cyan);
                            GridLayoutManager.boardarray[this.x][this.y].addWay(true);
                            GridLayoutManager.squares2[Way[i - 1].x][Way[i - 1].y].setBackground(Color.pink);
                            GridLayoutManager.squares2[Way[i - 2].x][Way[i - 2].y].setBackground(Color.pink);
                            if(GridLayoutManager.boardarray[a][b]==Way[i-2]){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public void addIcon(int x ,int y, CellColor color, boolean queen){
        if(color==CellColor.WHITE){
            if(queen){
                GridLayoutManager.squares2[x][y].setIcon(queenWhite);
            }
            else{
            GridLayoutManager.squares2[x][y].setIcon(checkerWhite);}}
        else if(color==CellColor.BLACK){
            if(queen){
                GridLayoutManager.squares2[x][y].setIcon(queenBlack);
            }
            else{
            GridLayoutManager.squares2[x][y].setIcon(checkerBlack);}}
        else if(color==CellColor.CLEAN){ GridLayoutManager.squares2[x][y].setIcon(null);}
    }
    public boolean tryCapture(){
        if(this.queen){
            if (this.eightWay) {
                if (this.tryCaptureInnerQueen(BoardArray.getEightWay())) {
                    return true;
                }
            }
            if (this.sevenWayG1A7) {
                if (this.tryCaptureInnerQueen(BoardArray.getSevenWayG1A7())) {
                    return true;
                }
            }
            if (this.sevenWayH2B8) {
                if (this.tryCaptureInnerQueen(BoardArray.getSevenWayH2B8())) {
                    return true;
                }
            }
            if (this.sixWayC1H6) {
                if (this.tryCaptureInnerQueen(BoardArray.getSixWayC1H6())) {
                    return true;
                }
            }
            if (this.sixWayA3F8) {
                if (this.tryCaptureInnerQueen(BoardArray.getSixWayA3F8())) {
                    return true;
                }
            }
            if (this.threeWayC1A3) {
                if (this.tryCaptureInnerQueen(BoardArray.getThreeWayC1A3())) {
                    return true;
                }
            }
            if (this.threeWayH6F8) {
                if (this.tryCaptureInnerQueen(BoardArray.getThreeWayH6F8())) {
                    return true;
                }
            }
            if (this.fiveWayH4D8) {
                if (this.tryCaptureInnerQueen(BoardArray.getFiveWayH4D8())) {
                    return true;
                }
            }
            if (this.fiveWayE1A5) {
                if (this.tryCaptureInnerQueen(BoardArray.getFiveWayE1A5())) {
                    return true;
                }
            }
            if (this.fourWayA5D8) {
                if (this.tryCaptureInnerQueen(BoardArray.getFourWayA5D8())) {
                    return true;
                }
            }
            if (this.fourWayE1H4) {
                if (this.tryCaptureInnerQueen(BoardArray.getFourWayE1H4())) {
                    return true;
                }
            }
        }
        else
            if (this.eightWay) {
                if (this.tryCaptureInner(BoardArray.getEightWay())) {
                    return true;
                }
            }
            if (this.sevenWayG1A7) {
                if (this.tryCaptureInner(BoardArray.getSevenWayG1A7())) {
                    return true;
                }
            }
            if (this.sevenWayH2B8) {
                if (this.tryCaptureInner(BoardArray.getSevenWayH2B8())) {
                    return true;
                }
            }
            if (this.sixWayC1H6) {
                if (this.tryCaptureInner(BoardArray.getSixWayC1H6())) {
                    return true;
                }
            }
            if (this.sixWayA3F8) {
                if (this.tryCaptureInner(BoardArray.getSixWayA3F8())) {
                    return true;
                }
            }
            if (this.threeWayC1A3) {
                if (this.tryCaptureInner(BoardArray.getThreeWayC1A3())) {
                    return true;
                }
            }
            if (this.threeWayH6F8) {
                if (this.tryCaptureInner(BoardArray.getThreeWayH6F8())) {
                    return true;
                }
            }
            if (this.fiveWayH4D8) {
                if (this.tryCaptureInner(BoardArray.getFiveWayH4D8())) {
                    return true;
                }
            }
            if (this.fiveWayE1A5) {
                if (this.tryCaptureInner(BoardArray.getFiveWayE1A5())) {
                    return true;
                }
            }
            if (this.fourWayA5D8) {
                if (this.tryCaptureInner(BoardArray.getFourWayA5D8())) {
                    return true;
                }
            }
            if (this.fourWayE1H4) {
                if (this.tryCaptureInner(BoardArray.getFourWayE1H4())) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public boolean Capture(int a, int b) {
        if(this.queen) {
            if (this.eightWay) {
                if (this.CaptureInnerQueen(BoardArray.getEightWay(), a, b)) {
                    return true;
                }
            }
            if (this.sevenWayG1A7) {
                if (this.CaptureInnerQueen(BoardArray.getSevenWayG1A7(), a, b)) {
                    return true;
                }
            }
            if (this.sevenWayH2B8) {
                if (this.CaptureInnerQueen(BoardArray.getSevenWayH2B8(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayC1H6) {
                if (this.CaptureInnerQueen(BoardArray.getSixWayC1H6(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayA3F8) {
                if (this.CaptureInnerQueen(BoardArray.getSixWayA3F8(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayC1A3) {
                if (this.CaptureInnerQueen(BoardArray.getThreeWayC1A3(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayH6F8) {
                if (this.CaptureInnerQueen(BoardArray.getThreeWayH6F8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayH4D8) {
                if (this.CaptureInnerQueen(BoardArray.getFiveWayH4D8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayE1A5) {
                if (this.CaptureInnerQueen(BoardArray.getFiveWayE1A5(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayA5D8) {
                if (this.CaptureInnerQueen(BoardArray.getFourWayA5D8(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayE1H4) {
                if (this.CaptureInnerQueen(BoardArray.getFourWayE1H4(), a, b)) {
                    return true;
                }
            }
        }
        else {
            if (this.eightWay) {
                if (this.CaptureInner(BoardArray.getEightWay(), a, b)) {
                    return true;
                }
            }
            if (this.sevenWayG1A7) {
                if (this.CaptureInner(BoardArray.getSevenWayG1A7(), a, b)) {
                    return true;
                }
            }
            if (this.sevenWayH2B8) {
                if (this.CaptureInner(BoardArray.getSevenWayH2B8(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayC1H6) {
                if (this.CaptureInner(BoardArray.getSixWayC1H6(), a, b)) {
                    return true;
                }
            }
            if (this.sixWayA3F8) {
                if (this.CaptureInner(BoardArray.getSixWayA3F8(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayC1A3) {
                if (this.CaptureInner(BoardArray.getThreeWayC1A3(), a, b)) {
                    return true;
                }
            }
            if (this.threeWayH6F8) {
                if (this.CaptureInner(BoardArray.getThreeWayH6F8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayH4D8) {
                if (this.CaptureInner(BoardArray.getFiveWayH4D8(), a, b)) {
                    return true;
                }
            }
            if (this.fiveWayE1A5) {
                if (this.CaptureInner(BoardArray.getFiveWayE1A5(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayA5D8) {
                if (this.CaptureInner(BoardArray.getFourWayA5D8(), a, b)) {
                    return true;
                }
            }
            if (this.fourWayE1H4) {
                if (this.CaptureInner(BoardArray.getFourWayE1H4(), a, b)) {
                    return true;
                }
            }
        }
        return false;

    }
    public void addWay(boolean border){
        if (this.eightWay){
            addWayInner(BoardArray.getEightWay(), border);
        }
        if (this.sevenWayG1A7) {
            addWayInner(BoardArray.getSevenWayG1A7(), border);
        }
        if (this.sevenWayH2B8) {
            addWayInner(BoardArray.getSevenWayH2B8(), border);
        }
        if (this.sixWayC1H6) {
            addWayInner(BoardArray.getSixWayC1H6(), border);
        }
        if (this.sixWayA3F8) {
            addWayInner(BoardArray.getSixWayA3F8(), border);
        }
        if (this.threeWayC1A3) {
            addWayInner(BoardArray.getThreeWayC1A3(), border);
        }
        if (this.threeWayH6F8) {
            addWayInner(BoardArray.getThreeWayH6F8(), border);
        }
        if (this.fiveWayH4D8) {
            addWayInner(BoardArray.getFiveWayH4D8(), border);
        }
        if (this.fiveWayE1A5){
            addWayInner(BoardArray.getFiveWayE1A5(),border);
        }
        if (this.fourWayA5D8) {
            addWayInner(BoardArray.getFourWayA5D8(),border);
        }
        if (this.fourWayE1H4) {
            addWayInner(BoardArray.getFourWayE1H4(),border);
        }
    }
    public void addWay(CellColor color){
        if (this.eightWay){
            addWayInner(BoardArray.getEightWay(), color);
        }
        if (this.sevenWayG1A7) {
            addWayInner(BoardArray.getSevenWayG1A7(), color);
        }
        if (this.sevenWayH2B8) {
            addWayInner(BoardArray.getSevenWayH2B8(), color);
        }
        if (this.sixWayC1H6) {
            addWayInner(BoardArray.getSixWayC1H6(), color);
        }
        if (this.sixWayA3F8) {
            addWayInner(BoardArray.getSixWayA3F8(), color);
        }
        if (this.threeWayC1A3) {
            addWayInner(BoardArray.getThreeWayC1A3(), color);
        }
        if (this.threeWayH6F8) {
            addWayInner(BoardArray.getThreeWayH6F8(), color);
        }
        if (this.fiveWayH4D8) {
            addWayInner(BoardArray.getFiveWayH4D8(), color);
        }
        if (this.fiveWayE1A5){
            addWayInner(BoardArray.getFiveWayE1A5(), color);
        }
        if (this.fourWayA5D8) {
            addWayInner(BoardArray.getFourWayA5D8(), color);
        }
        if (this.fourWayE1H4) {
            addWayInner(BoardArray.getFourWayE1H4(), color);
        }
    }

    public void change(CellColor color) {
        if(color==CellColor.CLEAN){
        GridLayoutManager.squares2[this.x][this.y].setIcon(null);
        this.color = CellColor.CLEAN;
        this.addWay(CellColor.CLEAN);}
        else if(color==CellColor.WHITE && this.queen){
            GridLayoutManager.squares2[this.x][this.y].setIcon(queenWhite);
            this.color = CellColor.WHITE;
            this.addWay(CellColor.WHITE);
        }
        else if(color==CellColor.BLACK && this.queen){
            GridLayoutManager.squares2[this.x][this.y].setIcon(queenBlack);
            this.color = CellColor.BLACK;
            this.addWay(CellColor.BLACK);
        }
        else if(color==CellColor.WHITE){
            GridLayoutManager.squares2[this.x][this.y].setIcon(checkerWhite);
            this.color = CellColor.WHITE;
            this.addWay(CellColor.WHITE);
        }
        else if(color==CellColor.BLACK){
            GridLayoutManager.squares2[this.x][this.y].setIcon(checkerBlack);
            this.color = CellColor.BLACK;
            this.addWay(CellColor.BLACK);
        }
    }

    @Override
    public void choseChecker(boolean border) {
        if(this.x==7&&this.y==1){this.border=false;this.addWay(false);}
        else {
            if(!border){
                GridLayoutManager.squares2[this.x][this.y].setBackground(Color.BLACK);
                this.border = false;
                this.addWay(false);
            }
            if(border) {
                GridLayoutManager.squares2[this.x][this.y].setBackground(Color.cyan);
                this.border = true;
                this.addWay(true);
            }
            }
    }
}
