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
		entrepriseRepoistory.save(entreprise);
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
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

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
	public Entreprise getEntrepriseById(int entrepriseId) {
		logger.info("Je vais lancer la methode getEntrepriseById");
		logger.debug("Affichage d'un entreprise");
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}

}