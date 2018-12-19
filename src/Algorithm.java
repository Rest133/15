import java.util.LinkedList;

public class Algorithm {
    private boolean odd = false;
    private LinkedList<Edge> edgesList = new LinkedList<>();
    LinkedList<Edge> answer = new LinkedList<>();

    Algorithm() {
        int indexO = 1;
        int count = 0;
//---------------------------------------------------------------------------------Поиск решаемости игры
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
        System.out.println("\nСумма с нулем " + count + "\n");
        if (Game.board.getCells() % 2 != 0) odd = true;

        if (count % 2 == 0) {                                               //При нечетных getCells() что делать?
            System.out.println("Нерешаемая комбинация");
            Game.endGame = true;
        } else {
//-----------------------------------------------------------------------------------Запуск решателя
            solverBot();
        }
    }

    public void solverBot() {
        LinkedList<Edge> pathTo = new LinkedList<>();
        System.out.println(findCell(0));
        addEdges();
        System.out.println("Поиск ...");
        findPath(Game.board.getCellsList().get(findCell(0)), Game.board.getCellsList().get(findCell(1)));
        System.out.println("Поиск завершен");
        for (Edge x : answer) {
            System.out.println(x.toString());
        }

    }

    public int findCell(int num) {
        for (Cell x : Game.board.getCellsList()) {
            if (x.getNumberOnCell() == num) {
                System.out.println("Ячейка с номером " + x.getNumberOnCell() + " найдена");
                return Game.board.getCellsList().indexOf(x);
            }
        }
        return -1;
    }

    public void addEdges() {
        for (Cell x : Game.board.getCellsList()) {
            if (x.getLeftCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getLeftCell(), 1));
            if (x.getRightCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getRightCell(), 1));
            if (x.getUpCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getUpCell(), 1));
            if (x.getDownCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getDownCell(), 1));
        }
        for (Edge x : edgesList) {
            System.out.println(x.toString());
        }
    }

    public void findPath(Cell start, Cell end) {              //Возвращает List, не void
        LinkedList<Edge> smallPath = new LinkedList<>();
        worked:
        {
            System.out.println("\nНовая итерация");
            System.out.println("Start = " + start.getNumberOnCell() + "; End = " + end.getNumberOnCell());
            for (Edge x : edgesList) {
                if (x.getBeginCell() == start && !x.isWasVisited()) smallPath.add(x);
            }
            System.out.println("Новый лист завершен");
            for (Edge x : smallPath) {
                System.out.print(x.toString());
                System.out.println(" - " + x.isWasVisited());
                if (x.getEndCell().getNumberOnCell() == end.getNumberOnCell()) {
                    answer.add(x);
                    System.out.println("Путь найден сразу");
                    break worked;
                }
            }
            for (Edge x : smallPath) {
                if(x.getEndCell().getNumberOnCell()==end.getNumberOnCell()){
                    answer.add(x);
                    System.out.println("Путь найден");
                    break worked;
                }else{
                    x.setWasVisited(true);
                    findPath(x.getEndCell(),end);
                }
            }

        }
    }

    public void goTo(Cell currentCell, LinkedList<Edge> path) {
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