package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Invetation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InvetationPk InvetationPk;

	@ManyToOne
	@JoinColumn(name = "idFormation", referencedColumnName = "id", insertable = false, updatable = false)
	private Formation formation;

	@ManyToOne
	@JoinColumn(name = "idEmploye", referencedColumnName = "EM_Id", insertable = false, updatable = false)
	private Employe employe;
	
	@Enumerated(EnumType.STRING)
	private Etat_Invitation etat_Invitation;
	
	
	private Boolean vu;

	public Invetation() {
	}

	public InvetationPk getInvetationPk() {
		return InvetationPk;
	}

	public void setInvetationPk(InvetationPk invetationPk) {
		InvetationPk = invetationPk;
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

	public Etat_Invitation getEtat_Invitation() {
		return etat_Invitation;
	}

	public void setEtat_Invitation(Etat_Invitation etat_Invitation) {
		this.etat_Invitation = etat_Invitation;
	}

	public Boolean getVu() {
		return vu;
	}

	public void setVu(Boolean vu) {
		this.vu = vu;
	}
	
	
	

}
