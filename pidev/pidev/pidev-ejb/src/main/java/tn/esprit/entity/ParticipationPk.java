package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ParticipationPk implements Serializable {
	
	private int idFormation;
	private int idEmploye;
	public ParticipationPk() {
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + idEmploye;
		result = prime * result + idFormation;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipationPk other = (ParticipationPk) obj;
		if (idEmploye != other.idEmploye)
			return false;
		if (idFormation != other.idFormation)
			return false;
		return true;
	}
	
	
	
	
	
	

}
