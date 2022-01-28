import java.util.ArrayList;

public class Expression {
    public double value;
    public ArrayList<Expression> children;

    public Expression(int value) {
        this.value = value;
        this.children = new ArrayList<Expression>();
    }

    public Expression(int... numbers) {
        this.value = 0;
        this.children = new ArrayList<Expression>();

        for (int num : numbers) {
            this.children.add(new Expression(num));
        }
    }

    public Expression(Expression... expressions) {
        this.value = 0;
        this.children = new ArrayList<Expression>();

        for (Expression child: expressions) {
            this.children.add(child);
        }
    }

    public Expression(int value, Expression... expressions) {
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

    public double evaluateSum() {
        double total = 0;
        if (this.containsChildren()) {
            for (Expression child : this.children) {
                total += child.evaluateSum();
            }
        } else {
            total = this.value;
        }
        return total;
    }
}


