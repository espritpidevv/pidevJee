package tn.esprit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.Remote.TestSR;
import tn.esprit.entity.Question;
import tn.esprit.entity.Reponce;
import tn.esprit.entity.Test;

@Stateless
@LocalBean
public class TestSLB implements TestSR{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Test get_Test(int id) {
		return em.find(Test.class, id);
	}

	@Override
	public void Add_T(Test t) {
		em.persist(t);
	}

	@Override
	public void Up_T(Test t) {
		em.merge(t);
	}

	@Override
	public void Rm_T(Test t) {
		em.remove(t);
	}

	@Override
	public List<Test> GetAll_T() {
		return em.createQuery("from Test",Test.class).getResultList();
	}

	@Override
	public void AddQtoT(Question q, int id) {
		Test t = this.get_Test(id);
		//t.getQuestions().add(q);
	}

	@Override
	public void Add_Q(Question q) {
		em.persist(q);
	}

	@Override
	public void Up_Q(Question q) {
		em.merge(q);
	}

	@Override
	public void Rm_Q(Question q) {
		em.remove(q);
	}

	@Override
	public void AddRtoQ(Reponce r, int id) {
		Question q = em.find(Question.class, id);
		//q.getReponces().add(r);
	}

	@Override
	public void Add_R(Reponce r) {
		em.persist(r);
	}

	@Override
	public void Up_R(Reponce r) {
		em.merge(r);
	}

	@Override
	public void Rm_R(Reponce r) {
		em.remove(r);
	}

}
