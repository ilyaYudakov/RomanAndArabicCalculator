import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private String firstValue;
    private String secondValue;
    private String operation;

    public void inputData() {

        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().toUpperCase().split(" ");
        firstValue = values[0];
        operation = values[1];
        secondValue = values[2];
    }

    public void calculate(int a, char b, int c){

        switch (b){

            case '+':
                System.out.println(a + c);
                break;
            case '-':
                System.out.println(a - c);
                break;
            case '*':
                System.out.println(a * c);
            case '/':
                System.out.println(a / c);
            default:
                System.out.println("Invalid ");
        }
    }

    public String intToRoman(int num) {
        int[] values = {1, 5, 10};
        String[] roman = {"I", "V", "X"};
        StringBuilder sb = new StringBuilder();
        for (int i = values.length - 1; i >= 0 && num > 0; i--) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public int romanToInt(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);

        int result = map.get(str.charAt(str.length() - 1));
        for (int i = str.length() - 2; i >= 0; i--) {
            if (map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
                result -= map.get(str.charAt(i));
            } else {
                result += map.get(str.charAt(i));
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
