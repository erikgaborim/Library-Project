package biblioteca.modelo;

public class ClienteProf extends Cliente{
	private String instituicao;
	private String formacao;
	
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	@Override
	public int getPrazoDevolucao() {
		return super.getPrazoDevolucao() + 35;
	}
}
