import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game {
    static Board board;
    public static void main(String[] args) {
        board = new Board(3);
        GUI gui = new GUI();
        while (true){
            if(Board.listWin.equals(Board.cellsList)){
                System.out.println("Вы выиграли");
                break;
            }
        }
    }

}
//Создать граф "Выигрышной комбинации",чтоб в последствии сравнить с ним