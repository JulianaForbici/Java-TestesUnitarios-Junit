public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }
    public int subtrair(int a, int b) {
        return a - b;
    }
    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int dividir(int a, int b) {
        if (b == 0)
        {
            throw new ArithmeticException("divisão por zero!!");
        }
        return a / b;
    }
    private static int lerNumero(java.util.Scanner sc, String prompt) {
        while (true)
        {
            System.out.print(prompt);
            String linha = sc.nextLine();
            try
            {
                return Integer.parseInt(linha.trim());
            }   catch (NumberFormatException e) {
                System.out.println("Erro! Digite um número e sem double!");
            }
        }
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Calculadora calc = new Calculadora();
        int a = lerNumero(sc, "**-----Digite o primeiro valor-----**: ");
        int b = lerNumero(sc, "**-----Digite o segundo valor-----**: ");
        System.out.println("----- Resultado da soma -----: " + calc.somar(a, b));
        System.out.println("----- Resultado da subtração -----: " + calc.subtrair(a, b));
        System.out.println("----- Resultado da multiplicação -----: " + calc.multiplicar(a, b));
        try
        {
            System.out.println("----- Resultado da divisão -----: " + calc.dividir(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Erro " + e.getMessage());
        }
        sc.close();
    }
}