import java.math.BigInteger;

public class Fibonacci {
    // fiz um método que recebe um int e devolve o número de fibonacci
    public static BigInteger fibonacci(int numeroDigitado) {
        if (numeroDigitado < 0) {
            throw new IllegalArgumentException("O número digitado deve ser maior ou igual a 0!");
        }
        // se for 0, por definição o resultado é 0
        if (numeroDigitado == 0) {
            return BigInteger.ZERO;
        }
        // se for 1, por definição o resultado é 1
        if (numeroDigitado == 1) {
            return BigInteger.ONE;
        }
        // iterativo! vai guardar só os dois últimos termos (a,b).
        BigInteger a = BigInteger.ZERO; // F(0)
        BigInteger b = BigInteger.ONE;  // F(1)
        // o laço começa em f = 2 porque os termos F(0) e F(1) já estão definidos
        for (int f = 2; f <= numeroDigitado; f++) {
            BigInteger c = a.add(b); // F(f) = F(f - 1) + F(f - 2)
            a = b;
            b = c;
        }
        // em cada iteração o c = a + b vai calcular o próximo termo F(f)
        // e o b vira o novo f(f) pro novo loop
        return b; // F(n)
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(0)); // 0
        System.out.println(fibonacci(1)); // 1
        System.out.println(fibonacci(2)); // 1
        System.out.println(fibonacci(3)); // 2
        System.out.println(fibonacci(4)); // 3
        System.out.println(fibonacci(5)); // 5
        System.out.println(fibonacci(6)); // 8
        System.out.println(fibonacci(100)); // 354224848179261915075
    }
}