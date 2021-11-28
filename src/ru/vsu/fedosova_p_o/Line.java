package ru.vsu.fedosova_p_o;

import java.awt.*;

public class Line implements DrawingObject
{
    private RealPoint point1, point2;

    public Line(RealPoint point1, RealPoint point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }

    public RealPoint getPoint1()
    {
        return point1;
    }

    public void setPoint1(RealPoint point1)
    {
        this.point1 = point1;
    }

    public RealPoint getPoint2()
    {
        return point2;
    }

    public void setPoint2(RealPoint point2)
    {
        this.point2 = point2;
    }

    @Override
    public void draw(Graphics2D graphics2D, ScreenConverter screenConverter) {
        ScreenPoint p1 = screenConverter.realToScreen(point1);
        ScreenPoint p2 = screenConverter.realToScreen(point2);
        graphics2D.drawLine(p1.getScreenX(), p1.getScreenY(), p2.getScreenX(), p2.getScreenY());
    }
}
