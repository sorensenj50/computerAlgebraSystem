public class main {
    public static void main(String[] args) {

//        Expression rhs = new Expression(Operation.PRODUCT,  new Expression(Operation.SUM, 9, 3), new Expression(new Variable("x")));
//        Expression lhs = new Expression(Operation.DIVIDE, new Expression(1), new Expression(new Number(9)));
        Expression lhs = new Expression(Operation.PRODUCT, new Expression(5), new Expression("x"));
        Expression rhs = new Expression(Operation.SUM, 5, 5);
        Equation equation = new Equation(lhs, rhs);

        equation.solveFor("x");

        equation.display();

    }
}
