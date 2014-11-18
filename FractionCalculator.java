import java.util.Arrays;

public class FractionCalculator
{
    private Fraction result;
    private String operation;

    public FractionCalculator()
    {
        result = new Fraction (0,1);
        operation = "None";
    }

    public void evaluate(Fraction fraction, String inputString)
    {
        String [] myInstructions = parseInstructions(inputString);
        result.setNumerator(fraction.getNumerator());
        result.setDenominator(fraction.getDenominator());

        for(int i=0; i<myInstructions.length; i++)
        {
            char c = myInstructions[i].charAt(0);
            if(Character.isLetter(c))
            {

            }
            else if (Character.isDigit(c))
            {

            }
        }

    }

    private void reset()
    {
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
