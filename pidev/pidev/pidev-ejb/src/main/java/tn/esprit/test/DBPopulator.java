package tn.esprit.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import tn.esprit.Remote.FormateurSR;
import tn.esprit.Remote.FormationSR;
import tn.esprit.Remote.TestSR;
import tn.esprit.entity.Employe;
import tn.esprit.entity.Formateur;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Projet;
import tn.esprit.entity.Skills;
import tn.esprit.entity.Spec;
import tn.esprit.entity.Tache;
import tn.esprit.entity.Test;
import tn.esprit.service.FormationSLB;
import tn.esprit.service.ProjetService;
import tn.esprit.service.Serviceemp;
import tn.esprit.service.Serviceemplocal;
import tn.esprit.service.TacheService;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private FormateurSR formateurSR ;
	
	
	@EJB
	private FormationSLB formationSR;
	
	@EJB
	private TestSR testSR;
	
	@EJB
	Serviceemp serviceemp;
	
	@EJB
	ProjetService projetService;
	
	@EJB
	TacheService tacheService;
	

	
	
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void init(){
			/*
			 * Skills s = formationSR.getS(0);
			 * 
			 * List<Employe> l = formationSR.ListEBySkills(s);
			 */
		
		
		
		
		  
		 
		
		
	}
}
