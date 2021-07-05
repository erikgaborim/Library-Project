package biblioteca.modelo;

public class ClienteAluno extends Cliente {
	private String instituicao;
	private String curso;
	
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
