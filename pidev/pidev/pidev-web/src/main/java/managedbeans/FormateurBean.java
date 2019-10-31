package managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import tn.esprit.entity.Formateur;
import tn.esprit.entity.Spec;
import tn.esprit.service.FormateurSLB;

@ManagedBean(name="formateurBean")
@RequestScoped
public class FormateurBean {
	
	@EJB
	FormateurSLB formateurSLB;
	
	private List<Formateur> formateurs;
	
	private String np;
	
	private String img;
	
	private Spec spec;
	
	
	
	
	@PostConstruct
	void init()
	{
		this.formateurs = formateurSLB.All();
	}
	
	public void Ajout()
	{
		Formateur f = new Formateur();
		f.setNomPrenom(np);
		f.setImg(img);
		f.setSpecialiste(spec);
		formateurSLB.Add(f);
		setNp("");
		setImg("");
		setSpec(null);
		this.formateurs = formateurSLB.All();
	}
	
	public  String  up(String id , String img,String np,Spec spec) {
		
		Formateur f = formateurSLB.get(Integer.parseInt(id));
		
		f.setNomPrenom(np);
		f.setImg(img);
		f.setSpecialiste(spec);
		
		
		return "Formateur?faces-redirect=true";
	}
	
	public String sup(Formateur f)
	{
		
		formateurSLB.remove(f);
		return "Formateur?faces-redirect=true";
		
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public String getNp() {
		return np;
	}

	public void setNp(String np) {
		this.np = np;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Spec getSpec() {
		return spec;
	}

	public void setSpec(Spec spec) {
		this.spec = spec;
	}

	
	
	
	
	
	
	

}
