package tn.esprit.Remote;

import javax.ejb.Remote;

import tn.esprit.entity.Invetation;

@Remote
public interface InvitationSR {
	
	void add(Invetation invetation);
	
	void up(Invetation invetation);
	
	Invetation get(int idf,int ide);

}
