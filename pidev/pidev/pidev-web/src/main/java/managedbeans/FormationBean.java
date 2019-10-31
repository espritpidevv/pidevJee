package managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entity.Formation;
import tn.esprit.service.FormationSLB;

@ManagedBean(name="formationBean")
@RequestScoped
public class FormationBean {
	
	@EJB
	private FormationSLB formationSLB;
	
	private List<Formation> formations;
	
	@PostConstruct
	void init()
	{
		this.formations = formationSLB.All();
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	public String sup(int id)
	{
		Formation f = formationSLB.get(id);
		formationSLB.remove(f);
		
		return "Formation?faces-redirect=true";
	}
	

}
