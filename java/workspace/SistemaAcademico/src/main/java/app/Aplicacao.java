package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import academico.Curso;
import academico.Estudante;

public class Aplicacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		preparaBD(em);
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

}
