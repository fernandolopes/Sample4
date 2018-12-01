package Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Models.Jogador;

public class JogadorController {

	EntityManagerFactory emf;
	EntityManager mf;
	
	public JogadorController() {
		emf = Persistence.createEntityManagerFactory("jogador");
		mf = emf.createEntityManager();
	}
	
	public void inserir(Jogador jogador) {
		
		try {
			mf.getTransaction().begin();
			mf.persist(jogador);
			mf.getTransaction().commit();
		} catch(Exception ex) {
			mf.getTransaction().rollback();
		}
		//mf.close();
	}
	
	public List<Jogador> lista() {
		try {
			mf.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Jogador> lista = mf.createQuery(
		            "SELECT p FROM Jogador p").getResultList();
			mf.getTransaction().commit();
			return lista;
		}
		catch(Exception ex) {}
		return null;
	}
	
	public Jogador buscar(Long id) {
		Jogador jogador = null;
		try {
			jogador = mf.find(Jogador.class, id);
		}
		catch(Exception ex) {
			return null;
		}
		//mf.close();
		return jogador;
	}
	
	public void atualizar(Jogador jogador) {
		try {
			mf.getTransaction().begin();
			mf.merge(jogador);
			mf.getTransaction().commit();
		}
		catch(Exception ex) {
			mf.getTransaction().rollback();
		}
		//mf.close();
	}

	public void apagar(Jogador jogador) {
		mf.getTransaction().begin();
		if(jogador != null)
			mf.remove(jogador);
		mf.getTransaction().commit();
		//mf.close();
	}
	
	public void diposable() {
		mf.close();
	}
	
}
