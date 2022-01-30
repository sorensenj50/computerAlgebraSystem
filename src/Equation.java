import java.util.HashMap;

enum EquationSide {
    RHS("RHS"),
    LHS("LHS");

    private final String displayString;

    EquationSide(final String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return displayString;
    }
}


public class Equation {
    public HashMap equationSides;

    public Equation(Expression lhs, Expression rhs) {
        this.equationSides = new HashMap<String, Expression>();
    }

    private Expression getFromMap(EquationSide side) {
        return new Expression();
    }

    private void setToMap(EquationSide side, Expression expression) {
        this.equationSides.put(side.getDisplayString(), expression);
    }



    public void display() {
        this.getFromMap(EquationSide.LHS).display();
        System.out.print(" = ");
        this.getFromMap(EquationSide.RHS).display();
    }

    public void solveFor(String variableSymbol) {
//        boolean lhs = this.findVariable(variableSymbol, this.lhs);
//        boolean rhs = this.findVariable(variableSymbol, this.rhs);


//        if (lhs) {
//            System.out.println("lhs");
//        } else if (rhs) {
//            System.out.println("rhs");
//        } else {
//            System.out.println("Not Found");
//        }
    }



    private void isolateVariable(EquationSideClass isolateSide, EquationSideClass otherSide, String variableSymbol) {
        if (isolateSide.expression.isVariable(variableSymbol)) {

        } else {
            for (Expression child: otherSide.expression.children) {
                if (child.isVariable(variableSymbol)) {

                } else {
//                    this.otherSide = new Expression(child.getInverseOperator(), child, this.getOtherSide(side));
                }
            }
        }
    }
}

class EquationSideClass {
    Expression expression;
    EquationSide sideName;

    public EquationSideClass(Expression expression, EquationSide sideName) {
        this.expression = expression;
        this.sideName = sideName;
    }

    private boolean findVariable(String variableSymbol, Expression expression) {
        if (expression.isVariable(variableSymbol)) {
            return true;
        } else {
            for (Expression child: expression.children) {
                boolean found = findVariable(variableSymbol, child);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}