package by.bsu.mmf.calculator.split;


import by.bsu.mmf.calculator.statement.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Student on 9/8/2016.
 */
public class SplitStatement {
    public static Statement split(String statementStr) {
        System.out.println(statementStr);

        Statement statement = new Statement();

        Pattern patternNumber = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcherNumber = patternNumber.matcher(statementStr);

        List<Double> numbers = new ArrayList<Double>();

        while (matcherNumber.find()) {
             numbers.add(Double.parseDouble(matcherNumber.group()));
        }

        statement.setNumbers(numbers);

        Pattern patternSign = Pattern.compile("(\\+|\\-|\\*|\\/)");
        Matcher matcherSign = patternSign.matcher(statementStr);

        String sign = null;

        while (matcherSign.find()) {
            sign = matcherSign.group();
        }
        statement.setSign(sign);

        return statement;
    }
}
