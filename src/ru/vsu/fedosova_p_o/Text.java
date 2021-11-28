package ru.vsu.fedosova_p_o;

import ru.vsu.fedosova_p_o.utils.DrawUtils;

import java.awt.*;

public class Text implements DrawingObject {
    private final String text;
    private final RealPoint realCoordinates;
    private final Font font;

    public Text(String text, Font font, RealPoint realCoordinates) {
        this.text = text;
        this.realCoordinates = realCoordinates;
        this.font = font;
    }

    @Override
    public void draw(Graphics2D graphics2D, ScreenConverter screenConverter) {
        DrawUtils.drawWithFont(graphics2D, this.font, () -> {
            ScreenPoint screenCoordinates = screenConverter.realToScreen(this.realCoordinates);
            graphics2D.drawString(this.text, screenCoordinates.getScreenX(), screenCoordinates.getScreenY());
        });
    }
}
