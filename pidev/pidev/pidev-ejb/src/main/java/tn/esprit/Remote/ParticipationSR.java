package tn.esprit.Remote;

import java.util.List;

import tn.esprit.entity.Participation;

public interface ParticipationSR {
	
	void Add(Participation participation);
	
	void Remove(Participation participation);
	
	Participation get(int idf, int ide);
	
	
}
