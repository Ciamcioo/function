package GraphComponent;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Axi extends JPanel{
    private boolean isVertical;

    public Axi(boolean isVertical) {
        this.isVertical = isVertical;
        repaint();
        setVisible(true);
    }

    protected void paintCOmponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        if (isVertical)
           g.drawLine(width/2 , 0, width, height); 
           
        else
            g.drawLine(0, height/2, width, height);
    }
    
}
