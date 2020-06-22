package com.company;

interface Function{
    double call(double x);
}

public class Main {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 1, 10));
    }

    public static double integrate(Function f, double a, double b) {
        int i;
        double result, h;

        result = 0;

        h = 0.1;
        int n = (int)((b - a) / h);

        for(i = 0; i < n; i++)
        {
            result += f.call(a + h * (i)); //Вычисляем в средней точке и добавляем в сумму
        }

        result *= h;

        return result;
    }
}