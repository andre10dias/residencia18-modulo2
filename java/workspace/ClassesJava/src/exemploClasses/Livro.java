package exemploClasses;

public class Livro {
	
	private String titulo;
	private String nomeAutor;
	private String editora;
	private int qtdePaginas;

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(String titulo, String nomeAutor, String editora, 
			int qtdePaginas) {
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.editora = editora;
		this.qtdePaginas = qtdePaginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getQtdePaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", nomeAutor=" + nomeAutor + ", "
				+ "editora=" + editora + ", qtdePaginas="+ qtdePaginas + "]";
	}

	public static void main(String[] args) {
		Livro livro1 = new Livro("Era uma vez", "Carlos Dias", 
				"Editora Reside", 100);
		
		System.out.println(livro1.toString());
	}

}
