package GraphComponent;

import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import java.util.*;

public class Canva extends JPanel{
    private int ampitude, frequency, fullFilment;
    private boolean functionState = false;
    private Point previousePoint = new Point(0,getHeight()/2), currentPoint;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public Canva(int amp, int fre, int fullFil) {
        ampitude = amp;
        frequency = fre;
        fullFilment = fullFil;
        currentPoint = new Point(previousePoint.x + fullFilment * frequency / 10, previousePoint.y);
    }
    public void calculateProblem() {
        previousePoint = currentPoint;
        currentPoint.y = previousePoint.y + ampitude;
    }

    public void calculateNextPoints() {
        if (previousePoint.y == currentPoint.y) {
            previousePoint = currentPoint;
            if (functionState)
                currentPoint.x  = previousePoint.x + fullFilment * frequency /10;
            else
                currentPoint.x = previousePoint.x + (100 - fullFilment) * frequency / 10;
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
        g.setColor(Color.BLACK);
        g.fillRect(x - 2, y - 2, 4, 4); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        drawAxics(g);
        g.setColor(Color.RED);

        Line2D line = new Line2D.Double(previousePoint.x, previousePoint.y, currentPoint.x, currentPoint.y); 
        shapes.add(line);

        for (Shape shape : shapes) 
            g.drawLine((int) ((Line2D) shape).getX1(), (int) ((Line2D) shape).getY1(), (int) ((Line2D)shape).getX2(), (int) ((Line2D)shape).getY2());
    }
}
