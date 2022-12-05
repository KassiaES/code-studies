import java.util.Scanner;

// fazer a divisão de 2 valores inteiros
public class UncheckedException {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean continueLooping = true;
        do {
            System.out.print("Numerador: ");
            String a = scan.next();
            System.out.print("Denominador: ");
            String b = scan.next();;

            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Entrada inválida, informe um número inteiro! " + e.getMessage());
            } catch (ArithmeticException e) {
                e.printStackTrace();
                System.out.println("Impossível dividir um número por 0." + e.getMessage());
            }
            finally {
                System.out.println("Chegou no finally!");
            }
        } while(continueLooping);


        System.out.println("O código continua...");
        scan.close();
    }

    public static int dividir(int a, int b) {
        return a / b;
    }

}
