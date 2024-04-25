package model;

public class ContaEspecial extends ContaBancaria{
	private float limite;
	
	public ContaEspecial() {
		super();
	}
	
	public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) throws ArithmeticException{
       if(valor > getSaldo() + limite){
           throw new ArithmeticException("Limite máximo atingido!");
       }else {
           setSaldo(getSaldo() - valor);
       }
    }

	@Override
	public String toString() {
		return getCliente() + ";" + getNumConta() + ";" + getSaldo() + ";" + limite;
	}
    
    

}
