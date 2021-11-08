package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IEntrepriseService;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests  extends AbstractTest   {

	private static final Logger logger= LogManager.getLogger(TimesheetApplicationTests.class);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
    IEmployeService  empService ;
	@Autowired
    EmployeServiceImpl  empcontract ;
    @Autowired
	ContratServiceImpl contratService;


	@Autowired
	IEntrepriseService ientrepriseservice;

	@Autowired
	ContratServiceImpl ser ; 
	

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
   }


	
	
	@Test
	@Order(1)
	public void addContrat() throws ParseException {
			
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat contrat = new Contrat(sqlDate ,"test",12);
		Contrat Contratadded = ser.addContrat(contrat);
		Assert.assertEquals(contrat.getTypeContrat(), Contratadded.getTypeContrat());
	}
	
	@Test
	@Order(3)
	public void getAllContrat() {
		List<Contrat> listcontrats = ser.getAllContrats();
		Assert.assertEquals(listcontrats.size(), listcontrats.size());
	}
	
	@Test
	@Order(2)
	public void updateContrat() throws ParseException   {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		Contrat con = new Contrat(2,sqlDate ,"test",15);
		Contrat contratModified = ser.updateContrat(con);
		Assert.assertEquals(con.getTypeContrat(), contratModified.getTypeContrat());
	}
	
	@Test
	@AfterAll
	public void deleteContrat() {
		ser.remove("1");
		Assert.assertNull(ser.getContrat("1"));
		
		
	}


   /*** chtioui */
   @Test
	   public void ajouterEntreprise() throws Exception {
	      String uri = "/ajouterEntreprise";
	      Entreprise entreprise = new Entreprise();
	      entreprise.setId(2);;
	      entreprise.setName("Chtioui");
	      entreprise.setRaisonSocial("Nice");
	      String inputJson = super.mapToJson(entreprise);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  logger.info("l'entreprise a été ajouté avec succés");
	      }else if(status == 201) {
	    	  logger.info("l'entreprise a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  logger.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  logger.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }



	    @Test
	   public void ajouterDepartement() throws Exception {
	      String uri = "/ajouterDepartement";
	      Departement departement = new Departement();
	      departement.setId(1);;
	      departement.setName("Info");
	 
	      String inputJson = super.mapToJson(departement);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  logger.info("le departement a été ajouté avec succés");
		      }else if(status >= 400 && status <500) {
		    	  logger.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  logger.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }



	   @Test
	   public void getEntrepriseById() throws Exception {
	      String uri = "/getEntrepriseById/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      Entreprise entreprise = super.mapFromJson(content, Entreprise.class);
	      assertTrue(entreprise != null);
	          if(status == 200) {
	        	  logger.info("l'entreprise a été recupérée avec succés");
		      }else if(status >= 400 && status <500) {
		    	  logger.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  logger.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }


	   @Test
	   public void getAllDepartementsNamesByEntreprise() throws Exception {
	      String uri = "/getAllDepartementsNamesByEntreprise/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	     
	      if(status == 200) {
	    	  logger.info("les deârtmenets de l'entreprise ont été recupérées avec succés");
	      }else if(status >= 400 && status <500) {
	    	  logger.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  logger.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	
	
	   @Test
	   public void affecterDepartementAEntreprise() throws Exception {
	      String uri = "/affecterDepartementAEntreprise/6/10";
	   
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	        ).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  logger.info("le département a été affecté à l'entreprise avec succés");
	      }else if(status >= 400 && status <500) {
	    	  logger.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  logger.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	  
 

 @Test
	   public void deleteEntreprise() throws Exception {
	      String uri = "/deleteEntrepriseById/13";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  logger.info("l'entreprise a été supprimée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  logger.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  logger.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	   @Test
	   public void deleteDepartement() throws Exception {
	      String uri = "/deleteDepartementById/9";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  logger.info("le département a été recupérée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  logger.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  logger.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	   

	   /****chtioui end */
	
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
	
	
	
	

	@Test
	public void testAjoutEntrepriseDep() {
		logger.info("Je vais lancer la methode getAllDepartements");
		Entreprise e = new Entreprise(" Consulting", "Cite El Ghazela");
		logger.debug("L'ajoute d'un Entreprise");
		ientrepriseservice.ajouterEntreprise(e);
        Departement department = new Departement();
		
		department.setName("Dev");
		logger.debug("L'ajoute d'un Departement 1");
		ientrepriseservice.ajouterDepartement(department);
		
		Departement department1 = new Departement();
		department1.setName("HR");
		logger.debug("L'ajoute d'un Departement 2");
		ientrepriseservice.ajouterDepartement(department1);
		logger.info("Sortie de la méthode");
	    }
	
	@Test
	public void testAffectation() {
	    	logger.info("Je vais lancer la methode testAffectation");
	    	logger.debug("Affecter departement Dev à l'entreprise Consultant");
			ientrepriseservice.affecterDepartementAEntreprise(1, 1);
			logger.debug("Affecter departement HR à l'entreprise Consultant");
			ientrepriseservice.affecterDepartementAEntreprise(2, 1);
			logger.info("Sortie de la méthode");
		}
	
	
	
	
	
	@Test
	public void testDeleteEmployee() {
	     empService.deleteEmployeById(13);
	logger.warn("you have deleted an employee  !");
}
	
	@Test
	public void testUpdatePasswordEmployee() {
	     empService.mettreAjourPasswordByEmployeId( "testpass",14);
	logger.info("you have updated  an employee's password  !");
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
		
		logger.debug("you have affected an employee to a contract ");
  }
	

}
