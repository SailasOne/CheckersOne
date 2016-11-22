/**
 * Created by SailaS on 10/2/16.
 */
public interface Capturable {
    boolean tryCapture();
    boolean Capture(int a, int b);
    boolean CaptureInner(BoardCell[] Way, int a, int b);
    boolean tryCaptureInner(BoardCell[] Way);
    boolean tryCaptureInnerQueen(BoardCell[] Way);
    boolean CaptureInnerQueen(BoardCell[] Way, int a, int b);
}
