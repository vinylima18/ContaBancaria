import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String nome;
		String id;
		System.out.println("Digite seu nome: ");
		nome=sc.nextLine();
		System.out.println("Digite seu ID");
		id=sc.nextLine();
 BankAccount contaTeste = new BankAccount(nome, id);
 contaTeste.mostrarMenu();
	}

}

class BankAccount {

	int saldo;
	int transacaoAnterior;
	String nomeCliente;
	String idCliente;
	
	
	BankAccount(String nomeC, String idC ) {
		
		nomeCliente= nomeC;
		idCliente=idC;
		
		
	}

	void depositar(int valor) {

		if (valor != 0) {
			saldo = saldo + valor;
			transacaoAnterior = valor;
		}

	}

	void sacar(int valor) {
		if (valor != 0) {
			saldo = saldo - valor;
			transacaoAnterior = -valor;
		}
	}

	void pegarTransacaoAnterior() {
		if (transacaoAnterior > 0) {
			System.out.println("Deposited: " + transacaoAnterior);
		}
		else if(transacaoAnterior < 0) {
			System.out.println("Saque de: "+Math.abs(transacaoAnterior));  //Math.abs deixa o valor positivo
		}
		else {
			System.out.println("Nenhuma transação feita!");
		}
	}
	
	
	void mostrarMenu() {
		char opcao='\0'; // mesma coisa de nulo ou 0 quando são numeros
		
		Scanner sc = new Scanner (System.in);
		
		
		System.out.println("Bem vindo "+nomeCliente);
		System.out.println("Seu ID é: "+idCliente);
		System.out.println("\n");
		System.out.println("A. VERIFICAR SALDO");
		System.out.println("B. Depositar");
		System.out.println("C. Sacar");
		System.out.println("D. Transação Anterior");
		System.out.println("E. SAIR/FINALIZAR");
		
		
		
		do {
			System.out.println("==========================================================================");
			System.out.println("Digite uma opção");
			System.out.println("==========================================================================");
			opcao=sc.next().charAt(0);
			System.out.println("\n");
			
			switch(opcao) {
			case 'a' :
				
				System.out.println("=====================================");
				System.out.println("Saldo: "+saldo);
				System.out.println("=====================================");
				System.out.println("\n");
				break;
				
				
			case 'b' :
				System.out.println("=====================================");
				System.out.println("Digite um valor para DEPOSITAR");
				System.out.println("=====================================");
				int valor=sc.nextInt();
				depositar(valor);
				System.out.println("\n");
				break;
				
			case 'c' :
				System.out.println("=====================================");
				System.out.println("Digite um valor para SACAR");
				System.out.println("=====================================");
				int valor2=sc.nextInt();
				sacar(valor2);
				System.out.println("\n");
				break;
				
			case 'd' :
				
				System.out.println("=====================================");
				pegarTransacaoAnterior();
				System.out.println("=====================================");
				System.out.println("\n");
				break;
				
			case 'e' :
				System.out.println("===============================================");
				break;
				
				default:
					
				System.out.println("Opção INVALIDA! Tente novamente :)");
				break;
				
			}
				
			} while (opcao != 'e');
			System.out.println("OBRIGADO POR USAR ESTE SERVIÇO :)");
			
			
		
		}
		
	}
	

