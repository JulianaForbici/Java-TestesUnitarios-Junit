package ExerciciosPoo.Carro;

import java.time.Year;

public class Carro {

    private String fabricante;
    private String modelo;
    private String cor;
    private int anoFabricacao;
    private double precoCompra;
    private Pessoa proprietario;

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

    public int calcularTempoDeUsoEmAnos() {
        int anoAtual = Year.now().getValue();
        int anos = anoAtual - anoFabricacao;
        if (anos < 0) {
            return 0;
        }
        return anos;
    }
    // carros com 20 anos ou mais, sem valor de revenda (regra de negocio)
    public double calcularValorRevenda() {
        int anos = calcularTempoDeUsoEmAnos();
        if (anos >= 20) {
            return 0.0;
        }
        // calcula 0.95^anos por multiplicação iterativa
        // uma depreciação de 5% por ano equivale a multiplicar o valor do ano anterior por 0.95 (1 − 0.05)
        // em vez de usar uma função de potência, calculei o 0.95^anos multiplicando repetidamente por 0.95 dentro de um laço
        // poderia ter usado o  Math.pow pra ser mais legivel
        double fator = 1.0;
        for (int i = 0; i < anos; i++) {
            fator = fator * 0.95;
        }
        double valor = precoCompra * fator;

        // nunca retornar valor negativo (embora não deva acontecer aqui)
        if (valor < 0.0) {
            return 0.0;
        }
        return valor;
    }
    // se o carro tiver mais de 10 anos, IPVA = 0.0 (isenção por idade, regra do exercício)
    // caso contrário, IPVA = 4% do valor de revenda
    public double calcularIpva() {
        int anos = calcularTempoDeUsoEmAnos();
        if (anos > 10) {
            return 0.0;
        }
        double valorRevenda = calcularValorRevenda();
        return valorRevenda * 0.04;
    }
   // representação em string do carro pra formatação
    @Override
    public String toString() {
        return fabricante + " " + modelo + " (" + anoFabricacao + ") || " + cor;
    }

    public static void main(String[] args) {
        Pessoa proprietario = new Pessoa("Juliana F", "111.567.111-11");
        Carro carro = new Carro("Volkswagen", "Fusca", "Azul", 2015, 60000.0, proprietario);

        System.out.println("Proprietário: " + carro.getProprietario());
        System.out.println("Carro: " + carro);
        System.out.println("Tempo de uso: " + carro.calcularTempoDeUsoEmAnos());
        System.out.printf("Valor de revenda: R$ %.2f%n", carro.calcularValorRevenda());
        System.out.printf("IPVA: R$ %.2f%n", carro.calcularIpva());
    }
}