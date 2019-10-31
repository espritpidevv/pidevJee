package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skills implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private Typelevel level;
	private String description;

	@ManyToMany(mappedBy = "skillss")
	private List<Formation> formations;

	@ManyToMany(mappedBy = "skillss")
	private List<Formateur> formateurs;

	@ManyToMany(mappedBy="skillss",cascade=CascadeType.ALL)
	private Set<Tache> taches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Typelevel getLevel() {
		return level;
	}

	public void setLevel(Typelevel level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Skills() {
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	
	
	

}
