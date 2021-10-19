package aulas.avaliação1;

public class Conta {
	private int numero;
	private double saldo;
	private Cliente cliente;
	private Banco banco;
	
	public Conta(int numero, double saldo, Cliente cliente, Banco banco) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		this.banco = banco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	// depositar
	public void depositar(double valor){
		if(valor>0) {
			this.saldo = this.saldo + valor;
			System.out.println("Valor depositado com sucesso!");
		}
		else
			System.out.println("Impssível realiza o depósito!");
	}
	
}
