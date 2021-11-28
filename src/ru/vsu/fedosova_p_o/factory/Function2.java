package ru.vsu.fedosova_p_o.factory;

import ru.vsu.fedosova_p_o.Parameters;

import java.util.LinkedHashMap;
import java.util.Map;

public class Function2 extends FunctionDescription{

    public Function2() {
        startCoef.put("A1", 1.0);
        startCoef.put("W1", 12.0);
        startCoef.put("F1", -1000.0);
        startCoef.put("A2", 2.0);
        startCoef.put("W2", 2.0);
        startCoef.put("F2", 2.0);
        startCoef.put("C2", 2.0);
        startCoef.put("C1", 2.0);
        setDefaultCoeff();
    }

    @Override
    public String getFunctionName() {
        return "y = A1*sin(W1*x + F1)*(A2*cos(W2*x + F2)+C2) + C1";
    }

    @Override
    public double compute(double x) {
        return get("A1") * Math.sin(get("W1") * x + get("F1")) * (get("A2") * Math.cos(get("W2") * x + get("F2")) + get("C2")) + get("C1");
    }
}
