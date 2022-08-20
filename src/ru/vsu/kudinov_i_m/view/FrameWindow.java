package ru.vsu.kudinov_i_m.view;

import javax.swing.*;

public class FrameWindow extends JFrame
{
    public FrameWindow()
    {
        setTitle("Function");
        ImageIcon icon = new ImageIcon("resources/appIcon.png");
        setIconImage(icon.getImage());
        setSize(1000, 800);
        add(new MainPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
