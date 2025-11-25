package ExercíciosPoo.Carro;

import java.time.Year;

public class Carro {

    private String fabricante;
    private String modelo;
    private String cor;
    private int anoFabricacao;
    private double precoCompra;
    private Pessoa proprietario;

    public Carro(String fabricante, String modelo, String cor, int anoFabricacao, double precoCompra, Pessoa proprietario) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabricacao = anoFabricacao;
        this.precoCompra = precoCompra;
        this.proprietario = proprietario;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public int calcularTempoDeUsoEmAnos() {
        int anoAtual = Year.now().getValue();
        int anos = anoAtual - anoFabricacao;
        return Math.max(0, anos);
    }

    public double calcularValorRevenda() {
        int anos = calcularTempoDeUsoEmAnos();
        if (anos >= 20) {
            return 0.0;
        }
        double fator = Math.pow(0.95, anos);
        double valor = precoCompra * fator;
        return Math.max(0.0, valor);
    }

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
        return fabricante + " " + modelo + " (" + anoFabricacao + "), cor: " + cor;
    }
}