import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JPanel jPanel = new JPanel();
    int y = 96;
    int x = -64;
    Timer timer = new Timer(1000 / 60, this::actionPerformed);

    public GUI() {
        super("Пятнашки");
        setSize(Game.ALL_CELL * 128, Game.ALL_CELL * 128 + 28);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setVisible(true);
        jPanel.setLayout(new GridLayout(Game.ALL_CELL, Game.ALL_CELL));
        add(jPanel);
        timer.start();
        for (Cell x : Game.cellsList) {
            jPanel.add(new JButton());
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        for (int x = 0; x < Game.ALL_CELL * 128; x += 128) {
            for (int y = 32; y < Game.ALL_CELL * 128; y += 128) {
                g.drawLine(x, 0, x, Game.ALL_CELL * 128 + 28);
                g.drawLine(0, y - 4, Game.ALL_CELL * 128, y - 4);
            }
        }
//-----------------------------------------------------Костыли
      /*  for (int i = 0; i < Game.ALL_CELL; i++) {
            g.drawString("" + Game.cellsList.get(i).getNumberOnCell(), x += 128, y);
        }
        x = -64;
        for (int i = 0; i < Game.ALL_CELL; i++) {
            g.drawString("" + Game.cellsList.get(i + Game.ALL_CELL).getNumberOnCell(), x += 128, y * 2);
        }
        x = -64;
        for (int i = 0; i < Game.ALL_CELL; i++) {
            g.drawString("" + Game.cellsList.get(i + Game.ALL_CELL * 2).getNumberOnCell(), x += 128, y * 4);
        }
        x = -64;
        for (int i = 0; i < Game.ALL_CELL; i++) {
            g.drawString("" + Game.cellsList.get(i + Game.ALL_CELL * 3).getNumberOnCell(), x += 128, y * 5);
        }*/
//------------------------------------------------------ Построение кнопок


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

