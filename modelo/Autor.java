package biblioteca.modelo;

public class Autor {
	private int codAutor;
	private String nomeCompleto;
	private String cpf;
	private String matricula;
	private String email;
	private String telefone;
	private String campus;
	
	public int getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(int codAutor) {
		this.codAutor = codAutor;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	public String DadosBasicos() {
		return "Nome: " +nomeCompleto+ 
				"\nMatrícula: " +this.matricula+
				"\nCampus: " +this.campus;
	}
}
