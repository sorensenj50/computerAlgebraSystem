public class main {
    public static void main(String[] args) {

        Expression rhs = new Expression(Operation.PRODUCT,  new Expression(Operation.SUM, 9, 3), new Expression(8));
        Expression lhs = new Expression(Operation.DIVIDE, new Expression(1), new Expression(new Variable("x")));
        Equation equation = new Equation(lhs, rhs);

        equation.display();

        equation.solveFor("x");

    }
}
