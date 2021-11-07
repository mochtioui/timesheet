package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

	public int ajouterEntreprise(Entreprise entreprise) {
		logger.info("Je vais lancer la methode ajouterEntreprise");
		
		entrepriseRepoistory.save(entreprise);
		logger.debug("Ajout d'une entreprise");
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		logger.info("Je vais lancer la methode ajouterDepartement");
		logger.debug("Ajouter d'un departement");
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		try {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		Optional <Departement> depManagedEntity = deptRepoistory.findById(depId);
		logger.info(entrepriseManagedEntity);
		logger.info(depManagedEntity);
		if(entrepriseManagedEntity.isPresent() && depManagedEntity.isPresent()) {
		depManagedEntity.get().setEntreprise(entrepriseManagedEntity.get());
		deptRepoistory.save(depManagedEntity.get());
		}
		}
		  catch(Exception e){
				 logger.error("Erreur dans affecterDepartementAEntreprise:"+e.toString());
			    } 
}
	
	

	/****chtioui */
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		List<String> depNames = new ArrayList<>();
		if(entrepriseManagedEntity.isPresent()) {
		for(Departement dep : entrepriseManagedEntity.get().getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
		}
		return null;
	}


	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		if(entrepriseManagedEntity.isPresent()) {
			entrepriseRepoistory.delete(entrepriseManagedEntity.get());	
		}
		
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional <Entreprise> entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		logger.info("Je vais lancer la methode getEntrepriseById");
		
		if(entrepriseManagedEntity.isPresent()) {
			return entrepriseManagedEntity.get();	
		}
		logger.debug("Affichage d'un entreprise");

		return null;
	}
	/**chtioui*/

	

	@Transactional
	public void deleteDepartementById(int id) {
		logger.info("Je vais lancer la methode deleteDepartementById");
		logger.debug("Affiche d'un departementByid");
		Optional <Departement> departement = deptRepoistory.findById(id);
		logger.debug("Test de isPresent d'un departement");
		try {
         if (departement.isPresent()) {
         deptRepoistory.delete(departement.get());	
		}
		else {
			logger.warn("N'existe pas");
		}
		}
		 catch(Exception e){
			 logger.error("Erreur dans deleteDepartementById:"+e.toString());
		    } 
	}
	



}