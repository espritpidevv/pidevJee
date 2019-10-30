package tn.esprit.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Commentaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ;

@ManyToOne 
private Employe employecommentaire ;
@ManyToOne
private Evaluation360 commentaireEvzl360 ;

}
