package tn.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Formateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomPrenom;

	private String img;
	
	private Float note;

	@Enumerated(EnumType.STRING)
	private Spec specialiste;

	@OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
	private List<Formation> formations;
	
	@ManyToMany
	private List<Skills> skillss;

	public Formateur() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public Spec getSpecialiste() {
		return specialiste;
	}

	public void setSpecialiste(Spec specialiste) {
		this.specialiste = specialiste;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public List<Skills> getSkillss() {
		return skillss;
	}

	public void setSkillss(List<Skills> skillss) {
		this.skillss = skillss;
	}
	
	
	

}
