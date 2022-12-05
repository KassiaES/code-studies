import java.util.Scanner;
import java.util.InputMismatchException;

public class CustomException2 {

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        boolean go = true;
        int resultado = 0;
        do {
            System.out.print("Numerador: ");
            int numerador = leitor.nextInt();
            System.out.print("Denominador: ");
            int denominador = leitor.nextInt();

            try {
                if (numerador%denominador  != 0) {
                    throw new DivisaoNaoExataException("Divisão não exata! O programa continua... \n", numerador, denominador);
                }
                go = false;

            } catch (DivisaoNaoExataException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.err.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida, informe um número inteiro! " + e.getMessage());
            }
            resultado = (numerador / denominador);

        } while (go);

        System.out.println("\n Resultado: " + resultado);
        leitor.close();
    }

    public  static class DivisaoNaoExataException extends Exception {

        private int numerador;
        private int denominador;

        public DivisaoNaoExataException(String message, int numerador, int denominador) {
            super(message);
            this.numerador = numerador;
            this.denominador = denominador;
        }

    }
}
