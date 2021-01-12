package expression.operator.cons;

import environment.IEnvironment;
import expression.IExpression;
import expression.cons.ConsPair;
import expression.operator.AOperator;
import expression.type.Type;
import java.util.List;

public class Cons extends AOperator {

  @Override
  public IExpression evaluate(List<IExpression> operands, IEnvironment environment)
      throws Exception {

    if (operands.size() != 2) {
      throw new Exception("cons : expected 2 arguments, found " + operands.size());
    }

    return new ConsPair(operands.get(0).evaluate(environment),
        operands.get(1).evaluate(environment));
  }

  @Override
  public Type getType() {
    return Type.CONS_PAIR;
  }

  @Override
  public String toString() {
    return "cons";
  }
}
