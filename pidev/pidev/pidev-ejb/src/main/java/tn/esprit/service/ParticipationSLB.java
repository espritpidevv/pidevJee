package tn.esprit.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Remote.ParticipationSR;
import tn.esprit.entity.Employe;
import tn.esprit.entity.Participation;

@Stateless
@LocalBean
public class ParticipationSLB implements ParticipationSR {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void Add(Participation participation) {
		em.persist(participation);
	}

	@Override
	public void Remove(Participation participation) {
		em.remove(participation);
	}

	@Override
	public Participation get(int idf, int ide) {

		TypedQuery<Participation> query = (TypedQuery<Participation>) em.createQuery(
				"Select p from Participation p where p.idFormation = :idf and p.idEmploye = :ide", Participation.class);
		query.setParameter("idf", idf);
		query.setParameter("idp", ide);

		Participation p = null;

		try {

			p = query.getSingleResult();
		} catch (Exception e) {
		}

		return p;
	}

}
