import java.util.ArrayList;
import java.util.Optional;


enum Operation {
    SUM,
    PRODUCT,
}



public class Expression {
    public double value;
    public ArrayList<Expression> children;
    public Operation operation;

    public Expression(int value) {
        this.value = value;
        this.children = new ArrayList<Expression>();
        this.operation = Operation.SUM;
    }

    public Expression(Operation operation, int... numbers) {
        this.operation = operation;
        this.value = 0;
        this.children = new ArrayList<Expression>();

        for (int num : numbers) {
            this.children.add(new Expression(num));
        }
    }

    public Expression(Operation operation, Expression... expressions) {
        this.operation = operation;
        this.value = 0;
        this.children = new ArrayList<Expression>();

        for (Expression child: expressions) {
            this.children.add(child);
        }
    }

    public Expression(Operation operation, int value, Expression... expressions) {
        this.operation = operation;
        this.value = value;
        this.children = new ArrayList<Expression>();

        for (Expression child: expressions){
            this.children.add(child);
        }
    }

    private static String getRepresentation(double num) {
        return String.valueOf(num);
    }

    public boolean containsChildren() { return this.children.size() > 0;}

    public void display() {
        if (this.containsChildren()) {
            System.out.print("(");
            for (Expression child : this.children) {
                child.display();
            }
            System.out.print(")");

        } else {
            System.out.print(getRepresentation(this.value) + " ");
        }
    }

    public double evaluate() {
        double total;

        if (this.operation == Operation.PRODUCT) {
            total = 1;
        } else {
            total = 0;
        }

        if (this.containsChildren()) {
            for (Expression child : this.children) {
                if (this.operation == Operation.SUM) {
                    total += child.evaluate();
                } else if (this.operation == Operation.PRODUCT) {
                    total *= child.evaluate();
                }
            }
        } else {
            total = this.value;
        }
        return total;
    }
}


