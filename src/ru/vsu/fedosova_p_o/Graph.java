package ru.vsu.fedosova_p_o;

import ru.vsu.fedosova_p_o.factory.FunctionDescription;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph implements DrawingObject {


    private final double ACCURACY_MULTIPLIER = 10000;
    private final double STEP_DELTA = 5;
    private FunctionDescription function;

    public Graph(FunctionDescription function) {
        this.function = function;
    }

    public ArrayList<RealPoint> computeRealCoordinates(double leftRealBound, double rightRealBound, int n) {
        ArrayList<RealPoint> realCoordinates = new ArrayList<>();

        double step = (rightRealBound - leftRealBound) / (n - 1);
        for (int i = 0; i < n; i++) {

            double currRealVal = leftRealBound + i * step;

            double expressionResult;
            try {
                expressionResult = function.compute(currRealVal);
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            if (Double.isFinite(expressionResult)) {
                realCoordinates.add(new RealPoint(currRealVal, expressionResult));
            }
            else {
                realCoordinates.add(new RealPoint());
            }
        }
        return realCoordinates;
    }


    @Override
    public void draw(Graphics2D graphics2D, ScreenConverter screenConverter) {
        double leftRealBound = screenConverter.getStartX();
        double rightRealBound = leftRealBound + screenConverter.getRealWidth();
        ArrayList<RealPoint> realCoordinates = computeRealCoordinates(leftRealBound, rightRealBound, screenConverter.getScreenWidth() * 2);

        RealPoint currCoordinate = realCoordinates.get(0);
        for (int i = 1; i < realCoordinates.size(); i++) {
            RealPoint nextCoordinate = realCoordinates.get(i);
            if (!currCoordinate.isUndefined() && !nextCoordinate.isUndefined()) {
                ScreenPoint currScreenCoordinate = screenConverter.realToScreen(currCoordinate);
                ScreenPoint nextScreenCoordinate = screenConverter.realToScreen(nextCoordinate);
                graphics2D.drawLine(
                        currScreenCoordinate.getScreenX(), currScreenCoordinate.getScreenY(),
                        nextScreenCoordinate.getScreenX(), nextScreenCoordinate.getScreenY()
                );
            }
            currCoordinate = nextCoordinate;
        }
    }

    public FunctionDescription getFunction() {
        return function;
    }

    public void setFunction(FunctionDescription function) {
        this.function = function;
    }
}
