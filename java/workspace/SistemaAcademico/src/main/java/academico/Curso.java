package academico;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String nome;
	private Integer numSemestres;
	
	@OneToMany //(mappedBy = "Curso")
	List<Estudante> listaEstudantes;
	
	public Curso() {
	}

	public Curso(String nome, Integer numSemestres) {
		this.nome = nome;
		this.numSemestres = numSemestres;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumSemestres() {
		return numSemestres;
	}

	public void setNumSemestres(Integer numSemestres) {
		this.numSemestres = numSemestres;
	}

	@Override
	public String toString() {
		return "Curso [Id=" + Id + ", nome=" + nome + ", numSemestres=" + numSemestres + ", listaEstudantes="
				+ listaEstudantes + "]";
	}

}
