package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class DepartementServiceImpl implements IDepartementService {


	@Autowired
	DepartementRepository deptRepoistory;

	private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);

	public List<Departement> getAllDepartements() {
		logger.info("Je vais lancer la methode getAllDepartements");
		List<Departement> dep = (List<Departement>) deptRepoistory.findAll();
		logger.debug("L'affichage des Departements");
		return (List<Departement>) deptRepoistory.findAll();
	}

}
