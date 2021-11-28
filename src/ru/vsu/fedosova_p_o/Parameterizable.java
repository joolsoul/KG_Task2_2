package ru.vsu.fedosova_p_o;

import ru.vsu.fedosova_p_o.factory.FunctionDescription;
import ru.vsu.fedosova_p_o.fuction.Function;

public interface Parameterizable
{
    FunctionDescription getFunction();

    void setFunction(FunctionDescription function);
}
