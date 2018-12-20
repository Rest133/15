import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class Cell extends JComponent implements MouseListener, MouseMotionListener {
    static Cell NO_NEIGHBOUR = new Cell(-1, Integer.MAX_VALUE);

    private int mass;
    private int numberOnCell;
    private Cell cameFromNeighbour = null;
    private Cell leftCell, rightCell, upCell, downCell;
    private boolean hasO = false; //пригодится или нет?
    private boolean mousePressed = false;
    private boolean wasVisited = false;

    private Font font = new Font("TimesRoman", Font.BOLD, 50);

    Cell(int n, int m) {
        numberOnCell = n;
        this.addMouseListener(this);
        mass = m;
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

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setCameFromNeighbour(Cell algorithmNeighbour) {
        this.cameFromNeighbour = algorithmNeighbour;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public int getNumberOnCell() {
        return numberOnCell;
    }

    public int getMass() {
        return mass;
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

    public Cell getСameFromNeighbour() {
        return cameFromNeighbour;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public boolean canChange() {
        if ((getLeftCell().getNumberOnCell() == 0 || getRightCell().getNumberOnCell() == 0
                || getUpCell().getNumberOnCell() == 0 || getDownCell().getNumberOnCell() == 0)) hasO = true;
        return hasO;
    }

    public void clickChange(Cell this) {
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
        repaint();
    } // улучшить
//-------------------------------------------------------Команды для бота
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
        if (canChange() && mousePressed) {
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
