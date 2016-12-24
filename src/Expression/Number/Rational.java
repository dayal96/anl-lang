package Expression.Number;

import Exceptions.ArithmeticError;
import Exceptions.DivideByZeroError;

/**
 * Class to represent a Number System for Rational Numbers.
 */
public class Rational extends MyNumber<ImproperFraction> {

  /**
   * Creates a new Rational from a ImproperFraction.
   * @param number  the Improper Fraction representation of the number this Rational represents.
   */
  public Rational(ImproperFraction number) {
    super(number);
  }

  /**
   * Creates a Rational number from numerator and denominator of an Improper Fraction.
   * @param numerator    the numerator of the Improper Fraction.
   * @param denominator  the denominator of the Improper Fraction.
   * @throws ArithmeticError if the ImproperFraction is not defined.
   */
  public Rational(int numerator, int denominator) throws ArithmeticError {
    super(new ImproperFraction(numerator, denominator));
  }


  @Override
  public MyNumber<ImproperFraction> add(MyNumber<ImproperFraction> other) throws ArithmeticError {

    int newNumerator = this.number.numerator * other.number.denominator
            + other.number.numerator * this.number.denominator;
    int newDenominator = this.number.denominator * other.number.denominator;

    return new Rational(new ImproperFraction(newNumerator, newDenominator));
  }

  @Override
  public MyNumber<ImproperFraction> subtract(MyNumber<ImproperFraction> other) throws ArithmeticError {
    int newNumerator = this.number.numerator * other.number.denominator
            - other.number.numerator * this.number.denominator;
    int newDenominator = this.number.denominator * other.number.denominator;

    return new Rational(new ImproperFraction(newNumerator, newDenominator));
  }

  @Override
  public MyNumber<ImproperFraction> multiply(MyNumber<ImproperFraction> other) throws ArithmeticError {
    int newNumerator = this.number.numerator * other.number.numerator;
    int newDenominator = this.number.denominator * other.number.denominator;

    return new Rational(new ImproperFraction(newNumerator, newDenominator));
  }

  @Override
  public MyNumber<ImproperFraction> divide(MyNumber<ImproperFraction> other) throws ArithmeticError {

    if (other.number.numerator == 0) {
      throw new DivideByZeroError("Cannot divide a Rational by 0.");
    }

    int newNumerator = this.number.numerator * other.number.denominator;
    int newDenominator = this.number.denominator * other.number.numerator;

    return new Rational(new ImproperFraction(newNumerator, newDenominator));
  }
}
