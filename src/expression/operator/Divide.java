package Expression.Operator;

import java.util.List;

import Exceptions.ArithmeticError;
import Expression.IExpression;
import Expression.Number.MyNumber;

/**
 * Class to represent Division operation.
 */
public class Divide implements IOperator {

  @Override
  public IExpression operate(List<IExpression> operands) {

    boolean allNumbers = true;

    for (IExpression e : operands) {
      allNumbers = allNumbers && (e.getType() == "Number");
    }

    if (!allNumbers) {
      throw new IllegalArgumentException("All operands must be numbers.");
    }
    else if (operands.size() == 1) {
      return operands.get(0).evaluate();
    }
    else if (operands.size() > 1) {
      MyNumber result = (MyNumber) (operands.get(0).evaluate());

      for (int i = 1; i < operands.size(); i++) {

        try {
          result = result.divide((MyNumber) (operands.get(i).evaluate()));
        }
        catch (ArithmeticError e) {
          e.printStackTrace();
        }
      }

      return result;
    }
    else {
      throw new IllegalArgumentException("Too few arguments for IOperator.");
    }
  }

  @Override
  public IExpression evaluate() {
    return this;
  }

  @Override
  public String getType() {
    return "Number";
  }

  @Override
  public String toString() {
    return "/";
  }
}