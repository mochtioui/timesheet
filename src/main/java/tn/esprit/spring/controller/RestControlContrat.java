package tn.esprit.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IContratService;

@RestController
public class RestControlContrat {

	
	@Autowired
	IContratService icontractService;
	
	private static final Logger l = Logger.getLogger("contract service");
	Class<?> enclosingClass = getClass().getEnclosingClass();
	
	@PostMapping("/add")
	@ResponseBody
	public Contrat add(@RequestBody Contrat newContrat) {
		l.info("["+enclosingClass.getName()+"] add a new  contract");
		return icontractService.addContrat(newContrat);
	}
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Contrat update(@PathVariable("id") int referenceContract,@RequestBody Contrat newContrat) 
    {
		l.info("["+enclosingClass.getName()+"] update  contract");
    	return icontractService.updateContrat(referenceContract, newContrat);
    }
    @PutMapping(value = "/delete/{id}")
    @ResponseBody
    public boolean deleteContrat(@PathVariable("id") int referenceContract) {
		l.info("["+enclosingClass.getName()+"] delete  contract");
    	return icontractService.deleteContrat(referenceContract);
    }
    

	
}
