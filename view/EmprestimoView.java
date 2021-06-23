package biblioteca.view;

import java.util.Scanner;

public class EmprestimoView {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Aperte:"
				+ "\n1 para empréstimo de livro"
				+ "\n0 para sair");
		int resposta = ler.nextInt();
		
		while(resposta == 1) {
			System.out.println("Aqui você teria as opções para o empréstimo\n");
			System.out.println("Aperte:"
					+ "\n1 para empréstimo de livro"
					+ "\n0 para sair");
			resposta = ler.nextInt();
		}
		System.out.println("\nObrigado. Volte sempre!");
	}
	
}
