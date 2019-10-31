package tn.esprit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	
	private String img;
	
	@Enumerated(EnumType.STRING)
	private Type_Question type;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Test test;
	/*
	 * @OneToMany(cascade=CascadeType.ALL,mappedBy="question") private List<Reponce>
	 * reponces = new ArrayList<Reponce>();
	 */

	public Question() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Type_Question getType() {
		return type;
	}

	public void setType(Type_Question type) {
		this.type = type;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	/*
	 * public List<Reponce> getReponces() { return reponces; }
	 * 
	 * public void setReponces(List<Reponce> reponces) { this.reponces = reponces; }
	 */
	
	
	
	
	
	

}
