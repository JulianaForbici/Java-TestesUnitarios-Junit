package ExercíciosFeitos.Recursividade;

public class Fatorial {
    // método que recebe um int n e devolve n! (fatorial de n)
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n deve ser maior ou igual a 0");
        }
        // esse é o caso base! por definição matemática 0! = 1 = fatorial de 0 é 1
        if (n == 0) {
            return 1;
        }
        // Passo recursivo || n! = n * (n - 1)!
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        // só alguns testes pra compilar
        System.out.println("0! = " + factorial(0)); // 1
        System.out.println("1! = " + factorial(1)); // 1
        System.out.println("3! = " + factorial(3)); // 6
        System.out.println("5! = " + factorial(5)); // 120
    }
}
