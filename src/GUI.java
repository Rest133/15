import javax.swing.*;
import java.awt.*;
public class GUI extends Canvas{

    private JFrame jFrame;
    private JPanel jPanel = new JPanel();

    public GUI() {
        jFrame = new JFrame("Пятнашки");
        jFrame.setBackground(Color.DARK_GRAY);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(this);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(Game.board.getCells() * 128, Game.board.getCells() * 128);
        jFrame.add(jPanel);

        jPanel.setLayout(new GridLayout(Game.board.getCells(), Game.board.getCells()));
        jPanel.setBackground(Color.GRAY);

        for (Cell x : Game.board.getCellsList()) {
            jPanel.add(x);
        }
    }

    public void disposeGui(){
        this.jFrame.setVisible(false);
        this.jFrame.dispose();
    }

}

