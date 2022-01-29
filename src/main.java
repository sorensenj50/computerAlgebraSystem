public class main {
    public static void main(String[] args) {
//        Expression expression = new Expression(Operation.SUM, new Expression(Operation.PRODUCT, 4, 5), new Expression(9));

        Expression rhs = new Expression(Operation.SUM, 4, 5);
        Expression lhs = new Expression(9);
        Equation equation = new Equation(rhs, lhs);

        equation.setToZero("rhs");
        equation.display();
    }
}
