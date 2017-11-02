package Expression;

/**
 * <p>Abstract Class to represent a Primitive quantity.</p>
 * <p>Primitives in ANL are:</p>
 * <ul>
 *   <li>Numbers</li>
 * </ul>
 */
public abstract class Primitive implements IExpression {

  @Override
  public IExpression evaluate() {
    return this;
  }
}