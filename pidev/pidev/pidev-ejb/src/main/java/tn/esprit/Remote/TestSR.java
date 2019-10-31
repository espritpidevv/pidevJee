package tn.esprit.Remote;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entity.Question;
import tn.esprit.entity.Reponce;
import tn.esprit.entity.Test;

@Remote
public interface TestSR {
	
	Test get_Test(int id);
	
	void Add_T(Test t);
	
	void Up_T(Test t);
	
	void Rm_T(Test t);
	
	List<Test> GetAll_T();
	
	void AddQtoT(Question q, int id);
	
	void Add_Q(Question q);
	
	void Up_Q(Question q);
	
	void Rm_Q(Question q);
	
	void AddRtoQ(Reponce r, int id);
	
	void Add_R(Reponce r);
	
	void Up_R(Reponce r);
	
	void Rm_R(Reponce r);
	
		
	
	
	

}
