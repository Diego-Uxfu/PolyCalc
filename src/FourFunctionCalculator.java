import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FourFunctionCalculator implements CalculatorType{

    @Override
    public double evaluate(String expression){
        expression = expression.replaceAll("\\s+", ""); // strips white space

        try{
            Expression exp = new ExpressionBuilder(expression).build();
            double result = exp.evaluate();

            if(Double.isInfinite(result)){
                throw new ArithmeticException("Division by zero");
            } return result;
        }
        catch (ArithmeticException e){
            throw new ArithmeticException("Syntax Error" + e.getMessage());
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid Expression");
        }
    }
}
