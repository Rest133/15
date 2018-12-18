public class Algorithm {
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
                    System.out.println("+");
                    count++;
                }
            }
        }
        System.out.println("Сумма без нуля " + count);
        count += indexO / Game.board.getCells();
        System.out.println("Сумма с нулем " + count);
        if (count % 2 == 0) {
            System.out.println("Нерешаемая комбинация");
            Game.endGame = true;
        }
    }
}