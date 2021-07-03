package biblioteca.view;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import biblioteca.modelo.Autor;
import biblioteca.modelo.AutorAluno;
import biblioteca.modelo.AutorProfessor;
import biblioteca.modelo.Biblioteca;
import biblioteca.modelo.Cliente;
import biblioteca.modelo.ClienteAluno;
import biblioteca.modelo.ClienteProf;
import biblioteca.modelo.Emprestimo;
import biblioteca.modelo.Livro;

public class teste2 {
public static void main(String[] args) throws ParseException, FileNotFoundException {

	Scanner ler = new Scanner(System.in);
	
	
	
	Biblioteca lib = new Biblioteca();
	
	
	System.out.println("\n==========LISTA DE TODOS OS AUTORES CADASTRADOS==========");
	ArrayList<Autor> listaAutores = lib.leituraArquivoAutores();

	for(Autor autor : listaAutores) {
		System.out.println("=> " + autor.getNomeCompleto());
	}
	
	//CHAMADA DO MÉTODO DE LEITURA DO ARQUIVO ACERVO
	lib.leituraArquivoAcervo();
	
	System.out.println("\n==========LISTA DE TODOS OS LIVROS CADASTRADOS==========");
	ArrayList<Livro> listaGeral = lib.listaDosLivros();
	for(Livro livro : listaGeral) {
		System.out.println("=> " + livro);
	}
	
	System.out.println("\n==========LISTA DE TODOS OS CLIENTES CADASTRADOS==========");
	ArrayList<Cliente> listaGeralClientes = lib.leituraArquivoClientes();
	if(listaGeralClientes.isEmpty()) {
		System.out.println("Lista vazia!");
	} else {
		for(Cliente clientess : listaGeralClientes) {
			System.out.println("=> " +clientess.getNomeCompleto());
		}
	}
	
	System.out.println("\n==========BUSCA POR TÍTULO==========");
	ArrayList<Livro> lista = lib.pesquisarTitulo("pedag");
	if(lista.isEmpty()) {
		System.out.println("Nenhum resultado encontrado");
	}
	else {
		for(Livro livro: lista) {
			System.out.println("=> " + livro);
		}
	}
	
	System.out.println("\n==========BUSCA POR AUTOR==========");
	ArrayList<Livro> lista2 = lib.pesquisarAutor("eri");
	if(lista2.isEmpty()) {
		System.out.println("Nenhum resultado encontrado");
	}
	else {
		for(Livro livro: lista2) {
			System.out.println("=> " + livro);
		}
	}
	}
}
