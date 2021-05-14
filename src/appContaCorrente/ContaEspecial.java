package appContaCorrente;

public class ContaEspecial extends ContaCorrente{
    private float limite;

    public ContaEspecial(String numero, Pessoa titular,float limite) {
        super(numero, titular);
        this.limite = limite;
    }
    
      public ContaEspecial(String numero, Pessoa titular) {
        super(numero, titular);
        this.limite = 2000;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public float getSaldo() {
        return super.getSaldo()+limite;
    }
       

    @Override
    public String dados() {
        return super.dados()+
                "\nLimite R$ "+limite+
                "\nSaldo disponível R$ "+getSaldo();
    }
    
    
    
    
}
