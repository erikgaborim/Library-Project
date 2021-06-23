package biblioteca.modelo;

import java.util.Date;

public class Emprestimo {
	private Date dataDeEmprestimo = new Date();
	private Date dataDeDevolução;
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}
	
	public Date getDataDeDevolução() {
		return dataDeDevolução;
	}
	public void setDataDeDevolução(Date dataDeDevolução) {
		this.dataDeDevolução = dataDeDevolução;
	}
}
