package tn.esprit.spring.dto;

import java.util.Date;




import tn.esprit.spring.entities.Employe;

public class ContratModel {



	private int reference;
	
	private Date dateDebut;
	
	private String typeContrat;
	
	
	private String telephone;
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	private Employe employe;

	private float salaire;

	public ContratModel() {
		super();
	}
	
	public ContratModel(Date dateDebut, String typeContrat, float salaire) {
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}


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
	
}
