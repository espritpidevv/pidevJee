package tn.esprit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Test implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	private String img;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Formation formation;
	
	/*
	 * @OneToMany(cascade=CascadeType.ALL,mappedBy="test") private List<Question>
	 * questions = new ArrayList<Question>();
	 */

	public Test() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	/*
	 * public List<Question> getQuestions() { return questions; }
	 * 
	 * public void setQuestions(List<Question> questions) { this.questions =
	 * questions; }
	 * 
	 * @Override public String toString() { return "Test [id=" + id +
	 * ", description=" + description + ", img=" + img + ", formation=" + formation
	 * + ", questions=" + questions + "]"; }
	 */
	
	
	
	
	
	

}
