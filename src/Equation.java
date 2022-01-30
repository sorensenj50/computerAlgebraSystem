import java.util.Optional;

enum EquationSide {
    RHS,
    LHS;
}


public class Equation {
    public Expression rhs;
    public Expression lhs;

    public Equation(Expression rhs, Expression lhs) {
        this.rhs = rhs;
        this.lhs = lhs;
    }

    public Equation(Expression rhs) {
        this.rhs = rhs;
        this.lhs = new Expression(new Variable("x"));
    }

    public boolean isValid() {
        return this.rhs.evaluateDecider() == this.lhs.evaluateDecider();
    }

    public void setToZero(EquationSide side) {
        if (side == EquationSide.RHS) {
            this.lhs = new Expression(Operation.SUBTRACT, this.lhs, this.rhs);
            this.rhs = new Expression();
        } else if (side == EquationSide.LHS) {
            this.rhs = new Expression(Operation.SUBTRACT, this.rhs, this.lhs);
            this.lhs = new Expression();
        }
    }

    public void display() {
        this.rhs.display();
        System.out.print(" = ");
        this.lhs.display();
    }

    public void solveFor(String variableSymbol) {
        boolean lhs = this.findVariable("x", this.lhs);
        boolean rhs = this.findVariable("x", this.rhs);


        if (lhs) {
            System.out.println("lhs");
        } else if (rhs) {
            System.out.println("rhs");
        } else {
            System.out.print("Not Found");
        }
    }

    private boolean findVariable(String variableSymbol, Expression expression) {
        if (expression.isVariable(variableSymbol)) {
            return true;
        } else {
            for (Expression child: expression.children) {
                return findVariable(variableSymbol, child);
            }
        }
        return false;
    }
}
