package model;

public abstract class ContaBancaria {
	private String cliente;
	private int numConta;
	private float saldo;
	
	public ContaBancaria() {
		// TODO Auto-generated constructor stub
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void sacar(float valor) throws Exception{
		if (valor > saldo) {
			throw new Exception("Saldo negativo, valor inválido");
		}else {
			this.saldo -= valor;
		}
	}
	
	public void depositar(float valor) {
		if(valor < 0) {
			this.saldo += (valor * -1);
		}
		else {
			this.saldo += valor;
		}
	}
}
