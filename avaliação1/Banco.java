package aulas.avaliação1;

public class Banco {
	private int numeroDaAgencia;
	private String nomeDaAgencia;
	
	public Banco(int numeroDaAgencia, String nomeDaAgencia) {
		this.numeroDaAgencia = numeroDaAgencia;
		this.nomeDaAgencia = nomeDaAgencia;
	}

	public int getNumeroDaAgencia() {
		return numeroDaAgencia;
	}

	public void setNumeroDaAgencia(int numeroDaAgencia) {
		this.numeroDaAgencia = numeroDaAgencia;
	}

	public String getNomeDaAgencia() {
		return nomeDaAgencia;
	}

	public void setNomeDaAgencia(String nomeDaAgencia) {
		this.nomeDaAgencia = nomeDaAgencia;
	}
	
}
