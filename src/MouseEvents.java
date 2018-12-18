import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class MouseEvents implements MouseListener, MouseMotionListener {//доделать
    int mouseX = 0, mouseY = 0; // координаты курсора мыши

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    // обработать событие от щелчка кнопкой мыши
    public void mouseClicked(MouseEvent me) {
        // сохранить координаты
        mouseX = 0;
        mouseY = 10;
        System.out.println("Mouse clicked."); // Произведен щелчок кнопкой мыши
    }
    // обработать событие наведения курсора мыши
    public void mouseEntered(MouseEvent me) {
        // сохранить координаты
        mouseX = 0;
        mouseY = 10;
        System.out.println("Mouse entered."); // Курсор наведен
    }

    // обработать событие отведения курсора мыши
    public void mouseExited(MouseEvent me) {
        // сохранить координаты
        mouseX = 0;
        mouseY = 10;
        System.out.println("Mouse exited."); // Курсор отведен
    }

    // обработать событие нажатия кнопки мыши
    public void mousePressed(MouseEvent me) {
        // сохранить координаты
        mouseX = me.getX();
        mouseY = me.getY();
        System.out.println("Down"); // Кнопка мыши нажата
    }

    // обработать событие отпускания кнопки мыши
    public void mouseReleased(MouseEvent me) {
        // сохранить координаты
        mouseX = me.getX();
        mouseY = me.getY();
        System.out.println("Up"); // Кнопка мыши отпущена
    }

    // обработать событие перетаскивания курсора мыши
    public void mouseDragged(MouseEvent me) {
    }

    // обработать событие перемещения мыши
    public void mouseMoved(MouseEvent me) {
        // показать состояние
        System.out.println("Moving mouse at " + me.getX() + ", " + me.getY());
        // Перемещение курсора мыши в точку с указанными координатами
    }
}