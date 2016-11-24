
import java.awt.*;
import javax.swing.*;
public class Checkers extends JFrame {
    static String first = "";
    static String second = "";
    static int whiteCount = 0;
    static int blackCount = 0;
    static JButton btn = new JButton("сделать ход");
    static JLabel label = new JLabel("ШАШКИ");

        public static void main(String[] args) {
            JFrame frame = new JFrame("Checkers v1.0");

            GridLayoutManager gridLayoutManager = new GridLayoutManager();
            BoardArray boardArray = new BoardArray();
            ButtonHandler buttonHandler = new ButtonHandler();
            frame.setResizable(false);
            frame.setSize(600, 650);//размер окна
            frame.getContentPane().add(gridLayoutManager.contents);
            frame.add(btn, BorderLayout.SOUTH);
            btn.addActionListener(buttonHandler);
            frame.add(label, BorderLayout.NORTH);
            frame.setBackground(Color.LIGHT_GRAY);//бэкграунд цвет окна
            frame.setLocationRelativeTo(null);//задаем параметр где откроется наша форма(нулл значит что в центре эекрана)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет если нажать на крестик нашего окна
            frame.setVisible(true);//задаем параметр видимости окна, по умолчанию фолс, тру нужно для отображения



        }
    }


