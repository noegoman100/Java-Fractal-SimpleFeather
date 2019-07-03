// Fractal user interface. MAIN
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

public class Fractal extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 480;
    private static final int MIN_LEVEL = 0;
    private static final int MAX_LEVEL = 15;
    
    // this sets up the GUI - No arg constructor
    public Fractal()
    {
        super("Fractal");
        
        final JLabel levelJLabel = new JLabel("Level: 0");
        final FractalJPanel drawSpace = new FractalJPanel(0);
        
        final JPanel controlJPanel = new JPanel();
        controlJPanel.setLayout(new FlowLayout());
        
        final JButton changeColorJButton = new JButton("Color");
        controlJPanel.add(changeColorJButton);
        changeColorJButton.addActionListener(
                new ActionListener() //anonymous inner class
                {
                    @Override
                    public void actionPerformed(ActionEvent event)
                    {
                        Color color = JColorChooser.showDialog(
                                Fractal.this, "Choose a color", Color.BLUE);
                        
                        if (color == null)
                            color = Color.BLUE;
                        
                        drawSpace.setColor(color);
                    }
                }//end anonymous inner class
        );
        

        final JButton increaseLevelJButton = new JButton("Increase Level");
        controlJPanel.add(increaseLevelJButton);
        increaseLevelJButton.addActionListener(
            new ActionListener() // anonymous inner class
            {
                // process increaseLevelJButton event
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    int level = drawSpace.getLevel();
                    ++level;


                // modify level if possible
                if ((level >= MIN_LEVEL) &&
                (level <= MAX_LEVEL))
                {
                    levelJLabel.setText("Level: " + level);
                    drawSpace.setLevel(level);
                    repaint();


                }
                }
            } // end anonymous inner class
        ); // end addActionListener
        
        controlJPanel.add(levelJLabel);
        
        final JPanel mainJPanel = new JPanel():
        mainJPanel.add(controlJPanel);
        mainJPanel.add(drawSpace);
        
        add(mainJPanel);
        
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    
    
    
    }//end Fractal constructor
    
    public static void main(String[] args)
    {
        Fractal demo = new Fractal();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} //end class Fractal (Main)