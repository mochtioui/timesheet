package tn.esprit.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import tn.esprit.spring.converts.ContratModel;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;

@RestController
public class RestControlContrat {

	
	@Autowired
	ContratServiceImpl icontractService;
	
	private static final Logger l = Logger.getLogger("contract service");
	Class<?> enclosingClass = getClass().getEnclosingClass();
	
	@PostMapping("/add")
	@ResponseBody
	public Contrat add(@Valid ContratModel newContrat) {
		l.info("[contract rest api] add a new  contract");
		return icontractService.addContrat(newContrat);
	}
    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Contrat update(@PathVariable("id") int referenceContract,@Valid ContratModel newContrat) 
    {
		l.info("[contract rest api] update  contract");
    	return icontractService.updateContrat(referenceContract, newContrat);
    }
    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public boolean deleteContrat(@PathVariable("id") int referenceContract) {
		l.info("[contract rest api] delete  contract");
    	return icontractService.deleteContrat(referenceContract);
    }
    @GetMapping(value="/getall")
    @ResponseBody
    public List<Contrat> getAll(){
		l.info("[contract rest api] get all  contract");
    	return icontractService.getAllContrats();
    }
    
    

	
}
