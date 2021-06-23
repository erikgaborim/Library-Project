package biblioteca.modelo;

import java.util.Date;

public class Emprestimo {
	private Date dataDeEmprestimo = new Date();
	private Date dataDeDevolucao;
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}
	
	public Date getDataDeDevolucao() {
		return dataDeDevolucao;
	}
	public void setDataDeDevolução(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}
}
