package GraphComponent;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable{
    private String title;
    private JLabel titleOfPanel = new JLabel();
    private Canva canva;  
    private Axi x = new Axi(false), y = new Axi(true);
    

    public MyPanel(String title, int ampitude, int frequency, int fullFilment) {
        this.title = title;
        canva = new Canva(ampitude, frequency, fullFilment);  
        initlizePanel();
        Thread thread = new Thread(this);
        thread.start();
        
    }

    public void run() {
        setVisible(false);
        canva.repaint();
        setVisible(true);     
    }
    
    private void initlizePanel() {
        setSize(300, 500);;
        setLayout(new BorderLayout());
        setGraphTitle();
        add(canva, BorderLayout.CENTER);
        setAxis();
    }

    private void setGraphTitle() {
       titleOfPanel.setText(title); 
       titleOfPanel.setAlignmentX(CENTER_ALIGNMENT);
       titleOfPanel.setAlignmentY(CENTER_ALIGNMENT);
       add(titleOfPanel, BorderLayout.NORTH);
    }
        
    private void setAxis() {
        add(x, BorderLayout.WEST);
        add(y, BorderLayout.SOUTH);
    }
}
