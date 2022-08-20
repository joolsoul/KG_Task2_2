package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.factory.FunctionDescription;

public interface Parameterizable
{
    FunctionDescription getFunction();

    void setFunction(FunctionDescription function);
}
