public class main {
    public static void main(String[] args) {
        Expression expression = new Expression(Operation.SUM, new Expression(Operation.PRODUCT, 4, 5), new Expression(9));
        System.out.println(expression.evaluate());
    }
}
