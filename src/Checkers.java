/**
 * Created by SailaS on 10/2/16.
 */
import java.awt.*;
import javax.swing.*;
public class Checkers extends JFrame {
    static String first = "";
    static String second = "";
    static int whiteCount = 0;
    static int blackCount = 0;
    static boolean winner = false;
    static JButton btn = new JButton("сделать ход");
    static JLabel label = new JLabel("ШАШКИ");

        public static void main(String[] args) {
            JFrame frame = new JFrame("Checkers v1.0");



            GridLayoutManager gridLayoutManager = new GridLayoutManager();
            BoardArray boardArray = new BoardArray();
            ButtonHandler buttonHandler = new ButtonHandler();
            //BoardArray boardArray = new BoardArray();
            //gridLayoutManager.contents.setSize(400,400);
            //eMouser eMouser = new eMouser();
            frame.setResizable(false);
            frame.setSize(600, 650);//размер окна
            frame.getContentPane().add(gridLayoutManager.contents);
             //frame.getContentPane().add(gridLayoutManager.contents);//или frame.getContentPane().add(new Checkers()); добавляем вунтрь панель
            //frame.getContentPane().add(gridLayoutManager);
            frame.add(btn, BorderLayout.SOUTH);
            btn.addActionListener(buttonHandler);
            frame.add(label, BorderLayout.NORTH);
            frame.setBackground(Color.LIGHT_GRAY);//бэкграунд цвет окна
            //frame.addMouseListener(eMouser);
            frame.setLocationRelativeTo(null);//задаем параметр где откроется наша форма(нулл значит что в центре эекрана)
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//что произойдет если нажать на крестик нашего окна
            frame.setVisible(true);//задаем параметр видимости окна, по умолчанию фолс, тру нужно для отображения



        }
    }


