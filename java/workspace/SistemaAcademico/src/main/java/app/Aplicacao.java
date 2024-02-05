package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import academico.Estudante;

public class Aplicacao {

	public static void main(String[] args) {
//		criarEstudante();
//		System.out.println(buscarEstudante(2));
//		removerEstudante(4);
		atualizarEstudante(3);
	}
	
	private static void atualizarEstudante(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		Estudante e = em.find(Estudante.class, id);
		e.setNome("Tucano");
		
		em.getTransaction().begin();
		em.persist(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void removerEstudante(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		Estudante e = em.find(Estudante.class, id);
		
		em.getTransaction().begin();
		em.remove(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static Estudante buscarEstudante(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		Estudante e = em.find(Estudante.class, id);
		
		em.close();
		emf.close();
		
		return e;
	}
	
	private static void criarEstudante() {
		Estudante e1 = new Estudante("Teste", "teste@tutu", "44444");
//		Estudante e2 = new Estudante("Lia", "lia@tutu", "22222");
//		Estudante e3 = new Estudante("Tuca", "tuca@tutu", "33333");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_academico");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(e1);
//		em.persist(e2);
//		em.persist(e3);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
