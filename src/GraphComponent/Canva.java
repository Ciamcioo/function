package GraphComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Objects;

import javax.swing.JPanel;

public class Canva extends JPanel{
    private int ampitude, frequency, fullFilment;
    private boolean functionState = false;
    private Point previousePoint = new Point(0,400), currentPoint;

    public Canva(int amp, int fre, int fullFil) {
        ampitude = amp;
        frequency = fre;
        fullFilment = fullFil;
        setBackground(Color.LIGHT_GRAY);
    }

    public void calculateNextPoints() {
        Point buffer = null;
        if (Objects.nonNull(currentPoint))
            buffer = currentPoint;
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.setColor(Color.RED); 
       g.drawLine(previousePoint.x, previousePoint.y, currentPoint.x, currentPoint.y);
    }
}
