package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	@Autowired
	ContratRepository contratRepository;
    
    /*
     * @Description Get All Contracts
     */
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}
	 /*
     * @Description Add Contract
     * @param contract : Contract
     */
	
	public Contrat addContrat(Contrat contrat) {
		return contratRepository.save(contrat);	
	}
	 /*
     * @Description update Contract
     * @param contract : Contract
     * @param idContraat id of the contract for updating
     */	
	public Contrat updateContrat(int idContrat, Contrat newContrat) {
		Contrat existContrat=contratRepository.findById(idContrat).get();
		existContrat.setDateDebut(newContrat.getDateDebut());
		existContrat.setEmploye(newContrat.getEmploye());
		existContrat.setReference(newContrat.getReference());
		existContrat.setSalaire(newContrat.getSalaire());
		existContrat.setTelephone(newContrat.getTelephone());
		existContrat.setTypeContrat(newContrat.getTypeContrat());
		return contratRepository.save(existContrat);		
	}
	 /*
     * @Description delete Contract
     * @param idContrat : id of contrat
     */	
	public boolean deleteContrat(int idContrat) {
		if(contratRepository.findById(idContrat).isPresent()) {
			contratRepository.deleteById(idContrat);
			return true;
		}
		return false;
	}
	 /*
     * @Description get Contract
     * @param idContrat : id of contrat
     */	
	public Contrat getContratById(int id) {
		return contratRepository.findById(id).get();
	}
	

}
