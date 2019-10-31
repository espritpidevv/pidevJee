package tn.esprit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Formation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titre;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date date_debut;

	@Temporal(TemporalType.DATE)
	private Date date_fin;

	private String img;

	@Enumerated(EnumType.STRING)
	private Type_Formation type;

	@ManyToOne(cascade = CascadeType.MERGE )
	private Formateur formateur;

	@OneToOne(cascade = CascadeType.ALL)
	private Test test;

	@OneToMany(mappedBy = "formation",cascade=CascadeType.MERGE)
	private List<Invetation> invitations;

	@OneToMany(mappedBy = "formation")
	private List<Participation> participations;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE} )
	private List<Skills> skillss = new ArrayList<Skills>();

	public Formation() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Type_Formation getType() {
		return type;
	}

	public void setType(Type_Formation type) {
		this.type = type;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Invetation> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Invetation> invitations) {
		this.invitations = invitations;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public List<Skills> getSkillss() {
		return skillss;
	}

	public void setSkillss(List<Skills> skillss) {
		this.skillss = skillss;
	}
	
	
}
