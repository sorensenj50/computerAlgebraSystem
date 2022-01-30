import java.util.ArrayList;
import java.util.Arrays;

public class Expression {
    public Value value;
    public Operation operation;
    public ArrayList<Expression> children;

    public Expression() {
        this.operation = Operation.NONE;
        this.value = getNullValue();
        this.children = getEmptyChildren();
    }


    public Expression(Operation operation, Expression... children) {
        this.operation = operation;
        this.value = getNullValue();
        this.children = new ArrayList<Expression>(Arrays.asList(children));
    }

    public Expression(Value value) {
        this.operation = Operation.NONE;
        this.value = value;
        this.children = getEmptyChildren();
    }

    public Expression(Operation operation, Value... values) {
        this.operation = operation;
        this.value = getNullValue();

        ArrayList<Expression> children = getEmptyChildren();
        for (Value value: values) {
            children.add(new Expression(value));
        }
        this.children = children;
    }

    public Expression(Operation operation, double... values) {
        this.operation = operation;
        this.value = getNullValue();
        ArrayList<Expression> children = getEmptyChildren();

        for (double value: values) {
            children.add(new Expression(new Number(value)));
        }
        this.children = children;
    }

    public Expression(double value) {
        this.operation = Operation.NONE;
        this.value = new Number(value);
        this.children = getEmptyChildren();
    }

    public boolean isRootNode() {
        return (this.children.size() == 0);
    }

    private NullValue getNullValue() {
        return new NullValue();
    }

    private ArrayList<Expression> getEmptyChildren() {
        return new ArrayList<Expression>();
    }

    public boolean isVariable(String variableSymbol) {
        return this.isRootNode() && !this.value.isKnown() && this.value.getSymbol() == variableSymbol;
    }

    public double evaluateDecider() {
        switch (this.operation) {
            case SUM:
                return this.evaluateSum(false);
            case SUBTRACT:
                return this.evaluateSum(true);
            case PRODUCT:
                return this.evaluateProduct(false);
            case DIVIDE:
                return this.evaluateProduct(true);
            default:
                return 0;
        }
    }


    private double evaluateSum(boolean inversed) {
        if (inversed) {
            return -1.0;
        } else {
            return 1.0;
        }
    }

    private double evaluateProduct(boolean inversed) {
        if (inversed) {
            return -1.0;
        } else {
            return 1.0;
        }
    }

    public void represent() {
        if (this.operation == Operation.SUM) {
            System.out.print("+");
        } else if (this.operation == Operation.SUBTRACT) {
            System.out.print("-");
        } else if (this.operation == Operation.DIVIDE) {
            System.out.print("/");
        } else {
            System.out.print("*");
        }
    }

    public Operation getInverseOperator() {
        if (this.operation == Operation.SUM) {
            return Operation.SUBTRACT;
        } else if (this.operation == Operation.SUBTRACT) {
            return Operation.SUM;
        } else if (this.operation == Operation.PRODUCT) {
            return Operation.DIVIDE;
        } else {
            return Operation.PRODUCT;
        }
    }

    public void display() {
        if (this.isRootNode()) {
            System.out.print(this.value.getSymbol() + " ");
        } else {
            this.represent();
            System.out.print("( ");
            for (Expression child: this.children) {
                child.display();
            }
            System.out.print(")");
        }
    }

    public double evaluate() {
        return 1.0;
    }
}



