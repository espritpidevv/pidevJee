package tn.esprit.Remote;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.Formateur;

@Remote
public interface FormateurSR {
	
	Formateur get(int id);
	
	void Add(Formateur f);
	
	void Up(Formateur f);
	
	void remove(Formateur f);
	
	List<Formateur> AllByNote();
	
	List<Formateur> All();

}
