package ExerciciosPoo.Banco;

public class ContaBancaria {
    private int numero;
    private int agencia;
    private double saldo;
    private TipoConta tipoConta;

    // construtor vai receber todos os atributos e validações
    public ContaBancaria(int numero, int agencia, double saldo, TipoConta tipoConta) {
        setTipoConta(tipoConta);
        setAgencia(agencia);
        setNumero(numero);
        setSaldo(saldo);
    }
    // ao depositar um valor, vai aceitar somente números positivos
     public boolean depositar(double valor){
        if( valor > 0) {
            saldo += valor;
            return true;
        }
        else {
            return false;
        }
    }
    // ao sacar um valor, vai permitir somente se for válido e houver saldo suficiente
    public boolean sacar(double valor){
        if (valor <= 0) {
            return false;
        }

        double taxa;
        if (tipoConta == TipoConta.CONTA_CORRENTE){
            taxa = 0.50;
        } else {
            taxa = 0.0;
        }

        double valorTotal = valor + taxa;

        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            return true;
        }
        return false;
    }

    // getters
    public int getNumero() {
        return numero;
    }

    public int getAgencia(){
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    // setters
    public void setTipoConta(TipoConta tipoConta) {
        if (tipoConta == null) {
            throw new IllegalArgumentException("O tipo da conta não pode ser vazio!");
        }
        this.tipoConta = tipoConta;
    }
    public void setNumero(int numero) {
        if ( numero < 0) {
            throw new IllegalArgumentException("Número da conta deve ser maior ou igual a 0!");
        }
        this.numero = numero;
    }

    public void setAgencia(int agencia) {
        if (agencia < 0) {
            throw new IllegalArgumentException("O número da agência deve ser maior ou igual a 0!");
        }
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0){
            throw new IllegalArgumentException("O saldo inicial da conta não deve ser negativo!");
        }
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return String.format("Conta: %d | Agência: %d | Tipo: %s | Saldo: R$%.2f",
                numero, agencia, tipoConta, saldo);
    }

    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaBancaria(0, 1, 100.0, TipoConta.CONTA_CORRENTE);
        ContaBancaria contaPoupanca = new ContaBancaria(1, 2, 10.0, TipoConta.POUPANCA);
        System.out.println(contaCorrente);
        contaCorrente.depositar(50);
        contaPoupanca.sacar(20);
        System.out.println(contaCorrente);
        System.out.println(contaPoupanca);
    }
}
