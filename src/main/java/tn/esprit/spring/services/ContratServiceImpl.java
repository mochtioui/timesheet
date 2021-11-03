package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.converts.ContractToEntityConvert;
import tn.esprit.spring.converts.ContratModel;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger l = Logger.getLogger("contract repository");
	
	@Autowired
	ContratRepository contratRepository;
	ContractToEntityConvert contractToEntityConvert;
	
    
    /*
     * @Description Get All Contracts
     */
	public List<Contrat> getAllContrats() {
		l.info("[ contract service ] get a contract contract");
		return (List<Contrat>) contratRepository.findAll();
		
	}
	 /*
     * @Description Add Contract
     * @param contract : Contract
     */
	
	public Contrat addContrat(ContratModel contrat) {
		l.info("[ contract service ] add a contract contract");
		return contratRepository.save(contractToEntityConvert.convert(contrat));	
	}
	 /*
     * @Description update Contract
     * @param contract : Contract
     * @param idContraat id of the contract for updating
     */	
	public Contrat updateContrat(int idContrat, ContratModel newContrat) {
		l.info("[ contract service ] update a contract contract");
		Optional<Contrat> conOptional=contratRepository.findById(idContrat);
		if(conOptional.isPresent()) {
			Contrat existContrat=conOptional.get();
			existContrat.setDateDebut(newContrat.getStartDate());
			existContrat.setEmploye(newContrat.getEmp());
			existContrat.setReference(newContrat.getRef());
			existContrat.setSalaire(newContrat.getSal());
			existContrat.setTelephone(newContrat.getTel());
			existContrat.setTypeContrat(newContrat.getType());
			return contratRepository.save(existContrat);	
		}
		return null;
	
	}
	 /*
     * @Description delete Contract
     * @param idContrat : id of contrat
     */	
	public boolean deleteContrat(int idContrat) {
		l.info("[ contract service ] delete a contract contract");
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
		l.info("[ contract service ] get a contract contract by id ");
		Optional<Contrat> contractOptional=contratRepository.findById(id);
		if(contractOptional.isPresent())
			return contractOptional.get();
		return null;
	}
	

}
