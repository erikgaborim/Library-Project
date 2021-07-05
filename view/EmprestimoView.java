package biblioteca.view;

import java.io.FileNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import biblioteca.modelo.*;


public class EmprestimoView {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner ler = new Scanner(System.in);
		
		//PERGUNTA PARA LOOP INICIAL
		System.out.println("Aperte:"
				+ "\n1 para empréstimo de livro"
				+ "\n0 para sair");
		int resposta = ler.nextInt();
		
		//LOOP
		while(resposta == 1) {
			
			Biblioteca lib = new Biblioteca();
			
			//LEITURA DO ARQUIVO AUTORES
			System.out.println("\n==========LISTA DE TODOS OS AUTORES CADASTRADOS==========");
			ArrayList<Autor> listaAutores = lib.leituraArquivoAutores();

			for(Autor autor : listaAutores) {
				System.out.println("=> " + autor.getNomeCompleto());
			}
			
			//LEITURA DO ARQUIVO ACERVO
			lib.leituraArquivoAcervo();
			System.out.println("\n==========LISTA DE TODOS OS LIVROS CADASTRADOS==========");
			ArrayList<Livro> listaGeral = lib.listaDosLivros();
			for(Livro livro : listaGeral) {
				System.out.println("=> " + livro);
			}
			
			//LEITURA DO ARQUIVO CLIENTE
			System.out.println("\n==========LISTA DE TODOS OS CLIENTES CADASTRADOS==========");
			ArrayList<Cliente> listaGeralClientes = lib.leituraArquivoClientes();
			if(listaGeralClientes.isEmpty()) {
				System.out.println("Lista vazia!");
			} else {
				for(Cliente clientess : listaGeralClientes) {
					System.out.println("=> " +clientess.getNomeCompleto());
				}
			}
			
			//BUSCA POR TITULO
			System.out.println("\n==========BUSCA POR TÍTULO==========");
			ArrayList<Livro> lista = lib.pesquisarTitulo("pretugues");
			if(lista.isEmpty()) {
				System.out.println("Nenhum resultado encontrado");
			}
			else {
				for(Livro livro: lista) {
					System.out.println("=> " + livro);
				}				
			}

			//SETANDO O LIVRO E O CLIENTE NA CLASSE EMPRESTIMO
			Emprestimo empr = new Emprestimo();
			empr.setCliente(lib.getClientes());
			for(Livro livro : lib.listaLivrosUnicos) {
				empr.setLivro(livro);
			}
			System.out.println("\n==========LIVRO E CLIENTE RELACIONADOS AO EMPRESTIMO==========");
			System.out.println("Cliente que realizara o empréstimo: " +empr.getCliente().getNomeCompleto());
			System.out.println("Livro que sera emprestado: " +empr.getLivro().getTitulo());
			
			//DATA DE EMPRESTIMO
			System.out.println("\n==========DATA=========");
			System.out.println("Data de emprestimo formato Date: " +empr.getDataDeEmprestimo());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("Data de emprestimo bonita: " +formato.format(empr.getDataDeEmprestimo()));
			
			//DATA DE DEVOLUCAO
			System.out.println("\nData de devolucao: " +empr.getDataDeDevolucao());
			Date dataDeDevolucaoFormatada = Date.from(empr.getDataDeDevolucao().atStartOfDay(ZoneId.systemDefault()).toInstant());
			System.out.println("Data de devolucao formato Date: " +dataDeDevolucaoFormatada);
			
			//REMOVENDO LIVRO EMPRESTADO DO ACERVO
			lib.removerLivro(empr.getLivro());
			
			//LEITURA DO ARQUIVO AUTORES APOS A REMOCAO DA COPIA EMPRESTADA
			System.out.println("\n==========LISTA DE TODOS OS LIVROS CADASTRADOS==========");
			ArrayList<Livro> listaGeral2 = lib.listaDosLivros();
			for(Livro livro : listaGeral2) {
				System.out.println("=> " + livro);
			}
			
			//PERGUNTAS PARA LOOP FINAL
			System.out.println("\nAperte:"
					+ "\n1 para empréstimo de livro"
					+ "\n0 para sair");
			resposta = ler.nextInt();
		}
		System.out.println("\nObrigado. Volte sempre!");
	}	
}
