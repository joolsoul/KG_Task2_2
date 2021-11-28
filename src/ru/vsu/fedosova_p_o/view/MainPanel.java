package ru.vsu.fedosova_p_o.view;

import ru.vsu.fedosova_p_o.*;
import ru.vsu.fedosova_p_o.factory.Function1;
import ru.vsu.fedosova_p_o.factory.Function2;
import ru.vsu.fedosova_p_o.factory.FunctionDescription;
import ru.vsu.fedosova_p_o.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener, Parameterizable
{
    private ScreenConverter screenConverter;

    private Line xAxis, yAxis;

    private Font defaultFont = new Font("TimesRoman", Font.PLAIN, 18);

    private ScreenPoint prevPoint = null; //for movements

    private Graph currentGraph;

    private static final double SCALE_STEP = 0.1;


    public MainPanel()
    {
        setLayout(null);

        currentGraph = new Graph(new Function2());

        screenConverter = new ScreenConverter(-2, 2, 4, 4, 800, 600);
        xAxis = new Line(new RealPoint(-2, 0), new RealPoint(2, 0));
        yAxis = new Line(new RealPoint(0, -1), new RealPoint(0, 1));

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
    }

    @Override
    public void paintComponent(Graphics originalGraphics) {
        screenConverter.setScreenWidth(this.getWidth());
        screenConverter.setScreenHeight(this.getHeight());

        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());

        DrawUtils.drawWithColor(graphics2D, Color.BLACK, () -> {
            updateAxes();
            xAxis.draw(graphics2D, screenConverter);
            yAxis.draw(graphics2D, screenConverter);
            drawAxisScale(graphics2D);
        });

        graphics2D.setColor(Color.BLUE);
        currentGraph.draw(graphics2D, screenConverter);
        originalGraphics.drawImage(bufferedImage, 0 , 0, null);
        graphics2D.dispose();
    }

    private void updateAxes() {
        xAxis.setPoint1(new RealPoint(screenConverter.getStartX(), 0));
        xAxis.setPoint2(new RealPoint(screenConverter.getStartX() + screenConverter.getRealWidth(), 0));

        yAxis.setPoint1(new RealPoint(0, screenConverter.getStartY()));
        yAxis.setPoint2(new RealPoint(0, screenConverter.getStartY() - screenConverter.getRealHeight()));
    }

    private void drawAxisScale(Graphics2D graphics2D) {
        drawAxisScaleX(graphics2D);
        drawAxisScaleY(graphics2D);
    }

    private void drawAxisScaleX(Graphics2D graphics2D) {
        int leftRealBound = (int) screenConverter.getStartX();
        int rightRealBound = (int) Math.ceil(screenConverter.getStartX() + screenConverter.getRealWidth());

        double firstLinePointY;
        double secondLinePointY;

        double textXShift;
        double textYShift;

        if (screenConverter.getStartY() > 0) { // если мы просматриваем выше Ох
            if (screenConverter.getStartY() < screenConverter.getRealHeight()) { // если ось в поле зрения
                firstLinePointY = -0.05;
                secondLinePointY = 0.05;

            }
            else {
                firstLinePointY = screenConverter.getStartY() - screenConverter.getRealHeight();
                secondLinePointY = firstLinePointY + 0.2;

            }
            textXShift = 0.04;
            textYShift = 0.06;
        }
        else { // если мы просматриваем ниже Ох
            firstLinePointY = screenConverter.getStartY();
            secondLinePointY = firstLinePointY - 0.2;

            textXShift = 0.04;
            textYShift = -0.1;
        }
        for (int i = leftRealBound; i <= rightRealBound; i++) {
            new Line(new RealPoint(i, firstLinePointY), new RealPoint(i, secondLinePointY))
                    .draw(graphics2D, screenConverter);
            new Text(Integer.toString(i), this.defaultFont, new RealPoint(i + textXShift, firstLinePointY + textYShift))
                    .draw(graphics2D, screenConverter);
        }
    }

    private void drawAxisScaleY(Graphics2D graphics2D) {
        int upRealBound = (int) Math.ceil(screenConverter.getStartY());
        int downRealBound = (int) (screenConverter.getStartY() - screenConverter.getRealHeight());

        double firstLinePointX;
        double secondLinePointX;

        double textXShift;
        double textYShift;

        if (screenConverter.getStartX() < 0) { // если мы просматриваем левее Оу
            if (screenConverter.getStartX() > -screenConverter.getRealWidth()) { // если ось в поле зрения
                firstLinePointX = -0.05;
                secondLinePointX = 0.05;
            }
            else { // если ось в поле зрения
                firstLinePointX = screenConverter.getStartX() + screenConverter.getRealWidth();
                secondLinePointX = screenConverter.getStartX() + screenConverter.getRealWidth() - 0.1;
            }
            textXShift = -0.06;
            textYShift = 0.01;
        }
        else { // если мы просматриваем правее Оу
            firstLinePointX = screenConverter.getStartX();
            secondLinePointX = screenConverter.getStartX() + 0.1;

            textXShift = 0.04;
            textYShift = 0.06;
        }

        for (int i = downRealBound; i <= upRealBound; i++) {
            new Line(new RealPoint(firstLinePointX, i), new RealPoint(secondLinePointX, i)).draw(graphics2D, screenConverter);
            if(i != 0)
            new Text(Integer.toString(i), this.defaultFont, new RealPoint(firstLinePointX + textXShift, i + textYShift)).draw(graphics2D, screenConverter);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        ConfigWindow configWindow = new ConfigWindow((int) (getWidth() / 1.5), (int) (getHeight() / 1.5), this);
        configWindow.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        prevPoint = new ScreenPoint(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        prevPoint = null;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        ScreenPoint currentPoint = new ScreenPoint(e.getX(), e.getY());
        RealPoint point1 = screenConverter.screenToReal(currentPoint);
        RealPoint point2 = screenConverter.screenToReal(prevPoint);

        RealPoint delta = point2.minus(point1);
        screenConverter.moveStartPoint(delta);

        prevPoint = currentPoint;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int wheelRotation = e.getWheelRotation();
        double coefficient = 1 + SCALE_STEP * (wheelRotation < 0 ? -1 : 1);
        double scale = 1;

        for (int i = Math.abs(wheelRotation); i > 0; i--)
        {
            scale *= coefficient;
        }

        screenConverter.changeScale(scale);
        defaultFont = defaultFont.deriveFont((float) (defaultFont.getSize() / scale));
        repaint();
    }

    @Override
    public FunctionDescription getFunction()
    {
        Class<? extends FunctionDescription> functionClass = currentGraph.getFunction().getClass();
        FunctionDescription copy = null;
        try
        {
            copy = functionClass.newInstance();
            copy.setParameters(new Parameters(currentGraph.getFunction().getParameters().getCoefficients()));
        } catch (InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return copy;
    }

    @Override
    public void setFunction(FunctionDescription function)
    {
        this.currentGraph.setFunction(function);
        repaint();
    }
}
