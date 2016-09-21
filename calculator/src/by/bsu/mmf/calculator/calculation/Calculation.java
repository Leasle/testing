package by.bsu.mmf.calculator.calculation;


import by.bsu.mmf.calculator.statement.Statement;

import java.util.List;

/**
 * Created by Student on 9/8/2016.
 */
public class Calculation {
    public static double calculate(Statement statement) {
        double result = Double.POSITIVE_INFINITY;
        List<Double> numbers = statement.getNumbers();

        switch (statement.getSign()) {
            case "+": result = numbers.get(0) + numbers.get(1);
                break;
            case "-": result = numbers.get(0) - numbers.get(1);
                break;
            case "*": result = numbers.get(0) * numbers.get(1);
                break;
            case "/": if (numbers.get(1) != 0) {
                        result = numbers.get(0) / numbers.get(1);
                      } else {
                        System.out.println("Divider is equal to zero.");
                      }
                break;
            default:
                System.out.println("Incorrect sign.");
                break;
        }

        return result;
    }
}
