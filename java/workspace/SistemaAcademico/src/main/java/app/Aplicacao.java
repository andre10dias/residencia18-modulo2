package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DTO.EstudanteDTO;
import academico.Curso;
import academico.Estudante;

public class Aplicacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		mostrarEstudantesPorCurso(em);
//		mostrarEstudantesPorCurso(em);
//		listarCursosAteNoveSemestres(em);
//		listarTodosEstudantesDTO(em);
//		listarNomesEstudantes(em);
//		getEstudanteById(em, null);
//		listarTodosEstudantes(em);
//		preparaBD(em);
//		System.out.println(buscarEstudante(em, 2));
//		removerEstudante(em, 4);
//		atualizarEstudante(em, 3);
	}
	
	private static void atualizarEstudante(EntityManager em, Integer id) {
		Estudante e = em.find(Estudante.class, id);
		e.setNome("Tucano");
		
		em.getTransaction().begin();
		em.persist(e);
		
		em.getTransaction().commit();
	}
	
	private static void removerEstudante(EntityManager em, Integer id) {
		Estudante e = em.find(Estudante.class, id);
		
		em.getTransaction().begin();
		em.remove(e);
		
		em.getTransaction().commit();
	}
	
	private static Estudante buscarEstudante(EntityManager em, Integer id) {
		Estudante e = em.find(Estudante.class, id);
		return e;
	}
	
	private static void preparaBD(EntityManager em) {
		Curso c1 = new Curso("Matemática", 8);
		Curso c2 = new Curso("Computação", 10);
		Curso c3 = new Curso("Geografia", 8);
		
		Estudante e1 = new Estudante("Tõe", "toe@tutu", "11111", c1);
		Estudante e2 = new Estudante("Lia", "lia@tutu", "22222", c1);
		Estudante e3 = new Estudante("Tuca", "tuca@tutu", "33333", c1);
		Estudante e4 = new Estudante("Peu", "peu@tutu", "44444", c2);
		Estudante e5 = new Estudante("Leo", "leo@tutu", "55555", c2);
		Estudante e6 = new Estudante("Val", "val@tutu", "66666", c3);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.persist(e5);
		em.persist(e6);
		
		em.getTransaction().commit();
	}
	
	private static void listarTodosEstudantes(EntityManager em) {
		String jpql = "SELECT e FROM Estudante e";
		TypedQuery<Estudante> tq = em.createQuery(jpql, Estudante.class);
		
		List<Estudante> lista = tq.getResultList();
		for (Estudante estudante : lista) {
			System.out.println(estudante);
		}
	}
	
	private static void getEstudanteById(EntityManager em, Integer id) {
		String jpql = "SELECT e FROM Estudante e WHERE id = 1";
		TypedQuery<Estudante> tq = em.createQuery(jpql, Estudante.class);
		
		Estudante e = tq.getSingleResult();
		System.out.println(e);
	}
	
	private static void listarNomesEstudantes(EntityManager em) {
		String jpql = "SELECT e.nome FROM Estudante e";
		TypedQuery<String> tq = em.createQuery(jpql, String.class);
		
		List<String> lista = tq.getResultList();
		for (String nome : lista) {
			System.out.println(nome);
		}
	}
	
	private static void listarTodosEstudantesDTO(EntityManager em) {
		String jpql = "SELECT new DTO.EstudanteDTO(e.nome, e.matricula, e.curso.nome) FROM Estudante e";
		TypedQuery<EstudanteDTO> tq = em.createQuery(jpql, EstudanteDTO.class);
		
		List<EstudanteDTO> lista = tq.getResultList();
		for (EstudanteDTO estudanteDto : lista) {
			System.out.println(estudanteDto);
		}
	}
	
	private static void listarCursosAteNoveSemestres(EntityManager em) {
		String jpql = "SELECT c FROM Curso c WHERE c.numSemestres < :num";
		TypedQuery<Curso> tq = em.createQuery(jpql, Curso.class);
		tq.setParameter("num", 9);
		
		List<Curso> lista = tq.getResultList();
		for (Curso curso : lista) {
			System.out.println(curso);
		}
	}
	
	private static void mostrarEstudantesPorCurso(EntityManager em) {
		String jpql = "SELECT c FROM Curso c WHERE c.id = 1";
		TypedQuery<Curso> tq = em.createQuery(jpql, Curso.class);
		Curso c = tq.getSingleResult();
		
		String jpql2 = "SELECT e FROM Estudante e WHERE e.curso = :curso";
		TypedQuery<Estudante> tq2 = em.createQuery(jpql2, Estudante.class);
		tq2.setParameter("curso", c);
		
//		String jpql2 = "SELECT e FROM Estudante e "
//				+ "INNER JOIN Curso c ON e.curso.id = c.id "
//				+ "GROUP BY c ";
//		TypedQuery<Estudante> tq2 = em.createQuery(jpql2, Estudante.class);
		
		List<Estudante> lista = tq2.getResultList();
		for (Estudante e : lista) {
			System.out.println(e);
		}
	}

}
