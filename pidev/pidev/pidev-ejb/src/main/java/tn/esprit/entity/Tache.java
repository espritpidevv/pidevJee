package tn.esprit.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tache implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private int dureeEtimee;
	private int dureeReelle;
	
	@Temporal(TemporalType.TIME)
	private Date date_debut;
	@Temporal(TemporalType.TIME)
	private Date date_fin;
	private Boolean isFinished;
	

	@ManyToOne
	Projet projet;
	
	@ManyToOne
	Employe employe;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Skills> skillss;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public int getDureeEtimee() {
		return dureeEtimee;
	}

	public void setDureeEtimee(int dureeEtimee) {
		this.dureeEtimee = dureeEtimee;
	}

	public int getDureeReelle() {
		return dureeReelle;
	}

	public void setDureeReelle(int dureeReelle) {
		this.dureeReelle = dureeReelle;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}

	public Set<Skills> getSkillss() {
		return skillss;
	}

	public void setSkillss(Set<Skills> skillss) {
		this.skillss = skillss;
	}

	

	
}