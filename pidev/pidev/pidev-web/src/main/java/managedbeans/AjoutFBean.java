package managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import tn.esprit.Remote.TestSR;
import tn.esprit.entity.Formateur;
import tn.esprit.entity.Formation;
import tn.esprit.entity.Skills;
import tn.esprit.entity.Test;
import tn.esprit.entity.Type_Formation;
import tn.esprit.service.FormateurSLB;
import tn.esprit.service.FormationSLB;

@ManagedBean
@RequestScoped
public class AjoutFBean {
	
	@EJB
	TestSR testSLB;
	
	@EJB
	FormateurSLB formateurSLB;
	
	@EJB
	FormationSLB formationSLB;
	

	
	private String ti;
	
	private String description;
	
	private String date_debut;
	
	private String date_fin;
	
	private String img;
	
	private Type_Formation type;
	
	private int formateur;
	
	private int test;
	
	private List<Formateur> formateurs;
	
	private List<Test> tests;
	
	private List<Skills> ls;
	
	private List<String> skillss;

	
	@PostConstruct
	void init()
	{
		
		formateurs = formateurSLB.All();
		
		tests = testSLB.GetAll_T();
		ls = formationSLB.getSA();
		
		
		
	}

	public String getTi() {
		return ti;
	}

	public void setTi(String ti) {
		this.ti = ti;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Type_Formation getType() {
		return type;
	}

	public void setType(Type_Formation type) {
		this.type = type;
	}

	public int getFormateur() {
		return formateur;
	}

	public void setFormateur(int formateur) {
		this.formateur = formateur;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public List<Skills> getLs() {
		return ls;
	}

	public void setLs(List<Skills> ls) {
		this.ls = ls;
	}

	public List<String> getSkillss() {
		return skillss;
	}

	public void setSkillss(List<String> skillss) {
		this.skillss = skillss;
	}
	
	public String Ajout() throws ParseException
	{
		Formation f = new Formation();
		f.setTitre(ti);
		f.setDescription(description);
		f.setImg(img);
		SimpleDateFormat	formatter = new SimpleDateFormat("yyyy-MM-dd");
		f.setDate_debut((Date)formatter.parse(date_debut));
		f.setDate_fin((Date)formatter.parse(date_fin));
		Formateur fr = formateurSLB.get(formateur);
		f.setFormateur(fr);
		
		List<Skills> sl = new ArrayList<Skills>();
		for(String i : skillss)
		{
			Skills s = formationSLB.getS(Integer.parseInt(i));
			
			sl.add(s);
		}
		f.setSkillss(sl);
		f.setType(type);
		formationSLB.Add(f);
		return "Formation?faces-redirect=true";
	}
	

}
