import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FourFunctionCalculator implements CalculatorType{

    @Override
    public double evaluate(String expression){
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
}
