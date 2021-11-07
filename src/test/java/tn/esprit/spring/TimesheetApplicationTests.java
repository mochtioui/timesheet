package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests    {

	private static final Logger logger = LogManager.getLogger(TimesheetApplicationTests.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired

      IEmployeService  empService ;
	@Autowired

    EmployeServiceImpl  empcontract ;
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	@Autowired
	ContratServiceImpl contratService;
	
	
	@Test
	public void testAjoutEmploye() {
		
		Employe e = new Employe(false ,"khaoula.khmiri@esprit.tn", "test" ,"test" ,"test" , Role.CHEF_DEPARTEMENT);
		empService.addOrUpdateEmploye(e);
		logger.info("you have added " +e.getNom() +" as a new employee !");
		logger.info("the employee you just added had  " +e.getId() +" as an ID  !");

		assertThat(e.getNom()).isEqualTo("test");
		assertThat(e.getPassword()).isEqualTo("test");
	assertThat(e.getId()).isGreaterThan(0);



       
	    }
	
	
	
	/*@Test
	public void testDeleteEmployee() {
	     empService.deleteEmployeById(13);
	logger.info("you have deleted an employee  !");


	}*/
	
	@Test
	public void testUpdatePasswordEmployee() {
	     empService.mettreAjourPasswordByEmployeId( "testpass",14);
	logger.info("you have updated  an employee's password  !");
 

	}
	
	@Test
	public void testAjoutEntrepriseDep() {
		
		Entreprise e = new Entreprise(" Consulting", "Cite El Ghazela");
		ientrepriseservice.ajouterEntreprise(e);
        Departement department = new Departement();
		
		department.setName("Dev");
		ientrepriseservice.ajouterDepartement(department);
		
		Departement department1 = new Departement();
		//d1.setEntreprise(e);
		department1.setName("HR");
		ientrepriseservice.ajouterDepartement(department1);
	    }
	
	@Test
	public void testAffectEmployeeToADepartement()
	{
		empService.affecterEmployeADepartement(14, 1);
		logger.info("you have affected  an employee to a new departement  !");

	}
	
	@Test
	public void testDesaffectEmployeeToADepartement()
	{
		empService.desaffecterEmployeDuDepartement(14, 1);
		logger.info("you have affected  an employee to a new departement  !");

	}
	
	@Test
	public void testAjoutContrat() {
	String date ="31/12/2021";
     Date date1 = null;
	try {
		date1 = simpleDateFormat.parse(date);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

		Contrat e = new Contrat( date1 ,"CDI", 6000);
		empcontract.ajouterContrat(e);
		
		assertThat(e.getTypeContrat()).isEqualTo("CDI");
	assertThat(e.getSalaire()).isGreaterThan(3000);



       
	    }
	
	@Test
	public void testAffecterEmployeeContrat() {
	
		empcontract.affecterContratAEmploye(1,14);
		
		logger.debug("you have affectedd an employee to a contract ");



       
	    }
	

}
