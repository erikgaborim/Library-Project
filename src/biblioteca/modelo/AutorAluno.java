package biblioteca.modelo;

public class AutorAluno extends Autor{
	
	//possui matrícula, curso, e-mail, telefone, campus, situação (em curso, transferido, trancado e concluído)
	
	protected String curso;
	protected int situacao;
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getSituacao() {
		if(this.situacao == 1) {
			return "Em curso";
		} else if(this.situacao == 2) {
			return "Transferido";
		} else if(this.situacao == 3) {
			return "Trancado";
		} else if(this.situacao == 4) {
			return "Concluído";
		} else {
			return "Erro: código inválido";
		}
		
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
}
