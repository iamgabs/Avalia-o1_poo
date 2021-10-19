package aulas.avalia��o1;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		//scanner
		Scanner sc = new Scanner(System.in);
		
		//objetos
		Conta acc = null;
		Cliente c = null;
		Banco b = null;
		Poupan�a p = null;
		
		//array de contas
		ArrayList<Conta> contas = new ArrayList<Conta>(); 
		
		//variaveis
		String nome, cpf, nomeDaAgencia;
		int opt, numAgencia, numeroDaConta = 0;
		double saldo = 0, juros = 0;
		
		do {
			System.out.println("Para cadastrar uma nova conta, digite 1; \n"+
					"Para realizar um dep�sito, digite 2; \n"+
					"Para render j�ros, digite 3; \n"+
					"Para consultar n�mero e nome de uma ag�ncia, digite 4; \n"+
					"Para alterar n�mero e nome da ag�ncia, digite 5; \n"+
					"Para sair, digite 0;");
			System.out.println("O que deseja fazer? ");
			opt = sc.nextInt();
			sc.nextLine();
			
			switch(opt) {
			case 1:
				System.out.println("Informe o nome do cliente: ");
				nome = sc.nextLine();
				System.out.println("Informe o cpf do cliente: ");
				cpf = sc.nextLine();
				System.out.println("Informe o nome da ag�ncia: ");
				nomeDaAgencia = sc.nextLine();
				System.out.println("Informe o n�mero da ag�ncia: ");
				numAgencia = sc.nextInt();
				sc.nextLine();
				//incrementa��o para o n�mero da conta 
				numeroDaConta += 1;
				
				System.out.println("Informe 1 para conta normal e 2 para conta poupan�a.");
				int tipo = sc.nextInt();
				sc.nextLine();
				
				c = new Cliente(nome, cpf);
				b = new Banco(numAgencia, nomeDaAgencia);
				
				if(tipo == 1) {
					contas.add(acc = new Conta(numeroDaConta, saldo, c, b));
					System.out.println("Conta cadastrada com sucesso!");
				}
				else if(tipo == 2) {
					// taxa de juros inicial 0, pelo valor de saldo incial ser 0
					contas.add(p = new Poupan�a(numeroDaConta, saldo, c, b, juros));
				}
				else 
					System.out.println("O tipo de conta n�o existe!");
				break;
			case 2:
				System.out.println("Informe o cpf do cliente: ");
				String verificarCpf = sc.next();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i).getCliente().getCpf().equals(verificarCpf)) {
						System.out.println("Informe o valor que deseja depositar: ");
						double valor = sc.nextDouble();
						contas.get(i).depositar(valor);
					}
				}
				break;
			case 3:
				System.out.println("Informe o cpf do cliente: ");
				String vCpf = sc.nextLine();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i) instanceof Poupan�a) {
						if(((Poupan�a) contas.get(i)).getCliente().getCpf().equals(vCpf)) {
							System.out.println("Informe o valor do juros: ");
							juros = sc.nextDouble();
							((Poupan�a) contas.get(i)).setJuros(juros);
							System.out.println("R$: "+ ((Poupan�a) contas.get(i)).renderJuros());
						}
					}
				}
				break;
			case 4:
				System.out.println("Informe o cpf do cliente: ");
				String v2Cpf = sc.nextLine();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i).getCliente().getCpf().equals(v2Cpf)) {
						System.out.println("Nome da ag�ncia: "+ contas.get(i).getBanco().getNomeDaAgencia());
						System.out.println("N�mero da ag�ncia: "+ contas.get(i).getBanco().getNumeroDaAgencia());
					}
				}
				break;
			case 5:
				System.out.println("Informe o nome do cliente: ");
				String vNome = sc.nextLine();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i).getCliente().getNome().equals(vNome)) {
						System.out.println("Informe o nome da nova ag�ncia: ");
						String nomeNovaAgencia = sc.nextLine();
						System.out.println("Informe o n�mero da nova ag�ncia: ");
						int numNovaAgencia = sc.nextInt();
						sc.nextLine();
						contas.get(i).getBanco().setNomeDaAgencia(nomeNovaAgencia);
						contas.get(i).getBanco().setNumeroDaAgencia(numNovaAgencia);
						System.out.println("Alterado com sucesso!");
 					}
				}
				
				break;
			}
			
			
		}while(opt!=0);

	}

}
