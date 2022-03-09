public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        while(true) {
            calc.inputData();
            String result = calc.calculate(calc.getFirstValue(), calc.getSecondValue(), calc.getOperation());

            System.out.println(result);
        }
    }
}
