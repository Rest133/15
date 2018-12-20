import java.util.*;

public class Algorithm {
    private boolean odd = false;
    private LinkedList<Edge> edgesList = new LinkedList<>();
    private int indexO = findCell(0);

    Algorithm() {
        int indexO = 0;
        int count = 0;
//---------------------------------------------------------------------------------Поиск решаемости игры
        for (int k = 0; k < Game.board.getCells() * Game.board.getCells(); k++) {
            for (int j = k; j < Game.board.getCellsList().size(); j++) {
                if (Game.board.getCellsList().get(k).getNumberOnCell() == 0)
                    indexO = k;//нахождение ячейки с нулем и запись соответсвующего индекса
                if (Game.board.getCellsList().get(k).getNumberOnCell() > Game.board.getCellsList().get(j).getNumberOnCell()
                        && Game.board.getCellsList().get(j).getNumberOnCell() != 0) {
                    count++;
                }
            }
        }
        count += indexO / Game.board.getCells();
        if (Game.board.getCells() % 2 != 0) odd = true;

        System.out.println("\nНечетность клеток: " + odd + "\nСумма с нулем " + count + "\n");

        if (odd) {                                                              //Не раптит
            if (count % 2 != 0) {
                System.out.println("Нерешаемая комбинация");
                Game.endGame = true;
            } else {
                solverBot();
            }
        } else {
            if (count % 2 == 0) {
                System.out.println("Нерешаемая комбинация");
                Game.endGame = true;
            } else {
//-----------------------------------------------------------------------------------Запуск решателя
                solverBot();
            }
        }


    }

    public void solverBot() {
        Stack<Edge> pathToCell = new Stack<>();
        for (int i = 1; i < Game.board.getCellsList().size(); i++) {
            System.out.println("Поиск ..." + (i));
            if (Game.board.getCellsList().get(i - 1).getNumberOnCell() != Game.board.getCellsList().get(findCell(i)).getNumberOnCell()) {
                pathToCell.addAll(findPath(Game.board.getCellsList().get(findCell(i)), Game.board.getCellsList().get(i - 1)));
                System.out.println("Поиск завершен");
                for (Edge x : pathToCell) {
                    System.out.println(x);
                }
                while (!pathToCell.isEmpty()) {
                    LinkedList<Edge> smallPath = new LinkedList<>();
                    Edge currentEdge = pathToCell.pop();
                    int index = currentEdge.getEndCell().getNumberOnCell();
                    System.out.println("Начинаю продвижение к клетке " + currentEdge.getBeginCell().getNumberOnCell());
                    System.out.println(currentEdge);
                    smallPath.addAll(findPath(Game.board.getCellsList().get(indexO), Game.board.getCellsList().get(findCell(index))));
                    cellGoTo(Game.board.getCellsList().get(findCell(i)),smallPath);
                    System.out.println("Клетка поменялась");
                    
                }
            }
        }
    }

    public int findCell(int num) {
        for (Cell x : Game.board.getCellsList()) {
            if (x.getNumberOnCell() == num) {
                //System.out.println("Ячейка с номером " + x.getNumberOnCell() + " найдена");
                return Game.board.getCellsList().indexOf(x);
            }
        }
        return -1;
    }

    public void addEdges() {
        for (Cell x : Game.board.getCellsList()) {
            if (x.getLeftCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getLeftCell()));
            if (x.getRightCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getRightCell()));
            if (x.getUpCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getUpCell()));
            if (x.getDownCell().getNumberOnCell() != -1) edgesList.add(new Edge(x, x.getDownCell()));
        }
     /*   System.out.println("Все пути");
        for (Edge x : edgesList) {
            System.out.println(x.toString());
        }
        */
    }

    public LinkedList<Edge> findPath(Cell start, Cell end) {//Возвращает List, не void
        addEdges();
        Queue edgesStack = new Queue();
        LinkedList<Edge> cameFrom = new LinkedList<>();
        //  System.out.println("\nStart = " + start.getNumberOnCell() + "; End = " + end.getNumberOnCell());
//-----------------------------------------------------------------------------------------------Алгоритм поиска(модифицированный обход в ширину
        for (Edge x : edgesList) {
            if (x.getBeginCell() == start && !x.isWasVisited()) {
                if (x.getEndCell().getNumberOnCell() == end.getNumberOnCell()) {
                    // System.out.println("Путь найден");
                    cameFrom.add(x);
                    return cameFrom;
                } else {
                    x.setWasVisited(true);
                    edgesStack.insert(x);
                    //  System.out.println(x);
                }
            }
        }

        while (!edgesStack.isEmpty()) {
            Edge currentEdge = edgesStack.remove();
            // System.out.println("CurrentEdge = " + currentEdge);
            cameFrom.add(currentEdge);
            if (currentEdge.getEndCell().getNumberOnCell() == end.getNumberOnCell()) break;
            for (Edge x : edgesList) {
                if (currentEdge.getEndCell().getNumberOnCell() == x.getBeginCell().getNumberOnCell() && !x.isWasVisited()) {
                    x.setWasVisited(true);
                    edgesStack.insert(x);
                }
            }

        }
        for (Edge x : edgesList) {
            x.setWasVisited(false);
        }
  /*      for (Edge x : cameFrom) {
            System.out.println("CameFrom = " + x);
        }*/
//---------------------------------------------------------------------------------------Инвертирование полученного списка
        LinkedList<Edge> invert = new LinkedList<>();
        invert.add(cameFrom.getLast());

        while (invert.getLast().getBeginCell().getNumberOnCell() != start.getNumberOnCell()) {
            if (invert.getLast().getBeginCell().getNumberOnCell() == cameFrom.getLast().getEndCell().getNumberOnCell()) {
                //System.out.println("It's worked");
                invert.add(cameFrom.getLast());
            } else cameFrom.removeLast();
        }
        cameFrom.clear();

        for (Edge x : invert) {
            //  System.out.println("cameFrom = " + x);
            cameFrom.add(x);
        }

        return cameFrom;
    }

    public void cellGoTo(Cell cell,LinkedList<Edge> path) {
        LinkedList<Edge> invertPath = new LinkedList<>();
        while (!path.isEmpty()) {
            // System.out.println("InvertPath = " + path.getLast());
            invertPath.add(path.getLast());
            path.removeLast();
        }
        for (Edge x : invertPath) {
            System.out.println("X = " + x);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int number = findCell(x.getEndCell().getNumberOnCell());
            if (x.getEndCell().getUpCell().getNumberOnCell() == 0) {
                Game.board.getCellsList().get(number).changeUp();
            }
            if (x.getEndCell().getDownCell().getNumberOnCell() == 0) {
                Game.board.getCellsList().get(number).changeDown();
            }
            if (x.getEndCell().getLeftCell().getNumberOnCell() == 0) {
                Game.board.getCellsList().get(number).changeLeft();
            }
            if (x.getEndCell().getRightCell().getNumberOnCell() == 0) {
                Game.board.getCellsList().get(number).changeRight();
            }
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cell.clickChange();
        System.out.println("Путь пройден");
    }

}

/*

   for (Cell x : Game.board.getCellsList()) { //Обход доски для каждой клетки
            System.out.println();
            System.out.println("  " + x.getUpCell().getNumberOnCell());
            System.out.println(x.getLeftCell().getNumberOnCell() + " " + x.getNumberOnCell() + " " + x.getRightCell().getNumberOnCell());
            System.out.println("  " + x.getDownCell().getNumberOnCell());
        }


        //-----------------------------------------------------------
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


        number2!:

                for (Edge x : edgesList) {
            if (x.getBeginCell() == start && !x.isWasVisited()) {
                if (x.getEndCell().getNumberOnCell() == end.getNumberOnCell()) {
                    System.out.println("Путь найден");
                    cameFrom.add(x);
                    return cameFrom;
                } else {
                    x.setWasVisited(true);
                    edgesStack.insert(x);
                    System.out.println(x);
                }
            }
        }
        System.out.println("Новый лист завершен");
        while (!edgesStack.isEmpty()) {
            Edge currentEdge = edgesStack.remove();
            System.out.println("CurrentEdge = " + currentEdge);

            for (Edge x : edgesList) {
                int w = 4;
                if (currentEdge.getEndCell().getNumberOnCell() == x.getBeginCell().getNumberOnCell() && !x.isWasVisited()) {
                    x.setWasVisited(true);
                    edgesStack.insert(x);
                    x.setWeight(++w);
                }
            }
            if (currentEdge.getEndCell().getNumberOnCell() == end.getNumberOnCell() || currentEdge.getWeight() < Game.board.getCells()+Game.board.getCells()/2) {
                cameFrom.add(currentEdge);
            }
        }

 */