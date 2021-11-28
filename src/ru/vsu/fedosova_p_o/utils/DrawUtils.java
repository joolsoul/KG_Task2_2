package ru.vsu.fedosova_p_o.utils;

import java.awt.*;

public class DrawUtils {
    public static void drawWithFont(Graphics2D g, Font font, Runnable drawAction) {
        Font oldF = g.getFont();
        g.setFont(font);
        drawAction.run();
        g.setFont(oldF);
    }

    public static void drawWithColor(Graphics2D gr2d, Color color, Runnable drawAction) {
        Color oldC = gr2d.getColor();
        gr2d.setColor(color);
        drawAction.run();
        gr2d.setColor(oldC);
    }
}
