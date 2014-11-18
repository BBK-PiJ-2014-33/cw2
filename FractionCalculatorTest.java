import java.util.Scanner;

public class FractionCalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInstructions;
        System.out.print("Hello! You are running Fraction Calculator designed by Liudmila Veshneva. Please input your instructions: ");
        userInstructions = scanner.nextLine();
        Fraction myFraction = new Fraction(0,1);
        FractionCalculator myFractionCalculator = new FractionCalculator();
        myFractionCalculator.evaluate(myFraction,userInstructions);

    }
}
