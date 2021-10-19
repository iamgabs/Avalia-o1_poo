package aulas.avalia��o1;

public class Poupan�a extends Conta{
	private double juros;

	public Poupan�a(int numero, double saldo, Cliente cliente, Banco banco, double juros) {
		super(numero, saldo, cliente, banco);
		this.juros = juros;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public double renderJuros() {
		this.setSaldo(this.getSaldo()+(this.getSaldo()*juros/100));
		return this.getSaldo();
	}
	
}
