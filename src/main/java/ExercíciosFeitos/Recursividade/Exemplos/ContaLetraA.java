package ExercíciosFeitos.Recursividade.Exemplos;

public class ContaLetraA {
    public static int contarA(String texto) {
        if (texto.isEmpty()) {
            return 0;
        }
        char primeira = texto.charAt(0);
        int resto = contarA(texto.substring(1));

        if (primeira == 'a' || primeira == 'A')
        {
            return 1 + resto;
        }
        else {
            return resto;
        }
    }
    public static void main(String[] args) {
        String frase = "Java avancado";
        int quantidade = contarA(frase);
        System.out.println("Quantidade de a: " + quantidade);;
    }
}
