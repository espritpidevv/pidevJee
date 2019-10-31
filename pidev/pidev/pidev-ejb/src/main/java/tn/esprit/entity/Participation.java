package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Participation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ParticipationPk ParticipationPk;
	
	@ManyToOne
	@JoinColumn(name="idFormation",referencedColumnName="id",insertable=false,updatable=false)
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name="idEmploye",referencedColumnName="EM_Id",insertable=false,updatable=false)
	private Employe employe;

	public Participation() {
	}

	public ParticipationPk getParticipationPk() {
		return ParticipationPk;
	}

	public void setParticipationPk(ParticipationPk participationPk) {
		ParticipationPk = participationPk;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
	

}
