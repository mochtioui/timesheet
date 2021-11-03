package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrat implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateDebut")
	private Date dateDebut;
	
	@Column(name="typeContrat")
	private String typeContrat;
	
	@Column(name="telephone")
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@OneToOne
	private Employe employe;
	
	@Column(name="salaire")
	private float salaire;
	

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Contrat() {
		super();
	}
	
  

	public Contrat(int reference, Date dateDebut, String typeContrat, String telephone, Employe employe,
			float salaire) {
		super();
		this.reference = reference;
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.telephone = telephone;
		this.employe = employe;
		this.salaire = salaire;
	}

	
	
}
