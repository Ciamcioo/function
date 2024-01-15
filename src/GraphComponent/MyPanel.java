package GraphComponent;

import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable{
    private String title;
    private JLabel titleOfPanel = new JLabel();
    private Canva canva;  
    

    public MyPanel(String title, int ampitude, int frequency, int fullFilment) {
        this.title = title;
        initlizePanel(ampitude, frequency, fullFilment);
        Thread thread = new Thread(this);
        thread.start();
        
    }

    public void run() {
            canva.repaint();
            // canva.calculateNextPoints();
    }
    
    private void initlizePanel(int amp, int fre, int fullFil) {
        setSize(300, 500);;
        setLayout(new BorderLayout());
        setGraphTitle();
        setCanva(amp, fre, fullFil);
    }

    private void setGraphTitle() {
       titleOfPanel.setText(title); 
       titleOfPanel.setAlignmentX(CENTER_ALIGNMENT);
       titleOfPanel.setAlignmentY(CENTER_ALIGNMENT);
       add(titleOfPanel, BorderLayout.NORTH);
    }

    private void setCanva(int amp, int fre, int fullFil) {
        canva = new Canva(amp, fre, fullFil);
        canva.setBackground(Color.LIGHT_GRAY);
        add(canva, BorderLayout.CENTER);
    }
}
