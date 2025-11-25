package Recursividade.Exemplos;

public class PalindromoRecursivo {
    public static boolean ehPalindromo(String texto) {
        texto = texto.replace(" ", "").toLowerCase();
        if (texto.length() <= 1) {
            return true;
        }

        char primeira = texto.charAt(0);
        char ultima = texto.charAt(texto.length() - 1);

        if (primeira != ultima) {
            return false;
        }

        String meio = texto.substring(1, texto.length() - 1);
        return ehPalindromo(meio);
    }
    public static void main(String[] args) {
        System.out.println(ehPalindromo("arara"));
        System.out.println(ehPalindromo("java"));
    }
}
