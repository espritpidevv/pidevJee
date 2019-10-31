package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.Remote.FormateurSR;
import tn.esprit.entity.Formateur;

@Stateless
@LocalBean
public class FormateurSLB implements FormateurSR {
	
	@PersistenceContext(name="pidev-ejb")
	private EntityManager em;
	
	@Override
	public Formateur get(int id) {
		
		return em.find(Formateur.class, id);
	}

	@Override
	public void Add(Formateur f) {
		
		 em.persist(f);;
	}

	@Override
	public void Up(Formateur f) {
		em.merge(f);
		em.flush();
		
	}

	@Override
	public void remove(Formateur f) {
		em.remove(em.contains(f) ? f : em.merge(f));
		em.flush();
	}

	@Override
	public List<Formateur> AllByNote() {
		
		return em.createQuery("select f from Formateur order by f.note desc",Formateur.class).getResultList();
	}

	@Override
	public List<Formateur> All() {
		
		return em.createQuery("from Formateur",Formateur.class).getResultList();
	}

}
