import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game {
    static Board board;

    public static void main(String[] args) {
        board = new Board(2);
        GUI gui = new GUI();
        while (true) {
            if (board.winGame()) {
                System.out.println("Вы выиграли");
                break;
            }
        }
        System.exit(0);
    }

}
//Создать граф "Выигрышной комбинации",чтоб в последствии сравнить с ним