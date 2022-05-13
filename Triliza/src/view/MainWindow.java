package view;

import java.awt.*;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    public final static int TOP_HEIGHT = 80;
    public final static int PLAYER_WIDTH = 300;

    TopPanel topPnl;
    PlayerPanel leftPnl;
    PlayerPanel rightPnl;

    public MainWindow() {
        super("TUC-TAC-TOE");
        Container c = getContentPane();
        c.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.topPnl = new TopPanel();
        c.add(topPnl, BorderLayout.PAGE_START);

        this.leftPnl = new PlayerPanel(0);
        this.rightPnl = new PlayerPanel(1);
        this.add(leftPnl, BorderLayout.WEST);
        this.add(rightPnl,BorderLayout.SOUTH);
        this.pack();
    }

    public static void main(String[] args) {
        MainWindow myWindow = new MainWindow();
    }
}
