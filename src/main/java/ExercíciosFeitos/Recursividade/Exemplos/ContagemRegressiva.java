package ExercíciosFeitos.Recursividade.Exemplos;

public class ContagemRegressiva {

    public static void contagem(int n) {
        if (n < 0) {
            return;
        }
        System.out.println(n);
        contagem(n - 1);
    }

    public static void main(String[] args) {
        contagem(10);
    }
}