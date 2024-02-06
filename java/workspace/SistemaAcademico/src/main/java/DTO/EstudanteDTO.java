package DTO;

public class EstudanteDTO {
	private String nome;
	private String matricula;
	private String nomeCurso;

	public EstudanteDTO(String nome, String matricula, String nomeCurso) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.nomeCurso = nomeCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "EstudanteDTO [nome=" + nome + ", matricula=" + matricula + ", nomeCurso=" + nomeCurso + "]";
	}

}
