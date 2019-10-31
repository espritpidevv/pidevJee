package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Remote.InvitationSR;
import tn.esprit.entity.Invetation;
import tn.esprit.entity.Participation;

@Stateless
@LocalBean
public class InvitationSLB implements  InvitationSR
{	
	@PersistenceContext
	private EntityManager em; 

	@Override
	public void add(Invetation invetation) {
		em.persist(invetation);
	}

	@Override
	public void up(Invetation invetation) {
		em.merge(invetation);		
	}

	@Override
	public Invetation get(int idf, int ide) {
		TypedQuery<Invetation> query = (TypedQuery<Invetation>) em.createQuery(
				"Select p from Invetation p where p.idFormation = :idf and p.idEmploye = :ide", Invetation.class);
		query.setParameter("idf", idf);
		query.setParameter("idp", ide);

		Invetation p = null;

		try {

			p = query.getSingleResult();
		} catch (Exception e) {
		}

		return p;
	}

}
