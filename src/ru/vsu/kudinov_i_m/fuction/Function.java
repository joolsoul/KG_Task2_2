package ru.vsu.kudinov_i_m.fuction;

import ru.vsu.kudinov_i_m.Parameters;

public abstract class Function
{
    protected int numberOfParameters;
    protected Parameters parameters;
    protected String stringFunction;

    public abstract double calculateFunctionPoint(double x);

    public Parameters getParameters()
    {
        return parameters;
    }

    public void setParameters(Parameters parameters)
    {
        this.parameters = parameters;
    }

    public int getNumberOfParameters()
    {
        return numberOfParameters;
    }

    public void setNumberOfParameters(int numberOfParameters)
    {
        this.numberOfParameters = numberOfParameters;
    }

    public String getStringFunction()
    {
        return stringFunction;
    }

    public void setStringFunction(String stringFunction)
    {
        this.stringFunction = stringFunction;
    }

    @Override
    public String toString()
    {
        return stringFunction;
    }
}
