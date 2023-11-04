import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe {
    public static int count = 0;
    public static String[][] board;

    public TicTacToe(int size) {
        this.board = new String[size][size];

    }

    public static void buttonClicked(JButton button) {
        if(button.getText().equals("")) {
            count++;
            if(count % 2 == 1) {
                button.setText("X");
            }
            if(count % 2 == 0) {
                button.setText("O");
            }
        }   
    }


    public static void gameRules(JButton button) {
        //"X" or "O"?

        String string = button.getText();
        button.setFont(new Font("Arial", Font.PLAIN, 50));
        button.setForeground(Color.WHITE);


        //Gives coordinates of the button
        int x = Character.getNumericValue(button.getName().charAt(0));
        int y = Character.getNumericValue(button.getName().charAt(1));
        board[x][y] = string;

        //diagonal
        // Check rows
        for (int row = 0; row < board.length; row++) {
            boolean hasWon = true;
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null || !board[row][col].equals(board[row][0])) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon && board[row][0] != null && board[row].length == board.length) {
                JOptionPane.showMessageDialog(null, string + " won.");
                return;
            }
        }

        // Check columns
        for (int col = 0; col < board[0].length; col++) {
            boolean hasWon = true;
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == null || !board[row][col].equals(board[0][col])) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon && board[0][col] != null && board.length == board[0].length) {
                JOptionPane.showMessageDialog(null, string + " won.");
                return;
            }
        }

        // Check diagonal from top-left to bottom-right
        if (board[0][0] != null) {
            boolean hasWon = true;
            for (int i = 1; i < board.length; i++) {
                if (board[i][i] == null || !board[i][i].equals(board[0][0])) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon && board[0][0] != null && board.length == board[0].length) {
                JOptionPane.showMessageDialog(null, string + " won.");
                return;
            }
        }

        // Check diagonal from top-right to bottom-left
        if (board[0][board[0].length - 1] != null) {
            boolean hasWon = true;
            for (int i = 1; i < board.length; i++) {
                int col = board[0].length - 1 - i;
                if (board[i][col] == null || !board[i][col].equals(board[0][board[0].length - 1])) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon && board[0][board[0].length - 1] != null && board.length == board[0].length) {
                JOptionPane.showMessageDialog(null, string + " won.");
                return;
            }
        }

        // Check for draw
        boolean isDraw = true;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == null) {
                    isDraw = false;
                    break;
                }
            }
        }
        if (isDraw) {
            JOptionPane.showMessageDialog(null, "draw.");
            return;
        }

    }
}