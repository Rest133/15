import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JComponent implements MouseListener {
    private int NumberOnCell;
    private Cell LeftCell, RightCell, UpCell, DownCell;
    boolean hasO = false;
    static Cell NO_NEIGHBOUR = new Cell(-1);

    Cell(int n) {
        NumberOnCell = n;
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
    }
    public void changeRight(Cell this) {
        if (getRightCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getRightCell().getNumberOnCell();
            getRightCell().NumberOnCell = num;
        }
    }
    public void changeUp(Cell this) {
        if (getUpCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getUpCell().getNumberOnCell();
            getUpCell().NumberOnCell = num;
        }
    }
    public void changeDown(Cell this) {
        if (getDownCell().getNumberOnCell() == 0) {
            int num = NumberOnCell;
            NumberOnCell = this.getDownCell().getNumberOnCell();
            getDownCell().NumberOnCell = num;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
