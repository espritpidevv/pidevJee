package tn.esprit.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Evaluation implements Serializable{
	@Override
	public String toString() {
		return nom ;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ;
	private String description ;
	private String  nom ;
	private boolean Launch ;
	private Date datedebut ;
	@OneToMany(mappedBy="evaluation",cascade=CascadeType.REMOVE) 
	private List<Critere> criteres ;
	@OneToMany(mappedBy="evaluation") 
	private List<Avis> avis ;
	@ManyToOne
	private Employe evaluationEmploye ;
	private boolean Traiter ;
	
	

public boolean isLaunch() {
		return Launch;
	}
	public void setLaunch(boolean launch) {
		Launch = launch;
	}
	public boolean isTraiter() {
		return Traiter;
	}
	public void setTraiter(boolean traiter) {
		Traiter = traiter;
	}
public List<Avis> getAvis() {
		return avis;
	}
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	public Employe getEvaluationEmploye() {
		return evaluationEmploye;
	}
	public void setEvaluationEmploye(Employe evaluationEmploye) {
		this.evaluationEmploye = evaluationEmploye;
	}

public Date getDatedebut() {
	return datedebut;
}
public void setDatedebut(Date datedebut) {
	this.datedebut = datedebut;
}




public int getId() {

	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Evaluation() {
	super();
	// TODO Auto-generated constructor stub
}
public Evaluation(String description2, String nom2, Date date) {
this.description=description2 ;
this.nom=nom2;
this.datedebut=date;
}
public Evaluation(String nom2, String description2, Date datedebut2, Boolean launch2, Boolean traiter2,int i) {
this.nom=nom2;
this.description=description2 ;
this.datedebut=datedebut2;
this.Launch=launch2;
this.Traiter=traiter2;
this.id=i;
}


public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}

public List<Critere> getCriteres() {
	return criteres;
}
public void setCriteres(List<Critere> criteres) {
	this.criteres = criteres;
}

}
