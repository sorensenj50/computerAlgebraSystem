import java.util.Scanner;

public class main {
    public static void main(String[] args) {

//        Expression old_lhs = new Expression(Operation.PRODUCT, new Expression(5), new Expression("x"));
//        Expression lhs = new Expression(Operation.SUM, new Expression(5), old_lhs);
//
//        Expression rhs = new Expression(Operation.SUM, 5, 5);
//        Equation equation = new Equation(lhs, rhs);
//
//        equation.display();
//
//        equation.solveFor("x");
//
//        equation.display();

        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec("which pdflatex");
            Scanner scanner = new Scanner(p.getInputStream());

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch(Exception e) {
            System.out.printf("Error");
        }
    }
}
