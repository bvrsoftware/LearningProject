package com.bvr.jts.helper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTSVisualisationPanel extends JPanel {
    private List<DrawingCommand> drawPathCommand = new ArrayList<>();

    public JTSVisualisationPanel(){
        setSize(1000, 800);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.darkGray);

        g.fillRect(0, 0, 1000, 800);

        g.setColor(Color.WHITE);

        g.fillRect(10, 10, 4, 4);

        g.drawLine(10, 10, 10, 800);

        g.drawLine(10, 10, 1000, 10);

        for(int i = 10; i <= 1000; i += 50) {

            g.drawString(Integer.toString(i), i, 10);

            g.drawString(Integer.toString(i), 10, i);
        }

        g.setColor(Color.BLACK);

        for (DrawingCommand drawingCommand : drawPathCommand) {

            drawingCommand.doDrawing(g);
        }

    }
    public void addDrawCommand(DrawingCommand c) {
        this.drawPathCommand.add(c);
        this.repaint();
    }
}
