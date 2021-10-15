package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		logger.info("Id Dep +++ : " + dep.getId());

		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
	
		try {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		Optional <Departement> depManagedEntity = deptRepoistory.findById(depId);
		
		
		if(depManagedEntity.isPresent() && entrepriseManagedEntity.isPresent()) {
			Departement departement = depManagedEntity.get();
			Entreprise entreprise = entrepriseManagedEntity.get();
			departement.setEntreprise(entreprise);
			deptRepoistory.save(departement);
		}	
	}
	
	  catch(Exception e){
		  logger.info("Exception",""+e.toString());
	    } 
		
	}
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		logger.info("Dep Name +++ : " + depNames);

		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		if (entrepriseRepoistory.findById(entrepriseId).isPresent()) {
			logger.info("Entreprise +++ : " + entrepriseRepoistory.findById(entrepriseId).isPresent());
		}
		else {
			logger.info("Entreprise n'existe pas");
		}
		
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}

}
