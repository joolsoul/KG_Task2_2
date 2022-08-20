package ru.vsu.kudinov_i_m.factory;

import ru.vsu.kudinov_i_m.Parameters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class FunctionDescription implements IFunction{

    protected Parameters parameters = new Parameters();
    protected Map<String, Double> startCoef = new LinkedHashMap<>();


    public abstract String getFunctionName();
    public List<String> getRequiredParameters() {
        return parameters.getCoefficientsList();
    }
    public double get(String name) {
        return parameters.get(name);
    }
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    public Parameters getParameters()
    {
        return parameters;
    }

    public void setDefaultCoeff() {
        this.parameters.setCoefficients(startCoef);
    }

}
