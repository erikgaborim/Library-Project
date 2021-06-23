package biblioteca.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.modelo.*;

import java.util.Date;

public class Teste {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("==========TESTE DE DATA=========");
		Emprestimo empr = new Emprestimo();
		System.out.println("Data: " +empr.getDataDeEmprestimo());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Data formatada: " +formato.format(empr.getDataDeEmprestimo()));
		
		Date novaData = formato.parse("10/06/1822 14:39:55");
		System.out.println("Nova Data: " + novaData);	
		System.out.println("Data: " +formato.format(novaData));
		
		AutorProfessor autorProf = new AutorProfessor();
		autorProf.setNomeCompleto("Fábio Faria da Silva");
		autorProf.setCpf("888.888.888-88");
		autorProf.setEmail("fabio.silva@ifms.edu.br");
		autorProf.setTelefone("(67) 97777-7777");
		autorProf.setCampus("Campo Grande");
		autorProf.setMatricula("1001");
		autorProf.setFormacao("Linguagens de Programação");
		autorProf.setTipoContrato(2);
		autorProf.setAreaAtuacao("Linguagens de Programação");
		autorProf.setDedicacao(3);
		
		Livro livroProf = new Livro();
		livroProf.setTitulo("Minha Harmonia: uma ferramenta de apoio no aprendizado musical");
		livroProf.setIsbn("12345");
		livroProf.setEditora("Editora IFMS");
		livroProf.setArea(1);
		livroProf.setAutor(autorProf);
		livroProf.setPreco(20);
		
		
		AutorAluno autorAluno = new AutorAluno();
		autorAluno.setNomeCompleto("Erik Gaborim Fernandes Pereira");
		autorAluno.setCpf("123.456.789-10");
		autorAluno.setEmail("erik.pereira@estudante.ifms.edu.br");
		autorAluno.setTelefone("(67) 99999-9999");
		autorAluno.setCampus("Campo Grande");
		autorAluno.setMatricula("123");
		autorAluno.setCurso("Informática");
		autorAluno.setSituacao(1);
		
		Livro livroAluno = new Livro();
		livroAluno.setTitulo("Antropologia da Semiótica: uma breve análise a partir da tradição francesa");
		livroAluno.setIsbn("456");
		livroAluno.setEditora("Editora IFMS");
		livroAluno.setArea(3);
		livroAluno.setAutor(autorAluno);
		livroAluno.setPreco(50);
		
		Biblioteca lib = new Biblioteca();
		lib.adicionarLivro(livroProf, 3);
		lib.adicionarLivro(livroAluno, 3);

		lib.removerLivro(livroProf);
		lib.removerLivro(livroAluno);
		lib.removerLivro(livroAluno);
		
		
		
		
		Cliente cliente = new Cliente();
		cliente.setNomeCompleto("Antonio Carlos Jobim");
		cliente.setCpf("11122334455667");
		cliente.setTelefone("1111111111");
		cliente.setEmail("tomjobim@gmail.com");
		cliente.setEndereco("Rua Nascimento Silva 107, Rio de Janeiro, Rio de Janeiro");
		
		ClienteAluno clienteAluno = new ClienteAluno();
		clienteAluno.setNomeCompleto("Jean Baptiste Deschamps");
		clienteAluno.setCpf("11122334455667");
		clienteAluno.setTelefone("1111111111");
		clienteAluno.setEmail("jean.deschamps@estudante.ifms.edu.br");
		clienteAluno.setEndereco("Rua do Sucre 583, Campo Grande, Mato Grosso do Sul");
		
		ClienteProf clienteProf = new ClienteProf();
		clienteProf.setNomeCompleto("Luiz Fernando Lomba");
		clienteProf.setCpf("10987654321");
		clienteProf.setTelefone("222222222");
		clienteProf.setEmail("luiz.lomba@ifms.edu.br");
		clienteProf.setEndereco("Rua Taquari 831, Campo Grande, Mato Grosso do Sul");
		
		
		
		System.out.println("\n==========LISTA DE TODOS OS AUTORES CADASTRADOS==========");
		ArrayList<Autor> listaAutores = lib.leituraArquivoAutores();
		listaAutores.add(autorAluno);
		listaAutores.add(autorProf);
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
		listaGeralClientes.add(clienteProf);
		listaGeralClientes.add(clienteAluno);
		listaGeralClientes.add(cliente);
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