public class main {
    public static void main(String[] args) {
        Expression expression = new Expression(new Expression(4, 5), new Expression(9));
        System.out.println(expression.evaluateSum());
    }
}
