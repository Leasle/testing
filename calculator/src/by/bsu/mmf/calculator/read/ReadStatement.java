package by.bsu.mmf.calculator.read;

import java.util.Scanner;

/**
 * Created by Student on 9/8/2016.
 */
public class ReadStatement {
    public static String readConsole() {
        String statement = null;

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            statement = scanner.nextLine();
            System.out.println(statement);
        }

        return statement;
    }
}
