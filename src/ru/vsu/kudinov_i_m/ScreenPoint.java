package ru.vsu.kudinov_i_m;

public class ScreenPoint
{
    private final int screenX;
    private final int screenY;
    private boolean isUndefined = false;

    public ScreenPoint(int screenX, int screenY)
    {
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public int getScreenX()
    {
        return screenX;
    }

    public int getScreenY()
    {
        return screenY;
    }

    public boolean isUndefined() {
        return isUndefined;
    }

    public void setUndefined(boolean undefined) {
        isUndefined = undefined;
    }
}
