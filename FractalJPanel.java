//FractalJPanel.java

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel
{
    private Color color;
    private int level;
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    
    public FractalJPanel(int currentLevel) //1 arg constructor
    {
        color = Color.BLUE;
        level = currentLevel;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));        
    }
    
    public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g)
    {
        if (level == 0)
            g.drawLine(xA, yA, xB, yB);
        else // recursion step: determine new points, draw next level
        {
            // calculate midpoint between (xA, yA) and (xB, yB)
            int xC = (xA + xB) / 2;
            int yC = (yA + yB) / 2;
            // calculate the fourth point (xD, yD) which forms an
            // isosceles right triangle between (xA, yA) and (xC, yC)
            // where the right angle is at (xD, yD)
            int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
            int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
            // recursively draw the Fractal
            drawFractal(level - 1, xD, yD, xA, yA, g);
            drawFractal(level - 1, xD, yD, xC, yC, g);
            drawFractal(level - 1, xD, yD, xB, yB, g);
        }
    }
    
    //Draw the Fractal
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(color);
        drawFractal(level, 100, 90, 290, 200, g);
    }
    
    public void setColor(Color c)
    {
        color = c;
    }
    
    public void setLevel(int currentLevel)
    {
        level = currentLevel;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    
    
    
} //end class