package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public Contrat addContrat(Contrat contrat);
	public Contrat updateContrat(Contrat contrat);
	public Contrat getContrat(String id);
	public void  remove(String idContrat);


	
	
	

	
}
