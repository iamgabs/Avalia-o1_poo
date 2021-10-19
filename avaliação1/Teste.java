package aulas.avaliação1;

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
		Poupança p = null;
		
		//array de contas
		ArrayList<Conta> contas = new ArrayList<Conta>(); 
		
		//variaveis
		String nome, cpf, nomeDaAgencia;
		int opt, numAgencia, numeroDaConta = 0;
		double saldo = 0, juros = 0;
		
		do {
			System.out.println("Para cadastrar uma nova conta, digite 1; \n"+
					"Para realizar um depósito, digite 2; \n"+
					"Para render júros, digite 3; \n"+
					"Para consultar número e nome de uma agência, digite 4; \n"+
					"Para alterar número e nome da agência, digite 5; \n"+
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
				System.out.println("Informe o nome da agência: ");
				nomeDaAgencia = sc.nextLine();
				System.out.println("Informe o número da agência: ");
				numAgencia = sc.nextInt();
				sc.nextLine();
				//incrementação para o número da conta 
				numeroDaConta += 1;
				
				System.out.println("Informe 1 para conta normal e 2 para conta poupança.");
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
					contas.add(p = new Poupança(numeroDaConta, saldo, c, b, juros));
				}
				else 
					System.out.println("O tipo de conta não existe!");
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
					if(contas.get(i) instanceof Poupança) {
						if(((Poupança) contas.get(i)).getCliente().getCpf().equals(vCpf)) {
							System.out.println("Informe o valor do juros: ");
							juros = sc.nextDouble();
							((Poupança) contas.get(i)).setJuros(juros);
							System.out.println("R$: "+ ((Poupança) contas.get(i)).renderJuros());
						}
					}
				}
				break;
			case 4:
				System.out.println("Informe o cpf do cliente: ");
				String v2Cpf = sc.nextLine();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i).getCliente().getCpf().equals(v2Cpf)) {
						System.out.println("Nome da agência: "+ contas.get(i).getBanco().getNomeDaAgencia());
						System.out.println("Número da agência: "+ contas.get(i).getBanco().getNumeroDaAgencia());
					}
				}
				break;
			case 5:
				System.out.println("Informe o nome do cliente: ");
				String vNome = sc.nextLine();
				for(int i=0; i<contas.size(); i++) {
					if(contas.get(i).getCliente().getNome().equals(vNome)) {
						System.out.println("Informe o nome da nova agência: ");
						String nomeNovaAgencia = sc.nextLine();
						System.out.println("Informe o número da nova agência: ");
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
