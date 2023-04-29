import java.util.Scanner;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;

            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }
        }
    }

    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public Rational abs() {
        return new Rational (Math.abs(this.numerator), this.denominator);
    }

    public int compareTo(Rational other) {
        int thisNumerator = this.numerator * other.denominator;
        int otherNumerator = other.numerator * this.denominator;
        return Integer.compare(thisNumerator, otherNumerator);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        try {
            int numerator1 = Integer.parseInt(args[0]);
            int denominator1 = Integer.parseInt(args[1]);
            int numerator2 = Integer.parseInt(args[2]);
            int denominator2 = Integer.parseInt(args[3]);

            Rational rational1 = new Rational(numerator1, denominator1);
            Rational rational2 = new Rational(numerator2, denominator2);

            System.out.println("Rational Number 1: " + rational1);
            System.out.println("Rational Number 2: " + rational2);

            System.out.println("Sum: " + rational1.add(rational2));
            System.out.println("Difference: " + rational1.subtract(rational2));
            System.out.println("Product: " + rational1.multiply(rational2));
            System.out.println("Quotient: " + rational1.divide(rational2));
            System.out.println("Floating point value of Rational Number 1: " + rational1.toDouble());
        	System.out.println("Floating point value of Rational Number 2: " + rational2.toDouble());

        	System.out.println("Absolute value of Rational Number 1: " + rational1.abs());
        	System.out.println("Absolute value of Rational Number 2: " + rational2.abs());

        	int result = rational1.compareTo(rational2);
        	if (result < 0) {
            	System.out.println(rational1 + " is less than " + rational2);
        	} else if (result > 0) {
            	System.out.println(rational1 + " is greater than " + rational2);
        	} else {
            	System.out.println(rational1 + " is equal to " + rational2);
        	}
    	} catch (NumberFormatException e) {
       	 System.out.println("Invalid input. Please enter integers only.");
    	} catch (IllegalArgumentException e) {
        	System.out.println(e.getMessage());
    	}
}
}

