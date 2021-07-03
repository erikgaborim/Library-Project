package biblioteca.modelo;

import java.util.Date;

public class Emprestimo {
	private Date dataDeEmprestimo = new Date();
	private Date dataDeDevolucao;
	private Livro livro;
	private Cliente cliente;
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}
	
	public Date getDataDeDevolucao() {
		return dataDeDevolucao;
	}
	public void setDataDeDevolucao(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
