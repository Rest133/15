import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class Cell extends JComponent implements MouseListener, MouseMotionListener {
    static Cell NO_NEIGHBOUR = new Cell(-1);

    private int numberOnCell;
    private Cell leftCell, rightCell, upCell, downCell;
    private boolean mousePressed = false;
    private boolean untouchable = false;

    private Font font = new Font("TimesRoman", Font.BOLD, 50);

    Cell(int n) {
        numberOnCell = n;
        this.addMouseListener(this);
    }

    public void setLeftCell(Cell lCell) {
        this.leftCell = lCell;
    }

    public void setRightCell(Cell rCell) {
        this.rightCell = rCell;
    }

    public void setUpCell(Cell uCell) {
        this.upCell = uCell;
    }

    public void setDownCell(Cell dCell) {
        this.downCell = dCell;
    }

    public void setUntouchable(boolean untouchable) {
        if (this.getNumberOnCell() != 0) this.untouchable = untouchable;
    }

    public int getNumberOnCell() {
        return numberOnCell;
    }

    public Cell getLeftCell() {
        return leftCell;
    }

    public Cell getRightCell() {
        return rightCell;
    }

    public Cell getUpCell() {
        return upCell;
    }

    public Cell getDownCell() {
        return downCell;
    }

    public boolean isUntouchable() {
        return untouchable;
    }

    public void clickChange(Cell this) {
        if (!untouchable) {
            int num = numberOnCell;
            if (getUpCell().getNumberOnCell() == 0) {
                numberOnCell = this.getUpCell().getNumberOnCell();
                getUpCell().numberOnCell = num;
                this.getUpCell().repaint();

            } else if (getDownCell().getNumberOnCell() == 0) {
                numberOnCell = this.getDownCell().getNumberOnCell();
                getDownCell().numberOnCell = num;
                this.getDownCell().repaint();

            } else if (getRightCell().getNumberOnCell() == 0) {
                numberOnCell = this.getRightCell().getNumberOnCell();
                getRightCell().numberOnCell = num;
                this.getRightCell().repaint();

            } else if (getLeftCell().getNumberOnCell() == 0) {
                numberOnCell = this.getLeftCell().getNumberOnCell();
                getLeftCell().numberOnCell = num;
                this.getLeftCell().repaint();
            }
        }
        repaint();
    } // улучшить

    //-------------------------------------------------------Команды для бота(Нужны ли?)
    public void changeRight(Cell this) {
        int num = numberOnCell;
        if (getRightCell().getNumberOnCell() == 0) {
            numberOnCell = this.getRightCell().getNumberOnCell();
            getRightCell().numberOnCell = num;
            this.getRightCell().repaint();
        }
        repaint();
    }

    public void changeLeft(Cell this) {
        int num = numberOnCell;
        if (getLeftCell().getNumberOnCell() == 0) {
            numberOnCell = this.getLeftCell().getNumberOnCell();
            getLeftCell().numberOnCell = num;
            this.getLeftCell().repaint();
        }
        repaint();
    }

    public void changeUp(Cell this) {
        int num = numberOnCell;
        if (getUpCell().getNumberOnCell() == 0) {
            numberOnCell = this.getUpCell().getNumberOnCell();
            getUpCell().numberOnCell = num;
            this.getUpCell().repaint();
        }
        repaint();
    }

    public void changeDown(Cell this) {
        int num = numberOnCell;
        if (getDownCell().getNumberOnCell() == 0) {
            numberOnCell = this.getDownCell().getNumberOnCell();
            getDownCell().numberOnCell = num;
            this.getDownCell().repaint();
        }
        repaint();
    }

//-------------------------------------------------------

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawRect(0, 0, 128, 128);
        g.setFont(font);
        if (this.getNumberOnCell() != 0) g.drawString(this.numberOnCell + "", 50, 80);
    }

//----------------------------------------------------------------- убрать

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        //  System.out.println("Курсор на ячейке со значением: " + NumberOnCell); // Курсор наведен
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        mousePressed = true;
        if (mousePressed) {
            this.clickChange();
        }
    }

    public void mouseReleased(MouseEvent me) {
        mousePressed = false;
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {
    }
}
