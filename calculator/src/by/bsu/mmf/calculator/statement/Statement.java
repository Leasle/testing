package by.bsu.mmf.calculator.statement;

import java.util.List;

/**
 * Created by Student on 9/8/2016.
 */
public class Statement {
    private List<Double> numbers;
    private String sign;

    public Statement() {}

    public Statement(List<Double> numbers, String sign) {
        this.numbers = numbers;
        this.sign = sign;
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Double> numbers) {
        if (numbers != null) {
            this.numbers = numbers;
        }
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        if (sign.length() == 1) {
            this.sign = sign;
        }
    }
}
