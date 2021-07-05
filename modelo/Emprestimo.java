package biblioteca.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {
	private Livro livro;
	private Cliente cliente;
	private Date dataDeEmprestimo = new Date();
	private LocalDate dataDeDevolucao = LocalDate.now();
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}
	
	public LocalDate getDataDeDevolucao() {
		if(cliente instanceof ClienteAluno) {
			return dataDeDevolucao.plusDays(30);
		}
		else if(cliente instanceof ClienteProf){
			return dataDeDevolucao.plusDays(45);
		}
		else {
			return dataDeDevolucao.plusDays(10);
		}
	}
	public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
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
