import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game {
    static Board board;
    static boolean endGame;

    public static void main(String[] args) {
        Game game = new Game();
        game.createNewGame(4);
    }

    public void createNewGame(int cellBoard) {
        endGame = false;
        board = new Board(cellBoard);
        Algorithm algorithm = new Algorithm();
        GUI gui = new GUI();
        while (!endGame) {
            if (board.winGame()) {
                System.out.println("Вы выиграли");
                endGame = true;
                break;
            }
        }
        gui.setVisible(false);
        gui.disposeGui();
        if (endGame) createNewGame(cellBoard);
    }
}
