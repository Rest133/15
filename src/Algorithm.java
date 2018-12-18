import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class Algorithm {
    private LinkedList<Cell> allCellsSorted = new LinkedList<>();
    private boolean odd = false;

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
        count += indexO / Game.board.getCells();
        System.out.println("\nСумма с нулем " + count);
        if (Game.board.getCells() % 2 != 0) odd = true;

        if (count % 2 == 0) {                                               //При нечетных getCells() что делать?
            System.out.println("Нерешаемая комбинация");
            Game.endGame = true;
        }
        solverBot();
        System.out.println();
    }

    public void solverBot() {
        for (Cell x : Game.board.getCellsList()) {
            allCellsSorted.add(x);
        }
        allCellsSorted.sort(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                String str1 = Integer.toString(o1.getMass());
                String str2 = Integer.toString(o2.getMass());
                return str1.compareTo(str2);
            }
        });

    }


}

/*

   for (Cell x : Game.board.getCellsList()) { //Обход доски для каждой клетки
            System.out.println();
            System.out.println("  " + x.getUpCell().getNumberOnCell());
            System.out.println(x.getLeftCell().getNumberOnCell() + " " + x.getNumberOnCell() + " " + x.getRightCell().getNumberOnCell());
            System.out.println("  " + x.getDownCell().getNumberOnCell());
        }

 */