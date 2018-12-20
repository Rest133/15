public class Game {
    static Board board;
    static boolean endGame;

    public static void main(String[] args) {
        Game game = new Game();
        game.createNewGame(4);
    }

    public void createNewGame(int cellBoard) {
        System.out.println("\nНовая игра");
        endGame = false;
        board = new Board(cellBoard);
        GUI gui = new GUI();
        Algorithm algorithm = new Algorithm();
        while (!endGame) {
           // Algorithm algorithm = new Algorithm();
            if (board.winGame()) {
                System.out.println("Вы выиграли");
                endGame = true;
                break;
            }
        }
        gui.disposeGui();
        if (endGame) createNewGame(cellBoard);
    }
}
