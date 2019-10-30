package tn.esprit.service;


import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.entity.Critere;


@Stateless
@LocalBean
public class critereService {
	@PersistenceContext(unitName="Advyteam")
	EntityManager em;
	public int AddCritere (Critere e)
	{
		em.persist(e);
		
		return e.getId();
}

public List<Critere> getAllEvaluation() {
	TypedQuery<Critere>query=em.createQuery("select distinct e from Critere e",Critere.class
		);
List<Critere> result=query.getResultList();
	return result;
}

public List<String> getAllEvaluationDescription() {
	TypedQuery<String>query=em.createQuery("select e.description from Critere e",String.class
		);
List<String> result=query.getResultList();
	return result;
}
public void deleteCriId(int e) {
	em.remove(em.find(Critere.class,e));	
	
}


public void updateCritere(Critere critere) {
	em.merge(critere);
	
}
}
