package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entity.Projet;



 
@Stateless
@LocalBean
public class ProjetService implements ProjetServiceRemote {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int ajouter(Projet p) {
		em.persist(p); 
        return p.getId();
	}
	public Projet getProjetById(int id)
	{
		return em.find(Projet.class, id);
		
	}
	public void modifier(Projet p) {
		em.merge(p);
	}
	public void supprimer(int id)
	{	 
		em.remove(em.find(Projet.class, id));
	}
	public List<Projet> getAllProjets(){
		Query q=em.createQuery("select e from Projet e",Projet.class);
		  List<Projet> results=q.getResultList();
		  return results;
		
	}

}
