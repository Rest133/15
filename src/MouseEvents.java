import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class MouseEvents implements MouseListener, MouseMotionListener {//доделать
    private boolean mousePressed = false;
    static Cell cell;

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    public void mouseClicked(MouseEvent me) {
        System.out.println("Mouse clicked!!!");
    }

    public void mouseEntered(MouseEvent me) {
        //  System.out.println("Курсор на ячейке со значением: " + NumberOnCell); // Курсор наведен
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        mousePressed = true;
        if (cell.canChange() && mousePressed) {
            cell.change();
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