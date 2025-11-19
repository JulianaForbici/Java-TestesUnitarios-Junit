import java.util.Scanner;

public class Fibonacci {

    // fiz um método que recebe um int n e devolve o n-ésimo número de Fibonacci
    public static int fibonacci(int n) {
        // aqui eu não deixo usar número negativo
        if (n < 0) {
            throw new IllegalArgumentException("n deve ser maior ou igual a 0");
        }
        // se n for 0, por definição o resultado é 0
        if (n == 0) {
            return 0;
        }
        // se n for 1, por definição o resultado é 1
        if (n == 1) {
            return 1;
        }
        // usando a fórmula: F(n) = F(n - 1) + F(n - 2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        // só uns testes rápidos pra compilar
        System.out.println(fibonacci(0)); // 0
        System.out.println(fibonacci(1)); // 1
        System.out.println(fibonacci(2)); // 1
        System.out.println(fibonacci(3)); // 2
        System.out.println(fibonacci(4)); // 3
        System.out.println(fibonacci(5)); // 5
        System.out.println(fibonacci(6)); // 8
    }
}
