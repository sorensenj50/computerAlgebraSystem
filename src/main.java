public class main {
    public static void main(String[] args) {

        Expression rhs = new Expression(Operation.SUM, 4, 5);
        Expression lhs = new Expression(9);
        Equation equation = new Equation(rhs, lhs);

//        equation.setToZero("rhs");
        equation.display();
    }
}
