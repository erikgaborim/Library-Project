package biblioteca.modelo;

//título, isbn, autor, editora, área 
//(Ciências Exatas e da Terra, Ciências Biológicas, Engenharias, Ciências da Saúde, Ciências Humanas, 
//Ciências Agrárias, Ciências Sociais Aplicadas, Linguística, Letras e Artes). Obs: Criar códigos para as áreas

public class Livro {
	private String titulo;
	private String isbn;
	private AutorProfessor autorProf;
	private AutorAluno autorAluno;
	private String editora = "Editora IFMS";
	private int area;
	private double preco;
	private Autor autor;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getArea() {
		if(this.area == 1) {
			return ("Exatas");
		}
		if(this.area == 2) {
			return ("Humanas");
		}
		if(this.area == 3) {
			return ("Literatura");
		} 
		if(this.area == 4) {
			return ("Biológicas");
		}
		else {
			return ("Código inválido!");
		}
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	public AutorProfessor getAutorProf() {
		return autorProf;
	}
	public void setAutorProf(AutorProfessor autorProf) {
		this.autorProf = autorProf;
	}
	
	public AutorAluno getAutorAluno() {
		return autorAluno;
	}
	public void setAutorAluno(AutorAluno autorAluno) {
		this.autorAluno = autorAluno;
	}
	
	public double getPreco() {
		if(preco >= 100 && preco < 200) {
			return preco - (preco*0.1);
		}
		if(preco >= 200 && preco < 300) {
			return preco - (preco*0.2);
		}
		if(preco >= 300) {
			return preco - (preco*0.3);
		}
		else {
			return preco;
		}
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Título: " + titulo;
	}
	
}
