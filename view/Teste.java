package biblioteca.view;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Aula1.Autor;
import Aula1.Emprestimo;
import biblioteca.modelo.AutorAluno;
import biblioteca.modelo.AutorProfessor;
import biblioteca.modelo.Biblioteca;
import biblioteca.modelo.Cliente;
import biblioteca.modelo.ClienteAluno;
import biblioteca.modelo.ClienteProf;
import biblioteca.modelo.Livro;

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
		cliente.setEndereço("Rua Nascimento Silva 107, Rio de Janeiro, Rio de Janeiro");
		
		ClienteAluno clienteAluno = new ClienteAluno();
		clienteAluno.setNomeCompleto("Jean Baptiste Deschamps");
		clienteAluno.setCpf("11122334455667");
		clienteAluno.setTelefone("1111111111");
		clienteAluno.setEmail("jean.deschamps@estudante.ifms.edu.br");
		clienteAluno.setEndereço("Rua do Sucre 583, Campo Grande, Mato Grosso do Sul");
		
		ClienteProf clienteProf = new ClienteProf();
		clienteProf.setNomeCompleto("Luiz Fernando Lomba");
		clienteProf.setCpf("10987654321");
		clienteProf.setTelefone("222222222");
		clienteProf.setEmail("luiz.lomba@ifms.edu.br");
		clienteProf.setEndereço("Rua Taquari 831, Campo Grande, Mato Grosso do Sul");
		
		
		//LEITURA DOS ARQUIVOS DE TEXT (.TXT) DA CLASSE BIBLIOTECA
//		System.out.println("\n==========LEITURA DO ARQUIVO AUTORES==========");
//		String caminho = System.getProperty("user.dir");
//		caminho = caminho + "/src/biblioteca/modelo/autores.txt";
//		FileInputStream arquivo = new FileInputStream(caminho);
//		try {
//			InputStreamReader input = new InputStreamReader(arquivo);
//			BufferedReader buffer = new BufferedReader(input);
//			String linha = buffer.readLine();
//			while (linha != null) {
//				String[] atributos = linha.split(";");
//				
//				int cont = 0;
//				System.out.println(linha);
//				linha = buffer.readLine();
//				
//				AutorProfessor[] autProf = new AutorProfessor[cont + 1];
//				autProf[cont] = new AutorProfessor();
//				
//				AutorAluno autAluno[] = new AutorAluno[cont + 1];
//				autAluno[cont] = new AutorAluno();
//				
//				int tipoAutorConv = Integer.parseInt(atributos[1]);
//				
//				if(tipoAutorConv == 1) {	
//					int codAutorConv = Integer.parseInt(atributos[0]);
//					int tipoContratoConv = Integer.parseInt(atributos[9]);
//					int dedicacaoConv = Integer.parseInt(atributos[11]);
//					
//					autProf[cont].setCodAutor(codAutorConv);
//					autProf[cont].setNomeCompleto(atributos[2]);
//					autProf[cont].setCpf(atributos[3]);
//					autProf[cont].setEmail(atributos[4]);
//					autProf[cont].setTelefone(atributos[5]);
//					autProf[cont].setCampus(atributos[6]);
//					autProf[cont].setMatricula(atributos[7]);
//					autProf[cont].setFormacao(atributos[8]);
//					autProf[cont].setTipoContrato(tipoContratoConv);
//					autProf[cont].setAreaAtuacao(atributos[10]);
//					autProf[cont].setDedicacao(dedicacaoConv);
//					
//					System.out.println();
//					System.out.println(autProf[cont].getCodAutor());
//					System.out.println(autProf[cont].getNomeCompleto());
//					System.out.println(autProf[cont].getCpf());
//					System.out.println(autProf[cont].getEmail());
//					System.out.println(autProf[cont].getTelefone());
//					System.out.println(autProf[cont].getCampus());
//					System.out.println(autProf[cont].getMatricula());
//					System.out.println(autProf[cont].getFormacao());
//					System.out.println(autProf[cont].getTipoContrato());
//					System.out.println(autProf[cont].getAreaAtuacao());
//					System.out.println(autProf[cont].getDedicacao());
//					System.out.println();
//				}else if(tipoAutorConv == 2) {
//					int codAutorConv = Integer.parseInt(atributos[0]);
//					int situacaoConv = Integer.parseInt(atributos[9]);
//					
//					autAluno[cont].setCodAutor(codAutorConv);
//					autAluno[cont].setNomeCompleto(atributos[2]);
//					autAluno[cont].setCpf(atributos[3]);
//					autAluno[cont].setEmail(atributos[4]);
//					autAluno[cont].setTelefone(atributos[5]);
//					autAluno[cont].setCampus(atributos[6]);
//					autAluno[cont].setMatricula(atributos[7]);
//					autAluno[cont].setCurso(atributos[8]);
//					autAluno[cont].setSituacao(situacaoConv);
//					
//					System.out.println();
//					System.out.println(autAluno[cont].getCodAutor());
//					System.out.println(autAluno[cont].getNomeCompleto());
//					System.out.println(autAluno[cont].getCpf());
//					System.out.println(autAluno[cont].getEmail());
//					System.out.println(autAluno[cont].getTelefone());
//					System.out.println(autAluno[cont].getCampus());
//					System.out.println(autAluno[cont].getMatricula());
//					System.out.println(autAluno[cont].getCurso());
//					System.out.println(autAluno[cont].getSituacao());
//					System.out.println();
//				}
//			cont++;
//			}
//		} catch (Exception e) {
//			System.out.println("Erro: " + e.getMessage());
//		} 
//		
//		System.out.println("\n==========LEITURA DO ARQUIVO ACERVO==========");
//		String caminhoAcervo = System.getProperty("user.dir");
//		caminhoAcervo = caminhoAcervo + "/src/biblioteca/modelo/acervo.txt";
//		FileInputStream arquivoAcervo = new FileInputStream(caminhoAcervo);
//		try {
//			InputStreamReader inputAcervo = new InputStreamReader(arquivoAcervo);
//			BufferedReader buffer = new BufferedReader(inputAcervo);
//			String linhaAcervo = buffer.readLine();
//			while (linhaAcervo != null) {
//				String[] atributos = linhaAcervo.split(";");
//				
//				int cont = 0;
//				System.out.println(linhaAcervo);
//				linhaAcervo = buffer.readLine();
//				
//				Livro[] liv = new Livro[cont + 1];
//				liv[cont] = new Livro();
//				
//				int areaConv = Integer.parseInt(atributos[3]);
//				int codAutorConv = Integer.parseInt(atributos[4]);
//				double precoConv = Double.parseDouble(atributos[5]);
//				int qntdCopiasConv = Integer.parseInt(atributos[6]);
//				
//				
//				liv[cont].setTitulo(atributos[0]);
//				liv[cont].setIsbn(atributos[1]);
//				liv[cont].setEditora(atributos[2]);
//				liv[cont].setArea(areaConv);
//				liv[cont].setCodAutor(codAutorConv);
//				liv[cont].setPreco(precoConv);
//				
//				System.out.println("");
//				
//				lib.adicionarLivro(liv[cont], qntdCopiasConv);				
//			}
//		} catch (Exception e) {
//			System.out.println("Erro: " + e.getMessage());
//		}
		
		System.out.println("\n==========LEITURA AUTORES==========");
		
		ArrayList<biblioteca.modelo.Autor> listaAutores = lib.leituraArquivoAutores();
		
		for(biblioteca.modelo.Autor autor : listaAutores) {
			System.out.println("=> " + autor.getNomeCompleto());
		}
		
		//CHAMADA DO MÉTODO DE LEITURA DO ARQUIVO ACERVO
		lib.leituraArquivoAcervo();
		
		System.out.println("\n==========LISTA DE TODOS OS LIVROS CADASTRADOS==========");
		ArrayList<Livro> listaGeral = lib.listaDosLivros();
		for(Livro livro : listaGeral) {
			System.out.println("=> " + livro);
		}
		
		System.out.println("\n==========BUSCA POR TÍTULO==========");
		ArrayList<Livro> lista = lib.pesquisarTitulo("pretu");
		if(lista.isEmpty()) {
			System.out.println("Nenhum resultado encontrado");
		}
		else {
			for(Livro livro: lista) {
				System.out.println("=> " + livro);
			}
		}
		
		System.out.println("\n==========BUSCA POR AUTOR==========");
		ArrayList<Livro> lista2 = lib.pesquisarAutor("erik");
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