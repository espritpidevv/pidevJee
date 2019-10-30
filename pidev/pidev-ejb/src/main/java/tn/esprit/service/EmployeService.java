package tn.esprit.service;


import java.util.List
;

import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.entity.Avis;
import tn.esprit.entity.Critere;
import tn.esprit.entity.Employe;
import tn.esprit.entity.Evaluation;

@Stateless
@LocalBean
public class EmployeService {
List<Evaluation> evaluations ;
	@PersistenceContext(unitName="Advyteam")
	
	EntityManager em;
	public List<Evaluation> getAllEvaluation() {
		TypedQuery<Evaluation>query=em.createQuery("select e from Evaluation e",Evaluation.class
			);
	List<Evaluation> result=query.getResultList();
		return result;
	}
	public List<Critere> recupereridEvalution(int id) {
			TypedQuery<Critere> query =em.createQuery("select c from Critere c  where c.evaluation.id=:id",Critere.class);
			query.setParameter("id",id);
			List<Critere> result=query.getResultList();

			return  result;
		
		//return 0;
	}
	public void addniveaucritere(int id, int id2, String niveau) {
		em.createQuery("update Critere  set niveau = niveau and evaluation.id=id2  where id = :id ").setParameter("id",id).executeUpdate();
		
	}
	public Critere getDescription(Critere a) {
		TypedQuery<Critere> query =em.createQuery("select c from Critere c  where c.description=:a.description",Critere.class);
		query.setParameter("id",a.getId());
		List<Critere> result=query.getResultList();

		return  (Critere) result;		}
	public void addemployeevaluation(int id, int i) {
		em.createQuery("update Evaluation  set evaluationEmploye.id ="+i+"   where id = :id ").setParameter("id",id).executeUpdate();
		em.createQuery("update Evaluation  set Traiter=1   where id = :id ").setParameter("id",id).executeUpdate();

	}
	public void addAvis(Evaluation j,String c,int e) {
		Avis v=new Avis();
		v.setEvaluation(j);
Employe		emp=em.find(Employe.class, e);
v.setEmploye(emp);		
//em.createQuery("update Avis  set employe.id = e   where evaluation.id = :j.id ").setParameter("employe.id",e).executeUpdate();
		v.setContenu(c);
		em.merge(v);
	}
	public Evaluation getEvaluationById(int id) {
			TypedQuery<Evaluation>query=em.createQuery("select distinct e from Evaluation e "+"where e.id=:id",Evaluation.class);
		query.setParameter("id", id);
		Evaluation employe=null ;
		try {
			employe=query.getSingleResult();
			
			
		}catch(NoResultException e) {Logger.getAnonymousLogger().info("employe introuvable");}
		return employe;
		
		
	}
	public Avis existe(int idemploye) {
		TypedQuery<Avis>query=em.createQuery("select distinct e from Avis e where e.employe.id =:idemploye ",Avis.class);
		query.setParameter("idemploye", idemploye);
		

		Avis Contrat=null ;
		try {
			Contrat=query.getSingleResult();
			
			
		}catch(NoResultException e) {Logger.getAnonymousLogger().info("avis introuvable");}
		return Contrat;
		
	}
	public void updatecontenu(String contenu, int idemploye) {
		em.createQuery("update Avis  set contenu = ?   where employe.id=:idemploye").setParameter("idemploye", idemploye).setParameter(1, contenu).executeUpdate();

	}
	public int getIdAvis(int idemploye) {
		TypedQuery<Integer> query=em.createQuery("select c.id from Avis c  where c.employe.id =:idemploye",Integer.class);
		query.setParameter("idemploye",idemploye);
		return query.getSingleResult();	}
	public void addEmplye(Employe emp) {
em.merge(emp);		
	}
	public Evaluation getEmployeId(int idemploye) {
		TypedQuery<Evaluation>query=em.createQuery("select e from Evaluation e "+"where e.evaluationEmploye.id=:idemploye",Evaluation.class);
		query.setParameter("idemploye", idemploye);
		Evaluation employe=null ;
		try {
			employe=query.getSingleResult();
			
			
		}catch(NoResultException e) {Logger.getAnonymousLogger().info("employe introuvable");}
		return employe;
		
		
	}
	public void updaterating(int emp, int r) {
		em.createQuery("update Employe  set rating = ?   where id=:emp").setParameter("emp", emp).setParameter(1, r).executeUpdate();
		
	}
	public List<Employe> getNomBynote() {
		TypedQuery<Employe> query =em.createQuery("select c from Employe c",Employe.class);
		List<Employe> result=query.getResultList();

		return  result;	
	}
	
		public Employe getEmployeByEmailAndPassword(String mail,String pwd)
		{
			TypedQuery<Employe> query =em.createQuery("select e from Employe e where e.email=:email and e.password=:password",Employe.class);
		    query.setParameter("email", mail);
		    query.setParameter("password", pwd);
		    
		    Employe employe=null;
		    try {
		    employe=query.getSingleResult();
		    }catch(NoResultException e) {
		    	//logger.info("Aucun employe trouve");
		    	//Logger.getLogger("Aucun employe trouve");
		    	}
		    return employe;
	     }		
	}
	
	
	

