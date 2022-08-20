package ru.vsu.kudinov_i_m;

public class ScreenConverter
{
    private double realWidth, realHeight;
    private int screenWidth, screenHeight;
    private double startX, startY;

    public ScreenConverter(double startX, double startY, double realWidth, double realHeight, int screenWidth, int screenHeight)
    {
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.startX = startX;
        this.startY = startY;
    }

    public ScreenPoint realToScreen(RealPoint realPoint)
    {
        double screenX = (realPoint.getRealX() - startX) / realWidth * screenWidth;
        double screenY = (startY - realPoint.getRealY()) / realHeight * screenHeight;

        return new ScreenPoint((int) screenX, (int) screenY);
    }

    public RealPoint screenToReal(ScreenPoint screenPoint)
    {
        double realX = startX + screenPoint.getScreenX() * realWidth / screenWidth;
        double realY = startY - screenPoint.getScreenY() * realHeight / screenHeight;

        return new RealPoint(realX, realY);
    }

    public void moveStartPoint(RealPoint delta)
    {
        startX += delta.getRealX();
        startY += delta.getRealY();
    }

    public void changeScale(double newScale)
    {
        double deltaX = (realWidth - realWidth * newScale) / 2;
        double deltaY = (realHeight - realHeight * newScale) / 2;
        startX += deltaX;
        startY -= deltaY;

        realWidth *= newScale;
        realHeight *= newScale;
    }


    public double getRealWidth()
    {
        return realWidth;
    }

    public void setRealWidth(double realWidth)
    {
        this.realWidth = realWidth;
    }

    public double getRealHeight()
    {
        return realHeight;
    }

    public void setRealHeight(double realHeight)
    {
        this.realHeight = realHeight;
    }

    public int getScreenWidth()
    {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth)
    {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight()
    {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight)
    {
        this.screenHeight = screenHeight;
    }

    public double getStartX()
    {
        return startX;
    }

    public void setStartX(double startX)
    {
        this.startX = startX;
    }

    public double getStartY()
    {
        return startY;
    }

    public void setStartY(double startY)
    {
        this.startY = startY;
    }
}
