package ru.vsu.fedosova_p_o.fuction;

public class FirstFunction extends Function
{
    public FirstFunction()
    {
        stringFunction = "y = A*sin(B*x + C) + D";

        numberOfParameters = 4;
    }

    @Override
    public double calculateFunctionPoint(double x)
    {
        double A = parameters.getCoefficients().get('A');
        double B = parameters.getCoefficients().get('B');
        double C = parameters.getCoefficients().get('C');
        double D = parameters.getCoefficients().get('D');

        return A*Math.sin(B * x + C) + D;
    }

}
