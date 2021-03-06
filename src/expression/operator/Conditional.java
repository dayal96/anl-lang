package expression.operator;

import environment.IEnvironment;
import expression.IExpression;
import expression.bool.MyBoolean;
import java.util.List;

public class Conditional extends AOperator {

  @Override
  public IExpression evaluate(List<IExpression> operands, IEnvironment environment)
      throws Exception {
    if (operands.size() != 3) {
      throw new Exception("A conditional expects 3 parts, provided " + operands.size());
    } else {
      IExpression truth = operands.get(0).evaluate(environment);

      if (truth.equals(MyBoolean.TRUE)) {
        return operands.get(1).evaluate(environment);
      } else if (truth.equals(MyBoolean.FALSE)) {
        return operands.get(2).evaluate(environment);
      } else {
        throw new Exception(truth.toString() + " is not a Boolean.");
      }
    }
  }

  @Override
  public String toString() {
    return "if";
  }
}
