package ru.vsu.fedosova_p_o.view;

import ru.vsu.fedosova_p_o.Parameterizable;
import ru.vsu.fedosova_p_o.factory.FunctionDescription;

import javax.swing.*;


public class ConfigWindow extends JFrame
{
    private Parameterizable parameterizableProvider;
    private FunctionDescription currentFunction;

    public ConfigWindow(int width, int height, Parameterizable parameterizableProvider)
    {
        setTitle("Parameters");
        ImageIcon icon = new ImageIcon("resources/parametersIcon.png");
        setIconImage(icon.getImage());
        setSize(width, height);
        this.parameterizableProvider = parameterizableProvider;
        currentFunction = parameterizableProvider.getFunction();
        add(new ConfigPanel(this));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Parameterizable getParameterizableProvider()
    {
        return parameterizableProvider;
    }

    public void setParameterizableProvider(Parameterizable parameterizableProvider)
    {
        this.parameterizableProvider = parameterizableProvider;
        currentFunction = parameterizableProvider.getFunction();
    }

    public FunctionDescription getCurrentFunction()
    {
        return currentFunction;
    }

    public void setCurrentFunction(FunctionDescription currentFunction)
    {
        this.currentFunction = currentFunction;
    }

    public void onClick()
    {
        parameterizableProvider.setFunction(currentFunction);
    }

}
