package tn.esprit.spring.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@Controller
public class ControllerContratImpl {
	
	@Autowired
	IContratService icontractService;
	
	private static final Logger l = Logger.getLogger("contract service");
	Class<?> enclosingClass = getClass().getEnclosingClass();

	
	public int ajouterContract(Contrat contrat) {
		l.info("["+enclosingClass.getName()+"] add a new  contract");
		icontractService.addContrat(contrat);
		return contrat.getReference();
	}
	public boolean deleteContract(int reference) {
		l.info("["+enclosingClass.getName()+"] delete a contract contract");
		return icontractService.deleteContrat(reference);
	}
	public Contrat getContratById(int reference) {
		l.info("["+enclosingClass.getName()+"] get contract by id");
		return icontractService.getContratById(reference);
	}
	public List<Contrat> allContrats(){
		l.info("["+enclosingClass.getName()+"] get all contract");
		return icontractService.getAllContrats();
	}
	public Contrat updateContrat(Contrat newContrat) {
		l.info("["+enclosingClass.getName()+"] update contract");
		return icontractService.updateContrat(newContrat.getReference(),newContrat);
	}
			

}
