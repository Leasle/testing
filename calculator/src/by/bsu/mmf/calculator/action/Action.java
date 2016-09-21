package by.bsu.mmf.calculator.action;

import by.bsu.mmf.calculator.calculation.Calculation;
import by.bsu.mmf.calculator.print.PrintResult;
import by.bsu.mmf.calculator.read.ReadStatement;
import by.bsu.mmf.calculator.split.SplitStatement;
import by.bsu.mmf.calculator.statement.Statement;


/**
 * Created by Student on 9/8/2016.
 */
public class Action {
    public static void main(String... args) {
        String statementStr = ReadStatement.readConsole();

        Statement statement = SplitStatement.split(statementStr);

        double result = Calculation.calculate(statement);

        PrintResult.printConsole(result);
    }
}
