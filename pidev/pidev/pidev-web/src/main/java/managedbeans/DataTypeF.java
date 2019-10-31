package managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.entity.Type_Formation;

@ManagedBean
@ApplicationScoped
public class DataTypeF implements Serializable {
	public Type_Formation[] getType()
	{
		return Type_Formation.values();
	}
}
