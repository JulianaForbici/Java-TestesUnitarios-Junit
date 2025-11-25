package ExercíciosPoo.Banco;

public class ContaBancaria {

    int numero;
    int agencia;
    double saldo;
    TipoConta tipoConta;

    public ContaBancaria(int numero, int agencia, double saldoInicial, TipoConta tipoConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldoInicial;
        this.tipoConta = tipoConta;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        } else {
            return false; // valor <= 0
        }
    }
    public boolean sacar(double valor) {
        if (valor <= 0) {
            return false; // saque inválido
        }

        double taxa = 0.0;

        if (tipoConta == TipoConta.CONTA_CORRENTE) {
            taxa = 0.50;
        }

        double valorTotal = valor + taxa;

        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            return true;
        }
        else
        {
            return false; // saldo insuficiente
        }
    }
}
