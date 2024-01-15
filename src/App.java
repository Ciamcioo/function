import java.awt.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import GraphComponent.MyPanel;

public class App {
    private JFrame appFrame = new JFrame();
    private MyPanel[] myPanel = new MyPanel[3];

    public App() {
        frameInitialization("Task");
        functionsInitalization();
        appFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
          new App();  
        });
    }

    private void frameInitialization(String title) {
        appFrame.setTitle(title);
        appFrame.setLayout(new GridLayout());
        appFrame.setSize(1200, 500);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void functionsInitalization() {
        myPanel[0] = new MyPanel("Function 1", 2, 1, 50);
        myPanel[1] = new MyPanel("Function 2", 3, 2, 20);
        myPanel[2] = new MyPanel("Result Function", 0, 0, 0);
        for (int i = 0; i < 3; i++)
            appFrame.add(myPanel[i]);     
    
    }
}
