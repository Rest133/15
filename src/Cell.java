import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class Cell extends JComponent implements MouseListener, MouseMotionListener {

    private Font font = new Font("TimesRoman", Font.BOLD, 50);
    private int NumberOnCell;
    private Cell LeftCell, RightCell, UpCell, DownCell;
    private boolean hasO = false;
    static Cell NO_NEIGHBOUR = new Cell(-1);
    private boolean mousePressed = false;

    Cell(int n) {
        NumberOnCell = n;
        this.addMouseListener(this);
    }

    public void setLeftCell(Cell leftCell) {
        LeftCell = leftCell;
    }

    public void setRightCell(Cell rightCell) {
        RightCell = rightCell;
    }

    public void setUpCell(Cell upCell) {
        UpCell = upCell;
    }

    public void setDownCell(Cell downCell) {
        DownCell = downCell;
    }

    public int getNumberOnCell() {
        return NumberOnCell;
    }

    public Cell getLeftCell() {
        return LeftCell;
    }

    public Cell getRightCell() {
        return RightCell;
    }

    public Cell getUpCell() {
        return UpCell;
    }

    public Cell getDownCell() {
        return DownCell;
    }

    public boolean canChange() {
        if ((getLeftCell().getNumberOnCell() == 0 || getRightCell().getNumberOnCell() == 0
                || getUpCell().getNumberOnCell() == 0 || getDownCell().getNumberOnCell() == 0)) hasO = true;
        return hasO;
    }

    public void changeLeft(Cell this) {
        if (getLeftCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getLeftCell().getNumberOnCell();
            getLeftCell().NumberOnCell = num;
        }
        repaint();
        this.getLeftCell().repaint();
    }

    public void changeRight(Cell this) {
        if (getRightCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getRightCell().getNumberOnCell();
            getRightCell().NumberOnCell = num;
        }
        repaint();
        this.getRightCell().repaint();
    }

    public void changeUp(Cell this) {
        if (getUpCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getUpCell().getNumberOnCell();
            getUpCell().NumberOnCell = num;
        }
        repaint();
        this.getUpCell().repaint();
    }

    public void changeDown(Cell this) {
        if (getDownCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getDownCell().getNumberOnCell();
            getDownCell().NumberOnCell = num;
        }
        repaint();
        this.getDownCell().repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect(0, 0, 128, 128);
        g.setFont(font);
        if (this.getNumberOnCell() != 0) g.drawString(this.NumberOnCell + "", 50,  80);
    }

    //-----------------------------------------------------------------

    public void mouseClicked(MouseEvent me) {
        if (canChange()&& mousePressed) {
            this.changeRight();
            this.changeLeft();
            this.changeUp();
            this.changeDown();
        }
        System.out.println("Mouse clicked."); // Произведен щелчок кнопкой мыши
    }

    // обработать событие наведения курсора мыши
    public void mouseEntered(MouseEvent me) {
        System.out.println("Курсор на ячейки со значением: " + NumberOnCell); // Курсор наведен
    }

    // обработать событие отведения курсора мыши
    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        mousePressed = true;
    }

    public void mouseReleased(MouseEvent me) {
        mousePressed = false;
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {
    }
}
