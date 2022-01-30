import java.util.ArrayList;
import java.util.Arrays;

public class Expression {
    public Value value;
    public Operation operation;
    public ArrayList<Expression> children;

    public Expression() {
        this.operation = Operation.NONE;
        this.value = getZeroNumber();
        this.children = getEmptyChildren();
    }


    public Expression(Operation operation, Expression... children) {
        this.operation = operation;
        this.value = getZeroNumber();
        this.children = new ArrayList<Expression>(Arrays.asList(children));
    }

    public Expression(Value value) {
        this.operation = Operation.NONE;
        this.value = value;
        this.children = getEmptyChildren();
    }

    public Expression(Operation operation, Value... values) {
        this.operation = operation;
        this.value = getZeroNumber();

        ArrayList<Expression> children = getEmptyChildren();
        for (Value value: values) {
            children.add(new Expression(value));
        }
        this.children = children;
    }

    public Expression(Operation operation, double... values) {
        this.operation = operation;
        this.value = getZeroNumber();
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

    private Number getZeroNumber() {
        return new Number(0);
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

    public void represent(Operation operation) {
        if (operation == Operation.SUM) {
            System.out.print("+");
        } else if (operation == Operation.SUBTRACT) {
            System.out.print("-");
        } else if (operation == Operation.DIVIDE) {
            System.out.print("/");
        } else {
            System.out.print("*");
        }
    }

    public void display() {
        if (this.isRootNode()) {
            System.out.print(this.value.getSymbol() + " ");
        } else {
            this.represent(this.operation);
            System.out.print("( ");
            for (Expression child: this.children) {
                child.display();
            }
            System.out.print(")");
        }
    }
}



