package ru.vsu.fedosova_p_o.factory;

import ru.vsu.fedosova_p_o.Parameters;

import java.util.LinkedHashMap;
;
import java.util.Map;

public class Function1 extends FunctionDescription{


    public Function1() {
        startCoef.put("A", 1.0);
        startCoef.put("W", 12.0);
        startCoef.put("F", -1000.0);
        startCoef.put("C", 2.0);
        setDefaultCoeff();
    }

    @Override
    public String getFunctionName() {
        return "y = A*sin(W*x + F) + C";
    }

    @Override
    public double compute(double x) {
        return get("A")*Math.sin(get("W") * x + get("F")) + get("C");
    }
}
