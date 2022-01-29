public class Equation {
    public Expression rhs;
    public Expression lhs;

    public Equation(Expression rhs, Expression lhs) {
        this.rhs = rhs;
        this.lhs = lhs;
    }

    public Equation(Expression rhs) {
        this.rhs = rhs;
        this.lhs = new Expression();
    }

    public boolean isValid() {
        return this.rhs.evaluateDecider() == this.lhs.evaluateDecider();
    }

    public void setToZero(String side) {
        if (side == "rhs") {
            this.lhs = new Expression(Operation.SUBTRACT, this.lhs, this.rhs);
            this.rhs = new Expression();
        } else if (side == "lhs") {
            this.rhs = new Expression(Operation.SUBTRACT, this.rhs, this.lhs);
            this.lhs = new Expression();
        }
    }

    public void display() {
        this.rhs.display();
        System.out.print(" = ");
        this.lhs.display();
    }
}
