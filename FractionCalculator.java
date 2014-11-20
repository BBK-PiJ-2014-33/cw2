import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator
{
    private Fraction result;
    private String operation;
    Scanner scanner = new Scanner(System.in);

    public FractionCalculator()
    {
        result = new Fraction (0,1);
        operation = "None";
    }

    public String evaluate(Fraction fraction, String inputString)
    {
        String [] myInstructions = parseInstructions(inputString);
        result.setNumerator(fraction.getNumerator());
        result.setDenominator(fraction.getDenominator());

        for(int i=0; i<myInstructions.length; i++)
        {
            if(Character.isLetter(myInstructions[i].charAt(0)))
            {
                executeInstruction(myInstructions[i]);
            }
            else if (Character.isDigit(myInstructions[i].charAt(0)))
            {
               Fraction myFraction = new Fraction(0,1);
                myFraction.setNumerator(Integer.parseInt(myInstructions[i].substring(0, 1)));
                if (myInstructions[i].length()>1)
                {
                    myFraction.setDenominator(Integer.parseInt(myInstructions[i].substring(2)));
                }
                else
                {
                    myFraction.setDenominator(1);
                }
                if (this.operation.equals("None"))
                {
                    this.result.setNumerator(myFraction.getNumerator());
                    this.result.setDenominator(myFraction.getDenominator());
                }
                else
                {
                    calculate(myFraction);
                    this.operation="None";
                }
            }
            else if (myInstructions[i].equals("*")||myInstructions[i].equals("+")||myInstructions[i].equals("-")||myInstructions[i].equals("/"))
            {
                rememberOperation(myInstructions[i]);
            }
        }
        return this.result.toString();
    }
    private void calculate (Fraction myFraction)
    {
        if(this.operation.equals("*"))
        {
            this.result.setNumerator((this.result.multiply(myFraction)).getNumerator());
            this.result.setDenominator((this.result.multiply(myFraction)).getDenominator());
        }
        else if (this.operation.equals("+"))
        {
            this.result.setNumerator((this.result.add(myFraction)).getNumerator());
            this.result.setDenominator((this.result.add(myFraction)).getDenominator());
        }
        else if (this.operation.equals("-"))
        {
            this.result.setNumerator((this.result.subtract(myFraction)).getNumerator());
            this.result.setDenominator((this.result.subtract(myFraction)).getDenominator());
        }
        else if (this.operation.equals("/"))
        {
            this.result.setNumerator((this.result.divide(myFraction)).getNumerator());
            this.result.setDenominator((this.result.divide(myFraction)).getDenominator());
        }
    }

    private void executeInstruction(String myInstruction)
    {
        if(Character.toLowerCase(myInstruction.charAt(0))=='a')
        {
            this.result.absValue(this.result);
        }
        else if (Character.toLowerCase(myInstruction.charAt(0))=='n')
        {
            this.result.negate(this.result);
        }
        else if (Character.toLowerCase(myInstruction.charAt(0))=='c')
        {
            this.reset();
        }
        else if (Character.toLowerCase(myInstruction.charAt(0))=='q')
        {
            System.exit(1);
        }
        else
        {
            this.reset();
            System.out.print("You have provided an invalid input. Calculator will terminate now");
            System.exit(1);
        }
    }

    private void rememberOperation(String myOperator)
    {
        if(this.operation.equals("None"))
        {
            this.operation=myOperator;
        }
        else
        {
            this.reset();
        }

    }

    private void reset()
    {
        this.result.setNumerator(0);
        this.result.setDenominator(1);
        this.operation="None";
    }

    private String [] parseInstructions (String instructions)
    {
        String [] instructionsArray = new String [getNumberOfItemsInString(instructions)];
        Arrays.fill(instructionsArray, "");
        int myItem = 0;
        for (int i=0; i<instructions.length(); i++)
            if (!(Character.isSpaceChar(instructions.charAt(i))))
            {
                instructionsArray[myItem]=instructionsArray[myItem] + instructions.substring(i,i+1);
            }
            else
            {
                myItem = myItem+1;
            }


        return instructionsArray;
    }
    private int getNumberOfItemsInString(String myString)
    {
        int NumberOfItems=0;
        for (int i=0; i<myString.length(); i++)
        {
            if (!(Character.isSpaceChar(myString.charAt(i))))
            {
                //do nothing
            }
            else
            {
                NumberOfItems++;
            }
        }
        return NumberOfItems+1;
    }
}
