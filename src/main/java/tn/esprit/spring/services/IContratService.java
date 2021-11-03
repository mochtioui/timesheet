package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.converts.ContratModel;
import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	/**
	 * 
	 * @return
	 */
	public List<Contrat> getAllContrats();
	/**
	 * 
	 * @param contrat
	 * @return
	 */
	public Contrat addContrat(ContratModel contrat);
	/**
	 * 
	 * @param idContrat
	 * @param newContrat
	 * @return
	 */
	public Contrat updateContrat(int idContrat, ContratModel newContrat);
	/**
	 * 
	 * @param idContrat
	 * @return
	 */
	public boolean deleteContrat(int idContrat);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Contrat getContratById(int id);

	
	
	

	
}
