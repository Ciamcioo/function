package GraphComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Canva extends JPanel{
    private int ampitude, frequency, fullFilment;
    private boolean functionState = false;
    private Point previousePoint = new Point(0,400), currentPoint = new Point (100, 400);

    public Canva(int amp, int fre, int fullFil) {
        ampitude = amp;
        frequency = fre;
        fullFilment = fullFil;
    }
    public void calculateProblem() {
        previousePoint = currentPoint;
        currentPoint.y = previousePoint.y + ampitude;
    }

    // No tutaj coś się wypierdala 
    public void calculateNextPoints() {
        if (previousePoint.y == currentPoint.y) {
            previousePoint = currentPoint;
            if (functionState)
                currentPoint.x  = previousePoint.x + (fullFilment/100) * frequency;
            else
                currentPoint.x = previousePoint.x + ((100 - fullFilment)/100) * 100;
        }
        else {
            previousePoint = currentPoint;
            if (functionState)
                currentPoint.y = previousePoint.y - ampitude;
            else
                currentPoint.y = previousePoint.y + ampitude;
            functionState = !functionState;
        }
    }

    private void drawAxics(Graphics g) {
        g.drawLine(0,getHeight()/4*3, getWidth()-5, getHeight()/4*3); 
        g.drawLine(getWidth()/2, 5, getWidth()/2,getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawAxics(g);
        g.setColor(Color.RED);
        g.drawLine(previousePoint.x, previousePoint.y, currentPoint.x, currentPoint.y);
    }
}
