package appContaCorrente;

public class ContaCorrente {

    //Atributos
    private String numeroConta;
    private Pessoa titular;
    private float saldo;

    //Construtor
    public ContaCorrente(String numeroConta, Pessoa titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        saldo = 0;
    }

    //Métodos de Acesso
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void depositar(float valor) {
        saldo += valor;
    }
   
    public boolean sacar(float valor) {
        if (getSaldo() >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    
    
    
    public String dados() {
        return "BANCO DE TODOS S.A. \n"
                + "Conta nº " + numeroConta
                + "\nTitular: " + titular
                + "\nSaldo R$ " + saldo;
    }

}//fim da classe ContaCorrente
