package ru.vsu.fedosova_p_o;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Parameters
{
    private Map<String, Double> coefficients;

    public Parameters(Map<String, Double> coefficients)
    {
        this.coefficients = coefficients;
    }

    public Parameters() {
    }

    public Double get(String coefficient) {
        return coefficients.get(coefficient);
    }

    public Map<String, Double> getCoefficients()
    {
        return coefficients;
    }

    public List<String> getCoefficientsList(){
        List<String> parameters = new LinkedList<>();
        for(Map.Entry<String, Double> entry : coefficients.entrySet()) {
            parameters.add(entry.getKey());
        }
        return parameters;
    }

    public void setCoefficients(Map<String, Double> coefficients)
    {
        this.coefficients = coefficients;
    }
}
