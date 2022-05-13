package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PlayerPanel extends JPanel {
    JButton selPlayerBtn;
    JTextField plNameTxfld;
    int pos;
    
    JPanel panel = new JPanel();

    public PlayerPanel(int pos) {
        this.pos = pos;
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));
        panel.setBorder(new LineBorder(Color.GRAY,1));

        selPlayerBtn = new JButton("Choose Player");
        selPlayerBtn.setPreferredSize(new Dimension(150,40));
        selPlayerBtn.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(selPlayerBtn);

        plNameTxfld = new JTextField();
        plNameTxfld.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,40));
        plNameTxfld.setAlignmentX(CENTER_ALIGNMENT);
        plNameTxfld.setHorizontalAlignment(JTextField.CENTER);

        panel.add(plNameTxfld);
    }
}
