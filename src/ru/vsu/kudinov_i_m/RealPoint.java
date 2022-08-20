package ru.vsu.kudinov_i_m;

public class RealPoint
{
    private double realX, realY;
    private boolean isUndefined = false;

    public RealPoint(double x, double y)
    {
        this.realX = x;
        this.realY = y;
    }

    public RealPoint() {
        this(Double.NaN, Double.NaN);
        this.isUndefined = true;
    }

    public double getRealX()
    {
        return realX;
    }

    public void setRealX(double realX)
    {
        this.realX = realX;
    }

    public double getRealY()
    {
        return realY;
    }

    public void setRealY(double realY)
    {
        this.realY = realY;
    }

    public RealPoint minus(RealPoint realPoint)
    {
        return new RealPoint(this.getRealX() - realPoint.getRealX(), this.getRealY() - realPoint.getRealY());
    }

    public boolean isUndefined() {
        return isUndefined;
    }

    public void setUndefined(boolean undefined) {
        isUndefined = undefined;
    }
}
