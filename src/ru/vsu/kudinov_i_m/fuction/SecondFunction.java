package ru.vsu.kudinov_i_m.fuction;

public class SecondFunction extends Function
{
    public SecondFunction()
    {
        numberOfParameters = 4;
        stringFunction = "y = A*x^3 + B*x^2 + C*x + D";

    }

    @Override
    public double calculateFunctionPoint(double x)
    {
        double A = parameters.getCoefficients().get('A');
        double B = parameters.getCoefficients().get('B');
        double C = parameters.getCoefficients().get('C');
        double D = parameters.getCoefficients().get('D');

        return A*Math.pow(x, 3) + B*Math.pow(x, 2) + C*x + D;
    }
}
