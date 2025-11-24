package ExercíciosPoo;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Juliana Ju", "123.456.789-00");
        Carro c = new Carro("Volkswagen", "Passat", "Amarelo queimado", 1974 , 200.0, p);

        System.out.println(c);
        System.out.println("Proprietário do carro: " + c.getProprietario());
        System.out.println("Tempo de uso do carro: " + c.calcularTempoDeUsoEmAnos());
        System.out.printf("Valor de revenda: R$ %.2f%n", c.calcularValorRevenda());
        System.out.printf("IPVA: R$ %.2f%n", c.calcularIpva());
    }
}