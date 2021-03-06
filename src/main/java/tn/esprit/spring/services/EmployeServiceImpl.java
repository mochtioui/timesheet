package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class EmployeServiceImpl implements IEmployeService {
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;


       
	@Override
	public Employe authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}


	public void mettreAjourPasswordByEmployeId(String password, int employeId) {
Optional<Employe> emp= employeRepository.findById(employeId);
		if(emp.isPresent()) {
		emp.get().setPassword(password);
		employeRepository.save(emp.get());
		}
		else 
		{
			l.warn("something is wrong");
			
		}
	

	}

	@Transactional	
	public void affecterEmployeADepartement(int employeId, int depId) {
		
		
		Optional<Departement> depManagedEntity= deptRepoistory.findById(depId);
		Optional<Employe> employeManagedEntity= employeRepository.findById(employeId);

		if(depManagedEntity.isPresent() && employeManagedEntity.isPresent()) {
		if(depManagedEntity.get().getEmployes() == null){

			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity.get());
			depManagedEntity.get().setEmployes(employes);
		}else{

			depManagedEntity.get().getEmployes().add(employeManagedEntity.get());
		}

		deptRepoistory.save(depManagedEntity.get()); 
		}

	}
	@Transactional
	public void desaffecterEmployeDuDepartement(int employeId, int depId)
	{
		Optional<Departement> depManagedEntity= deptRepoistory.findById(depId);
		l.info(depManagedEntity);
		if(depManagedEntity.isPresent() ) {

		int employeNb = depManagedEntity.get().getEmployes().size();
		for(int index = 0; index < employeNb; index++){
			if(depManagedEntity.get().getEmployes().get(index).getId() == employeId){
				depManagedEntity.get().getEmployes().remove(index);
				break;//a revoir
			}
		}
		}
	} 
	

	public int ajouterContrat(Contrat contrat) {
		contratRepoistory.save(contrat);
		return contrat.getReference();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		
		Optional<Contrat> con= contratRepoistory.findById(contratId);
		Optional<Employe> emp= employeRepository.findById(employeId);

		if(emp.isPresent() && con.isPresent()) 
		{
		con.get().setEmploye(emp.get());
		contratRepoistory.save(con.get());
		}

	}

	public String getEmployePrenomById(int employeId) {
		Optional <Employe> employeManagedEntity = employeRepository.findById(employeId);
		if(employeManagedEntity.isPresent()) 
		{
		return employeManagedEntity.get().getPrenom();
		}
		else return "name has been added";
		
		
	}
	 
	public void deleteEmployeById(int employeId)
	{
		Optional<Employe> emp= employeRepository.findById(employeId);

		if(emp.isPresent()) {
		for(Departement dep : emp.get().getDepartements()){
			dep.getEmployes().remove(emp.get());
		}

		employeRepository.delete(emp.get());
		}
	}

	public void deleteContratById(int contratId) {
		Optional<Contrat> con= contratRepoistory.findById(contratId);
		if(con.isPresent()) {
		contratRepoistory.delete(con.get());
		}

	}

	public int getNombreEmployeJPQL() {
		return employeRepository.countemp();
	}

	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.employeNames();

	}

	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
		return employeRepository.getAllEmployeByEntreprisec(entreprise);
	}

	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		employeRepository.mettreAjourEmailByEmployeIdJPQL(email, employeId);

	}
	public void deleteAllContratJPQL() {
		employeRepository.deleteAllContratJPQL();
	}

	public float getSalaireByEmployeIdJPQL(int employeId) {
		return employeRepository.getSalaireByEmployeIdJPQL(employeId);
	}

	public Double getSalaireMoyenByDepartementId(int departementId) {
		return employeRepository.getSalaireMoyenByDepartementId(departementId);
	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
	}

	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

}
