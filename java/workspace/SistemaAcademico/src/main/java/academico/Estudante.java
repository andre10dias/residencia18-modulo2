package academico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Estudante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String email;
	private String matricula;
	
	@ManyToOne
	private Curso curso;
	
	public Estudante() {}
	
	public Estudante(String nome, String email, String matricula) {
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	
	public Estudante(String nome, String email, String matricula, Curso curso) {
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", "
				+ "email=" + email + ", matricula=" + matricula + "]";
	}
	
}
