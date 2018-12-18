import java.awt.*;
import java.util.LinkedList;

public class Algorithm {
    private LinkedList<Cell> allCellsMass = new LinkedList<>();//Нужен?
    private LinkedList<Cell> allPath = new LinkedList<>();

    Algorithm() {
        int indexO = 1;
        int count = 0;
        for (int k = 0; k < Game.board.getCells() * Game.board.getCells(); k++) {
            for (int j = k; j < Game.board.getCellsList().size(); j++) {

                if (Game.board.getCellsList().get(k).getNumberOnCell() == 0)
                    indexO = k;//нахождение ячейки с нулем и запись соответсвующего индекса
                //System.out.println(Game.board.getCellsList().get(k).getNumberOnCell() + ">" + Game.board.getCellsList().get(j).getNumberOnCell() + "?");//вывод на консоль последующего цикла
                if (Game.board.getCellsList().get(k).getNumberOnCell() > Game.board.getCellsList().get(j).getNumberOnCell()
                        && Game.board.getCellsList().get(j).getNumberOnCell() != 0) {
                    //    System.out.println("+");
                    count++;
                }
            }
        }
        //  System.out.println("Сумма без нуля " + count);
        solverBot();
        count += indexO / Game.board.getCells();
        System.out.println("\nСумма с нулем " + count);

        if (count % 2 == 0) {                                               //При нечетных getCells() что делать?
            System.out.println("Нерешаемая комбинация");
            Game.endGame = true;
        }

    }

    public void solverBot() {
        for (Cell x : Game.board.getCellsList()) {
            System.out.print(x.getMass());
        }
    }

}