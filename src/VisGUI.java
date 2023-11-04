import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VisGUI {
    public VisGUI(int size) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(size, size));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                final JButton button = new JButton();
                String string = i +  "" + j;
                button.setText("");
                button.setName(string);
                button.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            TicTacToe.buttonClicked(button);
                            TicTacToe.gameRules(button);
                        }
                    });
                    
                button.setBorder(BorderFactory.createLineBorder(Color.RED));
                button.setBackground(Color.GRAY);
                button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
                panel.add(button);
            }

        }

        frame.add(panel);
        frame.setSize(400,400);
        frame.setVisible(true);




    }
}