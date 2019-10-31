package tn.esprit.Remote;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.Employe;
import tn.esprit.entity.Formateur;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Skills;
import tn.esprit.entity.Tache;
import tn.esprit.entity.Test;

@Remote
public interface FormationSR {
	
	Formation get(int id);
	
	void Add(Formation f);
	
	void Up(Formation f);
	
	void remove(Formation f);
	
	List<Formation> All();
	
	void Add_Test(Test t, int id);
	
	void Add_Formateur(Formateur f , int id);
	
	List<Tache> ListTByEBefor(Employe id, Date date);
	
	List<Tache> ListTByEAfter(Employe id, Date date);
	
	List<Employe> ListEBySkills(Skills s );
	
	

	
}
