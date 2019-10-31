package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.entity.Spec;
@ManagedBean
@ApplicationScoped
public class DataSpec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Spec[] getSpecs()
	{
		return Spec.values();
	}

}
