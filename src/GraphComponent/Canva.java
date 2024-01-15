package GraphComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Canva extends JPanel{
    private int ampitude, frequency, fullFilment;
    private boolean functionState = false;
    private Point previousePoint = new Point(0,400), currentPoint;

    public Canva(int amp, int fre, int fullFil) {
        ampitude = amp;
        frequency = fre;
        fullFilment = fullFil;
        currentPoint = new Point(previousePoint.x + (fullFilment/100) * frequency * 100, previousePoint.y);
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
        g.drawLine(0,getHeight()/2, getWidth()-10, getHeight()/2); 
        g.drawLine(getWidth()/2, 10, getWidth()/2,getHeight());
        setPoints(g);
    }

    private void setPoints(Graphics g) {
        for (int x = 0; x <= getWidth() - 10; x += 20) 
           drawPoint(g, x, getHeight()/2); 
        for (int y = 10; y <= getHeight(); y += 20) 
            drawPoint(g, getWidth()/2, y);
         
    }
    
    private void drawPoint(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillRect(x - 2, y - 2, 4, 4); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawAxics(g);
        g.setColor(Color.RED);
        g.drawLine(previousePoint.x, previousePoint.y, currentPoint.x, currentPoint.y);
    }
}
