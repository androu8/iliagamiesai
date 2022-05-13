package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TopPanel extends JPanel {
    JButton startGameBtn;
    JButton doneBtn;
    JButton quitBtn;

    public TopPanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(new LineBorder(Color.GRAY,1));
        this.setPreferredSize(new Dimension(MainWindow.WIDTH,MainWindow.HEIGHT));

        this.startGameBtn = new JButton("Start Game");
        this.startGameBtn.setPreferredSize(new Dimension(100,40));
        this.startGameBtn.setEnabled(false);
        this.add(this.startGameBtn);

        this.doneBtn = new JButton("Done");
        this.doneBtn.setPreferredSize(new Dimension(100,40));
        this.doneBtn.setEnabled(false);
        this.add(this.doneBtn);

        this.quitBtn = new JButton("Quit");
        this.quitBtn.addActionListener((e)->{System.exit(0);});
        this.quitBtn.setPreferredSize(new Dimension(100,40));
        this.add(this.quitBtn);
    }
}
