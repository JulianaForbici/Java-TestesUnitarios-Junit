package ExerciciosPoo.Carro;

import java.time.Year;

public class Carro {

    private String fabricante;
    private String modelo;
    private String cor;
    private int anoFabricacao;
    private double precoCompra;
    private Pessoa proprietario;

    // construtor inicializa todos os atributos
    public Carro(String fabricante, String modelo, String cor, int anoFabricacao, double precoCompra, Pessoa proprietario){
        setProprietario(proprietario);
        setFabricante(fabricante);
        setModelo(modelo);
        setCor(cor);
        setAnoFabricacao(anoFabricacao);
        setPrecoCompra(precoCompra);
    }

    // getters
    public String getFabricante() {
        return fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public double getPrecoCompra() {
        return precoCompra;
    }
    public Pessoa getProprietario() {
        return proprietario;
    }

    // setters
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCor( String cor) {
        this.cor = cor;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }
    public void setProprietario(Pessoa proprietario){
        this.proprietario = proprietario;
    }

    // calcula o tempo de uso em anos com base no ano atual
    // se o ano de fabricacao for maior que o ano atual retorna 0
    public int calcularTempoDeUsoEmAnos() {
        int anoAtual = Year.now().getValue();
        int anos = anoAtual - anoFabricacao;
        if (anos < 0) {
            return 0;
        }
        return anos;
    }

    // calcula o valor de revenda aplicando deprecicao de 5% ao ano
    // se o carro tiver 20 anos ou mais retorna 0 conforme regra de negocio
    // usa multiplicacao iterativa para calcular 0.95^anos sem usar math pow
    public double calcularValorRevenda() {
        int anos = calcularTempoDeUsoEmAnos();
        if (anos >= 20) {
            return 0.0;
        }
        // se o preco de compra for negativo considera valor de revenda 0
        if (precoCompra < 0.0) {
            return 0.0;
        }
        // calcula o fator de deprecicao iterativamente
        double fator = 1.0;
        for (int i = 0; i < anos; i++) {
            fator = fator * 0.95;
        }
        double valor = precoCompra * fator;

        // garante que nunca retorna valor negativo
        if (valor < 0.0) {
            return 0.0;
        }
        return valor;
    }

    // calcula o ipva como 4% do valor de revenda
    // carros com mais de 10 anos sao isentos e retornam 0
    public double calcularIpva() {
        int anos = calcularTempoDeUsoEmAnos();
        if (anos > 10) {
            return 0.0;
        }
        double valorRevenda = calcularValorRevenda();
        return valorRevenda * 0.04;
    }

    @Override
    public String toString() {
        return fabricante + " " + modelo + " (" + anoFabricacao + ") || " + cor;
    }

    public static void main(String[] args) {
        Pessoa proprietario = new Pessoa("Juliana F", "111.567.111-11");
        Carro carro = new Carro("Volkswagen", "Fusca", "Azul", 2015, 60000.0, proprietario);
        System.out.println("Proprietario: " + carro.getProprietario());
        System.out.println("Carro: " + carro);
        System.out.println("Tempo de uso: " + carro.calcularTempoDeUsoEmAnos());
        System.out.printf("Valor de revenda: R$ %.2f%n", carro.calcularValorRevenda());
        System.out.printf("IPVA: R$ %.2f%n", carro.calcularIpva());
    }
}