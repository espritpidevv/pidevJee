package tn.esprit.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.entity.Projet;
import tn.esprit.entity.Tache;



@Stateless
@LocalBean
public class TacheService {
	@PersistenceContext
	EntityManager em;

	public List<Tache> getAllTaches() {
		Query q = em.createQuery("select e from Tache e", Tache.class);
		List<Tache> results = q.getResultList();
		return results;
	}
	
	public Tache getTache(int id) {
		TypedQuery<Tache>query=em.createQuery("select e from Tache e "+"where e.id=:id",Tache.class);
		query.setParameter("id", id);
		Tache employe=null ;
		try {
		employe=query.getSingleResult();


		}catch(NoResultException e) {Logger.getAnonymousLogger().info("employe introuvable");}
		return employe;
		}
	public List<Tache> getToDoTaches(Projet p) {
		Query q = em.createQuery("select e from Tache e where e.projet=:p" , Tache.class);
		q.setParameter("id",p.getId());
		List<Tache> results = q.getResultList();
		return results;
	} 
	
	public List<Tache> getBasketTaches(Projet p) {
		Query q = em.createQuery("select e from Tache e where phase is null and e.projet= :p" , Tache.class);
		List<Tache> results = q.setParameter('p', p).getResultList();
		return results;
	}
	
	public List<Tache> getDoingTaches(Projet p) {
		Query q = em.createQuery("select e from Tache e where phase='Doing' and e.projet=:p" , Tache.class);
		List<Tache> results = q.setParameter('p', p).getResultList();
		return results;
	}
	
	public List<Tache> getDoneTaches(Projet p) {
		Query q = em.createQuery("select e from Tache e where phase='Done' and projet_id=  "+p.getId(), Tache.class);
		List<Tache> results = q.getResultList();
		return results;
	}
	
	public int ajouter(Tache p) {
		em.persist(p);
		return p.getId();
	}

	public Tache getTacheById(int id) {
		return em.find(Tache.class, id);
	}

	public void supprimer(int id) {
		Tache e = em.find(Tache.class, id);
		em.remove(e);
	}
	public void modifier(Tache p) {
		em.merge(p);
	}

	

}
