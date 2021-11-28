package ru.vsu.fedosova_p_o.fuction;

public class ThirdFunction extends Function
{
    public ThirdFunction()
    {
        stringFunction = "y = A*sin(B*x + C)*(D*cos(E*x + F)+G) + H";

        numberOfParameters = 8;
    }

    @Override
    public double calculateFunctionPoint(double x)
    {
        double A = parameters.getCoefficients().get('A');
        double B = parameters.getCoefficients().get('B');
        double C = parameters.getCoefficients().get('C');
        double D = parameters.getCoefficients().get('D');
        double E = parameters.getCoefficients().get('E');
        double F = parameters.getCoefficients().get('F');
        double G = parameters.getCoefficients().get('G');
        double H = parameters.getCoefficients().get('H');

        return A * Math.sin(B * x + C) * (D * Math.cos(E * x + F) + G) + H;
    }
}
