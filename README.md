# Задача 3

  Цель: познакомиться с основами 2D графики; познакомиться с применением Аффинных преобразований и использованием упрощённой модели с Экранным и Реальным прямоугольниками.

  Задание: разработать приложение согласно варианту. Большинство заданий сводится к разработке 2D редакторов или 2D обозревателей двумерного мира.
____
  Создать приложение, демонстрирующее выполнение аффинных преобразований на плоскости, на примере фигуры -- ромб и (*) на примере эллипса (В качестве усложнённого варианта). Предполагается разработка гибкой архитектуры, где каждое преобразование будет наследоваться от какого-то базового интерфейса с объявленной функцией трансформации точки. Далее потребуется сделать инструмент, который бы прозрачно для основной программы, рисующей фигуру, применял эти преобразования к точкам перед их фактическим выводом на экран. Для этого потребуется создать интерфейс IAffine, в котором будет объявлен метод преобразования точки. После этого потребуется реализовать несколько классов для каждого преобразования. Далее можно сделать класс, который будет также наследоваться от IAffine и хранить в себе другие преобразования (паттерн компоновщик). Ромб стоит унаследовать от какой-то IFigure. Далее где-то написать класс/метод, который бы умел рисовать список фигур с применением указанного Аффинного преобразования. Таким образом, можно получить приложение, которому всё равно, какие фигуры рисуются и с применением каких преобразований (в т.ч. не будет важен порядок). В пользовательском интерфейсе должна быть возможность по настройке порядка и параметров применяемых преобразований.
