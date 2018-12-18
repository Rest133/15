import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private int cells;
    private List<Cell> cellsList;
    private List<Cell> winList;

    public Board(int c) {
        cells = c;
        cellsList = new LinkedList<>();
        winList = new LinkedList<>();
        for (int i = 1; i < cells * cells; i++) {
            cellsList.add(new Cell(i, 1));
            winList.add(new Cell(i, 1));
        }
        cellsList.add(new Cell(0, 0));
        winList.add(new Cell(0, 0));
        Collections.shuffle(cellsList);

        createGraph(cellsList);

        for (int i = 0; i < cellsList.size(); i++) {
            if (i % cells == 0) System.out.println();
            System.out.print(" " + cellsList.get(i).getNumberOnCell());
        }
        System.out.println();
    }

    public int getCells() {
        return cells;
    }

    public List<Cell> getCellsList() {
        return cellsList;
    }

    void createGraph(List<Cell> list) {
        for (int i = 0; i < list.size() - 1; i++) {//Боковые границы,внутренние клетки
            list.get(i).setRightCell(list.get(i + 1));
            list.get(list.size() - i - 1).setLeftCell(list.get(list.size() - i - 2));
        }
        for (int i = 0; i < cells; i++) { //Боковые границы для клеток
            list.get(i * cells).setLeftCell(Cell.NO_NEIGHBOUR);
            if (i != 0) list.get(i * cells - 1).setRightCell(Cell.NO_NEIGHBOUR);
        }

        ((LinkedList<Cell>) list).getLast().setRightCell(Cell.NO_NEIGHBOUR);
        ((LinkedList<Cell>) list).getFirst().setLeftCell(Cell.NO_NEIGHBOUR);

        for (int i = 0; i < cells; i++) { //Верхние и нижние границы для клеток
            list.get(i).setUpCell(Cell.NO_NEIGHBOUR);
            list.get(list.size() - i - 1).setDownCell(Cell.NO_NEIGHBOUR);
        }
        for (int i = cells; i < list.size(); i++) {//Верхние и нижние границы, внутренние клетки
            list.get(i).setUpCell(list.get(i - cells));
            list.get(list.size() - i - 1).setDownCell(list.get(list.size() - i + cells - 1));
        }
    }

    public boolean winGame() {
        Game.endGame = false;
        int count = 0;
        for (int i = 0; i < cellsList.size(); i++) {
            if (this.getCellsList().get(i).getNumberOnCell() == winList.get(i).getNumberOnCell()) count++;
        }
        if (count == this.getCellsList().size()) Game.endGame = true;

        return Game.endGame;
    }
}


//------------------------------------------------------Ниже коды проверок(на всякий случай)


     /*   for (int i = 0; i < winList.size(); i++) {
        if (i % cells == 0) System.out.println();
        System.out.print(" " + winList.get(i).getNumberOnCell());
        }
        System.out.println();
    */

    /*    System.out.println(cellsList.size() + " - cellList"); //Начало новой игры
        System.out.print("Выигрышная комбинация:");
        for (int i = 0; i < cellsList.size(); i++) {
            if (i % ALL_CELL == 0) System.out.println();
            System.out.print(" " + cellsList.get(i).getNumberOnCell());
        }
        System.out.println();
    */

//-------------------------------------------------------
   /*     {                           //Проверка соседей клетки
            int i = 0;
            System.out.println("Ячейка с номером: " + cellsList.get(i).getNumberOnCell());
            System.out.println();
            System.out.println("U " + cellsList.get(i).getUpCell().getNumberOnCell());
            System.out.println(cellsList.get(i).getLeftCell().getNumberOnCell() + " " + cellsList.get(i).getNumberOnCell() + " " + cellsList.get(i).getRightCell().getNumberOnCell());
            System.out.println("D " + cellsList.get(i).getDownCell().getNumberOnCell());
        }
        */
//-------------------------------------------------------
//--------------------------------Смена в левую сторону
 /*       for(int i=0;i<cellsList.size();i++){
            if(cellsList.get(i).getLeftCell().getNumberOnCell()==0){
                cellsList.get(i).changeLeft();
                break;
            }
        }
//----------------------------------------------Смена в правую сторону
        for(int i=0;i<cellsList.size();i++){
            if(cellsList.get(cellsList.size()-i-1).getRightCell().getNumberOnCell()==0){
                cellsList.get(cellsList.size()-i-1).changeRight();
                break;
            }
        }
        */