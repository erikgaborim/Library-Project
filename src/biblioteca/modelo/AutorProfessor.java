package biblioteca.modelo;

public class AutorProfessor extends Autor{
	/*possui matrícula, formação, e-mail, telefone, campus, tipo de contrato (1 - professor substituto, 2 - Servidor), 
	Dedicação (1 - 20 horas, 2 - 40 horas, 3 - Dedicação exclusiva) e área de atuação no IF 
	(Ex.: Desenvolvimento Web, Física, Matemática, etc.) */
	
	protected String formacao;
	protected int tipoContrato;
	protected int dedicacao;
	protected String areaAtuacao;
	
	
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public String getTipoContrato() {
		if(this.tipoContrato == 1) {
			return "Professor Substituto";
		}else if(this.tipoContrato == 2) {
			return "Servidor";
		}else {
			return "O valor digitado nesse campo foi inválido! Por favor, tente novamente.";
		}
	}
	public void setTipoContrato(int tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	public String getDedicacao() {
		if(this.dedicacao == 1) {
			return "20 horas";
		}else if(this.dedicacao == 2) {
			return "40 horas";
		}else if(this.dedicacao == 3) {
			return "Dedicação Exclusiva";
		}else {
			return "O valor digitado nesse campo foi inválido! Por favor, tente novamente.";
		}
	}
	public void setDedicacao(int dedicacao) {
		this.dedicacao = dedicacao;
	}	
}
