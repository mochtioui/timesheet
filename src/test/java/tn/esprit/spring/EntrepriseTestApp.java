package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;




public class EntrepriseTestApp extends AbstractTest {

	private static final Logger l = LogManager.getLogger(EntrepriseTestApp.class);
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
   }
	
	 @Test
	   public void ajouterEntreprise() throws Exception {
	      String uri = "/ajouterEntreprise";
	      Entreprise entreprise = new Entreprise();
	      entreprise.setId(2);;
	      entreprise.setName("Ginger");
	      entreprise.setRaisonSocial("Lac 2");
	      String inputJson = super.mapToJson(entreprise);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("l'entreprise a été ajouté avec succés");
	      }else if(status == 201) {
	    	  l.info("l'entreprise a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }
	   
	   
	   @Test
	   public void ajouterDepartement() throws Exception {
	      String uri = "/ajouterDepartement";
	      Departement departement = new Departement();
	      departement.setId(1);;
	      departement.setName("Ginger");
	 
	      String inputJson = super.mapToJson(departement);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le departement a été ajouté avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
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
		    	  l.info("l'entreprise a été recupérée avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
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
	    	  l.info("les deârtmenets de l'entreprise ont été recupérées avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
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
	    	  l.info("le département a été affecté à l'entreprise avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	  
 
	   @Test
	   public void deleteEntreprise() throws Exception {
	      String uri = "/deleteEntrepriseById/13";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("l'entreprise a été supprimée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	   @Test
	   public void deleteDepartement() throws Exception {
	      String uri = "/deleteDepartementById/9";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le département a été recupérée avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	
	   
	
}
