package ExercíciosFeitos.ExemplosTestes;

public class SomaAteN {
    public static int soma(int n) {
        if (n == 1) {
            return 1;
        }
        return n + soma(n - 1);
    }

    public static void main(String[] args) {
        int resultado = soma(5);
        System.out.println("Soma de 1 até 5 = " + resultado);
    }
}