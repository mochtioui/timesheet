package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;
import tn.esprit.spring.converts.ContractToModelConvert;
import tn.esprit.spring.converts.ContractToEntityConvert;
import tn.esprit.spring.dto.ContratModel;


@RestController
public class RestControlEmploye {

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetService itimesheetservice;

		@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	ContratRepository contratRepository;
	
	ContractToEntityConvert contractToEntityConvert=new ContractToEntityConvert();
	ContractToModelConvert contractToModelConvert=new ContractToModelConvert();
	private static final Logger l = LogManager.getLogger(RestControlEmploye.class);

	

	
	@PostMapping("/ajouterEmployer")
	@ResponseBody
	public Employe ajouterEmploye(@RequestBody Employe employe)
	{
		iemployeservice.addOrUpdateEmploye(employe);
		return employe;
	}
	
	// Modifier email : http://localhost:8081/SpringMVC/servlet/modifyEmail/1/newemail
	@PutMapping(value = "/modifyEmail/{id}/{newemail}") 
	@ResponseBody
	public void mettreAjourEmailByEmployeId(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {
		iemployeservice.mettreAjourPasswordByEmployeId(email, employeId);
		
	}
	// http://localhost:8081/SpringMVC/servlet/affecterEmployeADepartement/1/1
	@PutMapping(value = "/affecterEmployeADepartement/{idemp}/{iddept}") 
	public void affecterEmployeADepartement(@PathVariable("idemp")int employeId, @PathVariable("iddept")int depId) {
		iemployeservice.affecterEmployeADepartement(employeId, depId);
		
	}
	
	// http://localhost:8081/SpringMVC/servlet/desaffecterEmployeDuDepartement/1/1
	@PutMapping(value = "/desaffecterEmployeDuDepartement/{idemp}/{iddept}") 
	public void desaffecterEmployeDuDepartement(@PathVariable("idemp")int employeId, @PathVariable("iddept")int depId)
	{
		iemployeservice.desaffecterEmployeDuDepartement(employeId, depId);
	}

	
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody ContratModel contrat) {
		iemployeservice.ajouterContrat(contractToEntityConvert.convert(contrat));
		l.info("contract added successfully");
		return contrat.getRef();
	}
	
  @PutMapping(value = "/affecterContratAEmploye/{idcontrat}/{idemp}") 
	public void affecterContratAEmploye(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int employeId)
	{
		l.info("affect employ a contract ");
		l.info("je chercher l'empoyer ");
		Optional<Employe> emp = employeRepository.findById(employeId);
		Optional<Contrat> con= contratRepository.findById(contratId);
		if(emp.isPresent() && con.isPresent()) {
			iemployeservice.affecterContratAEmploye(contratId, employeId);

		}
		else {
			l.info("something wrong  ");

		}
		l.info(contratId+" contract affected to employe "+employeId);

	}

	
   
   // URL : http://localhost:8081/SpringMVC/servlet/getEmployePrenomById/2
   @GetMapping(value = "getEmployePrenomById/{idemp}")
   @ResponseBody
   public String getEmployePrenomById(@PathVariable("idemp")int employeId) {
		return iemployeservice.getEmployePrenomById(employeId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteEmployeById/1
    @DeleteMapping("/deleteEmployeById/{idemp}") 
	@ResponseBody 
	public void deleteEmployeById(@PathVariable("idemp")int employeId) {
		iemployeservice.deleteEmployeById(employeId);
		
	}
    
    @DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
    	l.info("delete employer ");
		Optional<Contrat> con= contratRepository.findById(contratId);
		if(con.isPresent()) {
			l.info("delete contract success");
			iemployeservice.deleteContratById(contratId);

		}
		
		else {
			l.info("something wrong");

		}
	}
    


    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeNamesJPQL
    @GetMapping(value = "getAllEmployeNamesJPQL")
    @ResponseBody
	public List<String> getAllEmployeNamesJPQL() {
		
		return iemployeservice.getAllEmployeNamesJPQL();
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployeByEntreprise/1
    @GetMapping(value = "getAllEmployeByEntreprise/{identreprise}")
    @ResponseBody
	public List<Employe> getAllEmployeByEntreprise(@PathVariable("identreprise") int identreprise) {
    	Entreprise entreprise=ientrepriseservice.getEntrepriseById(identreprise);
		return iemployeservice.getAllEmployeByEntreprise(entreprise);
	}

 // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByEmployeIdJPQL/2/newemail
 	@PutMapping(value = "/mettreAjourEmailByEmployeIdJPQL/{id}/{newemail}") 
 	@ResponseBody
	public void mettreAjourEmailByEmployeIdJPQL(@PathVariable("newemail") String email, @PathVariable("id") int employeId) {	
	iemployeservice.mettreAjourEmailByEmployeIdJPQL(email, employeId);
		
	}

     
    // URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "getNombreEmployeJPQL")
    @ResponseBody
	public int getNombreEmployeJPQL() {
		l.info("delete all contract");
		return iemployeservice.getNombreEmployeJPQL();
		
    }
    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByEmployeIdJPQL/2
    @GetMapping(value = "getSalaireByEmployeIdJPQL/{idemp}")
    @ResponseBody
	public float getSalaireByEmployeIdJPQL(@PathVariable("idemp")int employeId) {
		return iemployeservice.getSalaireByEmployeIdJPQL(employeId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireMoyenByDepartementId/2
    @GetMapping(value = "getSalaireMoyenByDepartementId/{iddept}")
    @ResponseBody
	public Double getSalaireMoyenByDepartementId(@PathVariable("iddept")int departementId) {
		return iemployeservice.getSalaireMoyenByDepartementId(departementId);
	}

	
	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return iemployeservice.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}


	 // URL : http://localhost:8081/SpringMVC/servlet/getAllEmployes
	@GetMapping(value = "/getAllEmployes")
    @ResponseBody
	public List<Employe> getAllEmployes() {
		
		return iemployeservice.getAllEmployes();
	}

	
	
}
