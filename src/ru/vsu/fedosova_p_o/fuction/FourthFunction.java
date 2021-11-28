package ru.vsu.fedosova_p_o.fuction;

public class FourthFunction extends Function
{
    public FourthFunction()
    {
        stringFunction = "y = A*sin(B*x + C)*(e^(-x/D))+E";

        numberOfParameters = 5;
    }

    @Override
    public double calculateFunctionPoint(double x)
    {
        double A = parameters.getCoefficients().get("A");
        double B = parameters.getCoefficients().get("B");
        double C = parameters.getCoefficients().get("C");
        double D = parameters.getCoefficients().get("D");
        double E = parameters.getCoefficients().get("E");

        return A * Math.sin(B * x + C) * (Math.pow(Math.E, -x/D)) + E;
    }
}
