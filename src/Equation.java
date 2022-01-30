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
    public HashMap<String, Expression> equationSides;

    public Equation(Expression lhs, Expression rhs) {
        this.equationSides = new HashMap<String, Expression>();
        this.equationSides.put(EquationSide.LHS.getDisplayString(), lhs);
        this.equationSides.put(EquationSide.RHS.getDisplayString(), rhs);
    }

    private Expression getFromMap(EquationSide side) {
        return this.equationSides.get(side.getDisplayString());
    }

    private void setToMap(EquationSide side, Expression expression) {
        this.equationSides.put(side.getDisplayString(), expression);
    }

    private EquationSide getOtherEquationSide(EquationSide side) {
        if (side == EquationSide.LHS) {
            return EquationSide.RHS;
        } else {
            return EquationSide.LHS;
        }
    }



    public void display() {
        this.getFromMap(EquationSide.LHS).display();
        System.out.print(" = ");
        this.getFromMap(EquationSide.RHS).display();
        System.out.println("");
    }

    public void solveFor(String variableSymbol) {
        boolean isLeft = this.findVariable(variableSymbol, this.getFromMap(EquationSide.LHS));
        boolean isRight = this.findVariable(variableSymbol, this.getFromMap(EquationSide.RHS));

        if (isLeft) {
            this.isolateVariable(EquationSide.LHS, variableSymbol);
        } else if (isRight) {
            this.isolateVariable(EquationSide.RHS, variableSymbol);
        } else {
            System.out.println("Not Found");
        }
    }



    private void isolateVariable(EquationSide isolateSide, String variableSymbol) {
        Expression isolateSideExpression = this.getFromMap(isolateSide);
        Expression otherSideExpression = this.getFromMap(this.getOtherEquationSide(isolateSide));

        if (isolateSideExpression.isVariable(variableSymbol)) {

        } else {
            for (Expression child: isolateSideExpression.children) {
                if (child.isVariable(variableSymbol)) {

                } else {
                    Expression newOtherSide = new Expression(isolateSideExpression.getInverseOperator(), child, otherSideExpression);
                    this.setToMap(this.getOtherEquationSide(isolateSide), newOtherSide);


                    if (isolateSideExpression.children.size() == 2) {
                        isolateSideExpression.children.remove(child);
                        Expression newIsolateSideExpression = isolateSideExpression.children.get(0);
                        this.setToMap(isolateSide, newIsolateSideExpression);
                        break;
                    }
                }
            }
        }
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