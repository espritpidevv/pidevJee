package tn.esprit.service;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Remote.FormationSR;
import tn.esprit.entity.Employe;
import tn.esprit.entity.Formateur;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Skills;
import tn.esprit.entity.Tache;
import tn.esprit.entity.Test;

@Stateless
@LocalBean
public class FormationSLB implements FormationSR {
	
	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Formation get(int id) {
		return em.find(Formation.class, id);
	}

	@Override
	public void Add(Formation f) {
		em.persist(f);
	}

	@Override
	public void Up(Formation f) {
		em.merge(f);
	}

	@Override
	public void remove(Formation f) {
		em.remove(em.contains(f) ? f : em.merge(f));
		em.flush();
	}

	@Override
	public List<Formation> All() {
		return em.createQuery("from Formation",Formation.class).getResultList();
	}

	@Override
	public void Add_Test(Test t, int id) {
		Formation f = this.get(id);
		f.setTest(t);
	}

	@Override
	public void Add_Formateur(Formateur f, int id) {
		Formation fa = this.get(id);
		fa.setFormateur(f);
	}

	@Override
	public List<Tache> ListTByEBefor(Employe id, Date date) {
		TypedQuery<Tache> query =  em.createQuery(
				"Select t from Tache t where t.employe = :id  and t.date_fin < :date and t.isFinished = 1", Tache.class);
		query.setParameter("id", id);
		query.setParameter("date", date);
		
		return query.getResultList();
	}

	@Override
	public List<Tache> ListTByEAfter(Employe id, Date date) {
		TypedQuery<Tache> query =  em.createQuery(
				"Select t from Tache t where t.employe = :id  and t.date_debut > :date and t.isFinished = 1", Tache.class);
		query.setParameter("id", id);
		query.setParameter("date", date);
		
		return query.getResultList();
	}
	
	

	@Override
	public List<Employe> ListEBySkills(Skills s) {
		
		
		
		String q = "SELECT t.employe   FROM Tache t  JOIN t.skillss s "
				+ "WHERE s.id = :id and  t.dureeReelle > t.dureeEtimee*1.5 and t.isFinished = :f  GROUP by t.employe"
				+ " ORDER by  sum(t.dureeReelle - t.dureeEtimee ) DESC";
		
		TypedQuery<Employe> query =  em.createQuery(q,Employe.class);
		query.setParameter("id", s.getId());
		query.setParameter("f", true);
		return query.getResultList();
		
	}
	
	public Skills getS(int id)
	{
		return em.find(Skills.class, 0);
	}
	
	public List<Skills> getSA()
	{
		return em.createQuery("from Skills",Skills.class ).getResultList();
	}

}
