package biblioteca.modelo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Biblioteca {

	private ArrayList<Livro> bib = new ArrayList<Livro>();
	ArrayList<Autor> listaAutores = new ArrayList<Autor>();
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public ArrayList<Livro> listaDosLivros() {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		for(Livro livro : bib) {
			lista.add(livro);
		}
		return lista;
	}
	
	public void adicionarLivro(Livro livro, int qnt) {
		for(int i=0; i<qnt; i++) {
			bib.add(livro);
		}
	}
	
	public void removerLivro(Livro livro) {
		bib.remove(livro);
	}
	
	public ArrayList<Livro> pesquisarTitulo(String title) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		for(Livro livro : bib) {
			if(livro.getTitulo().toUpperCase().contains(title.toUpperCase())) {
				lista.add(livro);
			}
		}
		return lista;
	}
	
	public ArrayList<Livro> pesquisarAutor(String autor){
		ArrayList<Livro> lista = new ArrayList<Livro>();
		for(Livro livro : this.bib) {
			if(livro.getAutor().getNomeCompleto().toUpperCase().contains(autor.toUpperCase())) {
				lista.add(livro);
			}
		}
		return lista;
	}
	
	public ArrayList<Autor> leituraArquivoAutores() throws FileNotFoundException {
		
		String caminho = System.getProperty("user.dir");
		caminho = caminho + "/src/biblioteca/modelo/autores.txt";
		FileInputStream arquivo = new FileInputStream(caminho);
		try {
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader buffer = new BufferedReader(input);
			String linha = buffer.readLine();
			
			while (linha != null) {
				String[] atributos = linha.split(";");				
				linha = buffer.readLine();
				
				AutorProfessor autProf = new AutorProfessor();
				
				AutorAluno autAluno = new AutorAluno();
				
				int tipoAutorConv = Integer.parseInt(atributos[1]);
				
				if(tipoAutorConv == 1) {	
					int codAutorConv = Integer.parseInt(atributos[0]);
					int tipoContratoConv = Integer.parseInt(atributos[9]);
					int dedicacaoConv = Integer.parseInt(atributos[11]);
					
					autProf.setNomeCompleto(atributos[2]);
					autProf.setCpf(atributos[3]);
					autProf.setEmail(atributos[4]);
					autProf.setTelefone(atributos[5]);
					autProf.setCampus(atributos[6]);
					autProf.setMatricula(atributos[7]);
					autProf.setFormacao(atributos[8]);
					autProf.setTipoContrato(tipoContratoConv);
					autProf.setAreaAtuacao(atributos[10]);
					autProf.setDedicacao(dedicacaoConv);
					
					this.listaAutores.add(codAutorConv, autProf);
					
				}else if(tipoAutorConv == 2) {
					int codAutorConv = Integer.parseInt(atributos[0]);
					int situacaoConv = Integer.parseInt(atributos[9]);
					
					autAluno.setNomeCompleto(atributos[2]);
					autAluno.setCpf(atributos[3]);
					autAluno.setEmail(atributos[4]);
					autAluno.setTelefone(atributos[5]);
					autAluno.setCampus(atributos[6]);
					autAluno.setMatricula(atributos[7]);
					autAluno.setCurso(atributos[8]);
					autAluno.setSituacao(situacaoConv);
					
					this.listaAutores.add(codAutorConv, autAluno);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} 
		return listaAutores;
	}
	
	public void leituraArquivoAcervo() throws FileNotFoundException{
		
		String caminhoAcervo = System.getProperty("user.dir");
		caminhoAcervo = caminhoAcervo + "/src/biblioteca/modelo/acervo.txt";
		FileInputStream arquivoAcervo = new FileInputStream(caminhoAcervo);
		
		try {
			InputStreamReader inputAcervo = new InputStreamReader(arquivoAcervo);
			BufferedReader buffer = new BufferedReader(inputAcervo);
			String linhaAcervo = buffer.readLine();
			
			while (linhaAcervo != null) {
				String[] atributos = linhaAcervo.split(";");
				linhaAcervo = buffer.readLine();
				
				Livro liv = new Livro();
				
				int areaConv = Integer.parseInt(atributos[3]);
				int codAreaConv = Integer.parseInt(atributos[4]);
				double precoConv = Double.parseDouble(atributos[5]);
				int qntdCopiasConv = Integer.parseInt(atributos[6]);
				
				
				liv.setTitulo(atributos[0]);
				liv.setIsbn(atributos[1]);
				liv.setEditora(atributos[2]);
				liv.setArea(areaConv);
				liv.setAutor(listaAutores.get(codAreaConv));
				liv.setPreco(precoConv);
				
				this.adicionarLivro(liv, qntdCopiasConv);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ArrayList<Cliente> leituraArquivoClientes() throws FileNotFoundException {
		
		String caminhoClientes = System.getProperty("user.dir");
		caminhoClientes = caminhoClientes + "/src/biblioteca/modelo/clientes.txt";
		FileInputStream arquivoClientes = new FileInputStream(caminhoClientes);
		
		try {
			
			InputStreamReader inputClientes = new InputStreamReader(arquivoClientes);
			BufferedReader buffer = new BufferedReader(inputClientes);
			String linhaClientes = buffer.readLine();
			
			while (linhaClientes != null) {
				String[] atributos = linhaClientes.split(";");
				linhaClientes = buffer.readLine();
				
				Cliente cliente = new Cliente();
				ClienteAluno clienteAluno = new ClienteAluno();
				ClienteProf clienteProf = new ClienteProf();
				
				if(Integer.parseInt(atributos[1]) == 1) {
					cliente.setCodigo(Integer.parseInt(atributos[0]));
					cliente.setNomeCompleto(atributos[2]);
					cliente.setCpf(atributos[3]);
					cliente.setEmail(atributos[4]);
					cliente.setTelefone(atributos[5]);
					cliente.setEndereço(atributos[6]);
					
					this.listaClientes.add(Integer.parseInt(atributos[0]), cliente);
					
				}else if(Integer.parseInt(atributos[1]) == 2) {
					clienteAluno.setCodigo(Integer.parseInt(atributos[0]));
					clienteAluno.setNomeCompleto(atributos[2]);
					clienteAluno.setCpf(atributos[3]);
					clienteAluno.setEmail(atributos[4]);
					clienteAluno.setTelefone(atributos[5]);
					clienteAluno.setEndereço(atributos[6]);
					clienteAluno.setInstituicao(atributos[7]);
					clienteAluno.setCurso(atributos[8]);
					
					this.listaClientes.add(Integer.parseInt(atributos[0]), clienteAluno);
					
				}else if(Integer.parseInt(atributos[1]) == 3) {
					clienteProf.setCodigo(Integer.parseInt(atributos[0]));
					clienteProf.setNomeCompleto(atributos[2]);
					clienteProf.setCpf(atributos[3]);
					clienteProf.setEmail(atributos[4]);
					clienteProf.setTelefone(atributos[5]);
					clienteProf.setEndereço(atributos[6]);
					clienteProf.setInstituicao(atributos[7]);
					clienteProf.setFormacao(atributos[8]);
					
					this.listaClientes.add(Integer.parseInt(atributos[0]), clienteProf);
				} else {
					System.out.println("Código de tipo de cliente inválido!");
				}
			}
			
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return listaClientes;
	}
}
