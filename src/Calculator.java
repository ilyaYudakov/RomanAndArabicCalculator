import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private String firstValue;
    private String secondValue;
    private String operation;
    private Boolean isRoman = false;

    public void inputData() {

        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().toUpperCase().split(" ");
        firstValue = values[0];
        operation = values[1];
        secondValue = values[2];
    }

    public Integer[] stringToInteger(String firstValue, String secondValue) {
        Integer[] values = new Integer[2];
        if (isRomanNumber(firstValue) && isRomanNumber(secondValue)) {
            isRoman = true;
            values[0] = romanToInt(firstValue);
            values[1] = romanToInt(secondValue);
        } else {
            try {
                values[0] = Integer.valueOf(firstValue);
                values[1] = Integer.valueOf(secondValue);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("It is impossible to perform arithmetic operations of Roman and Arabic numerals together");
            }
        }
        return values;
    }

    public String integerToString(Integer value) {
        if (isRoman) {
            if (value <= 0) {
                throw new RuntimeException("Roman numerals can't be zero or negative");
            }
            return  intToRoman(value);
        }
        return String.valueOf(value);
    }

    private Boolean isRomanNumber(String value) {
        return (value.contains("I") || value.contains("V") || value.contains("X"));
    }

    public void calculate(String firstValue, String secondValue, String operation) {

        Integer[] converterValues = stringToInteger(firstValue, secondValue);
        Integer num1 = converterValues[0];
        Integer num2 = converterValues[1];
        if (num1 > 10 || num2 > 10) {
            throw new RuntimeException("You can't perform operations with numbers greater than 10");
        }
        try {
            switch (operation) {
                case "+":
                    return integerToString(num1 + num2);
                case "-":
                    return integerToString(num1 - num2);
                case "*":
                    return integerToString(num1 * num2);
                case "/":
                    return integerToString(num1 / num2);
                default:
                    throw new RuntimeException("Unsupported operation");
            }
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Can't be divided by zero");
        }
    }

    public String intToRoman(Integer value) {
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0 && value > 0; i--) {
            while (value >= values[i]) {
                value -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public int romanToInt(String value) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);

        int result = map.get(value.charAt(value.length() - 1));
        for (int i = value.length() - 2; i >= 0; i--) {
            if (map.get(value.charAt(i)) < map.get(value.charAt(i + 1))) {
                result -= map.get(value.charAt(i));
            } else {
                result += map.get(value.charAt(i));
            }
        }
        return result;
    }

    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getOperation() {
        return operation;
    }
}
