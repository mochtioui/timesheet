package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	
   /**
    * @description parameter in class service
    */

	@Autowired
	ContratRepository contratRepository;
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

    /**
     * @description get all contracts
     * @return List<Contrat> 
     */
	public List<Contrat> getAllContrats() {
		l.info("get all contract");
		return (List<Contrat>) contratRepository.findAll();
	}
    /**
     * @description add new contract
     * @param contrat
     * @return Contract 
     */
	public Contrat addContrat(Contrat contrat)
	{
		l.info("contract saved");
		return contratRepository.save(contrat); 
		
	}
    /**
     * @description update contract
     * @param contrat
     * @return Contract 
     */
	public Contrat updateContrat(Contrat con) {
		// TODO Auto-generated method stub
		l.info("contract updated");
		return contratRepository.save(con);
	}
	
    /**
     * @description get one  contract
     * @param id
     * @return Contract 
     */
	public Contrat getContrat(String id) {
		l.info("get contrat with  id = " + id);
		Contrat e =  contratRepository.findById(Integer.parseInt(id)).orElse(null);
		l.info("contrat returned : " + e);
		return e; 
	

	}
    	
    /**
     * @description remove contract
     * @param idContrat
     * @return Contract 
     */
	public void remove(String idContrat)
	{
		l.info("attempt to remove contrat with  id = " + idContrat);

		if ( ! contratRepository.findById(Integer.parseInt(idContrat)).equals(Optional.empty()) ){
			contratRepository.deleteById(Integer.parseInt(idContrat));
			l.info("contrat with  id = " + idContrat+" removed");

		}
		
	}

}
