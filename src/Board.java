import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class Board {
    private int cells;
    static List<Cell> cellsList;
    static List<Cell> listWin;

    public Board(int c) {
        cells = c;
        createBoard();
    }

    public int getCells() {
        return cells;
    }

    void createBoard() {
        cellsList = new LinkedList<>();
        listWin = new LinkedList<>();
        for (int i = 1; i < cells * cells; i++) {
            cellsList.add(new Cell(i));
            listWin.add(new Cell(i));
        }
        cellsList.add(new Cell(0));
        listWin.add(new Cell(0));
//------------------------------------------------------
        System.out.print("Новая игра: ");
        Collections.shuffle(cellsList);
        for (int i = 0; i < listWin.size(); i++) {
            if (i % cells == 0) System.out.println();
            System.out.print(" " + listWin.get(i).getNumberOnCell());
        }
        System.out.println();
//----------------------------------------------------- Создание графа
        for (int i = 0; i < cellsList.size() - 1; i++) {
            //   if ((i + 1) % ALL_CELL == 0) cellsList.get(i).setRightCell(Cell.NO_NEIGHBOUR);
            cellsList.get(i).setRightCell(cellsList.get(i + 1));
            cellsList.get(cellsList.size() - i - 1).setLeftCell(cellsList.get(cellsList.size() - i - 2));
        }
        ((LinkedList<Cell>) cellsList).getLast().setRightCell(Cell.NO_NEIGHBOUR);
        ((LinkedList<Cell>) cellsList).getFirst().setLeftCell(Cell.NO_NEIGHBOUR);

        for (int i = 0; i < cells; i++) { //Верхние и нижние границы
            cellsList.get(i).setUpCell(Cell.NO_NEIGHBOUR);
            cellsList.get(cellsList.size() - i - 1).setDownCell(Cell.NO_NEIGHBOUR);
        }

        for (int i = cells; i < cellsList.size(); i++) {//Внутренние клетки
            cellsList.get(i).setUpCell(cellsList.get(i - cells));
            cellsList.get(cellsList.size() - i - 1).setDownCell(cellsList.get(cellsList.size() - i + cells - 1));
        }
//------------------------------------------------------
        for (int i = 0; i < cellsList.size(); i++) {
            if (i % cells == 0) System.out.println();
            System.out.print(" " + cellsList.get(i).getNumberOnCell());
        }
        System.out.println();
    }


}
//------------------------------------------------------Ниже коды проверок(на всякий случай)
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