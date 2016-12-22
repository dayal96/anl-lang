package Expression.Number;

import java.util.Objects;

import Exceptions.ArithmeticError;

/**
 * Class to represent a MixedFraction.
 */
public class MixedFraction {
  public final int numerator;
  public final int denominator;

  public MixedFraction(int numerator, int denominator) throws ArithmeticError {
    int gcd = this.gcd(Math.abs(numerator), Math.abs(denominator));
    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;

    if (this.denominator == 0) {
      throw new ArithmeticError("Rational cannot have a zero as denominator.");
    }
  }

  /**
   * Calculate the GCD of two given numbers.
   * @param a  the first number.
   * @param b  the second number.
   * @return the greatest common denominator of the two numbers.
   */
  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    else {
      return gcd(b, a % b);
    }
  }

  /**
   * Returns String representation of this Fraction.
   * @return the String representation of this Fraction.
   */
  public String toString() {
    return String.format("%d/%d", this.numerator, this.denominator);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    else if (!(other instanceof MixedFraction)) {
      return false;
    }
    else {
      MixedFraction that = (MixedFraction) other;
      return this.numerator * that.denominator == that.numerator * this.denominator;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.numerator, this.denominator);
  }
}
