/*
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom)
    {
        if (denom == 0)
        {
            System.out.println("Invalid fraction with denominator 0");
            // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override

    public String toString()
    {
        int MyDenominator = getDenominator();
        if (MyDenominator==1)
        {
            return "" + getNumerator();
        }
        else
        {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int num)
    {
        numerator = num;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int num)
    {
        denominator = num;
    }

    @Override

    public boolean equals(Object o)
    {
        if (this == o) return true; //if pointing to same address
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override

    public int hashCode()
    {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other)
    {
        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction other)
    {
        int num;
        int denom;

        {
            num = this.getNumerator()*other.getDenominator() + other.getNumerator()*this.getDenominator();
            denom = this.getDenominator()*other.getDenominator();
        }

        return new Fraction(num, denom);
    }

    public Fraction subtract(Fraction other)
    {
        int num;
        int denom;
        {
            num = this.getNumerator()*other.getDenominator() - other.getNumerator()*this.getDenominator();
            denom = this.getDenominator()*other.getDenominator();
        }
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction other)
    {
        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        return new Fraction(num, denom);
    }
    public Fraction absValue(Fraction other)
    {
        int num;
        int denom;

        if (other.getNumerator()<0)
        {
            num = other.getNumerator() * -1;
        }
        else
        {
            num = other.getNumerator();
        }
        if (other.getDenominator()<0)
        {
            denom = other.getDenominator() * -1;
        }
        else
        {
            denom = other.getDenominator();
        }
        return new Fraction(num, denom);
    }
    public Fraction negate(Fraction other)
    {
        int num;
        int denom;

        num = other.getNumerator() * -1;
        denom = other.getDenominator() * -1;
        return new Fraction(num,denom);
    }

    private int myGcd(int a, int b)
    {
        while (b != 0)
        {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
