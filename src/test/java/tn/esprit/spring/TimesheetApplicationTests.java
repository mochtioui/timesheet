package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests    {

	private static final Logger l = LogManager.getLogger(TimesheetApplicationTests.class);
	@Autowired

      IEmployeService  empService ;
	
	@Test
	public void testAjoutEmploye() {
		
		Employe e = new Employe(false ,"mail", "test" ,"test" ,"test" , Role.CHEF_DEPARTEMENT);
		empService.addOrUpdateEmploye(e);
		assertThat(e.getNom()).isEqualTo("test");
		assertThat(e.getPassword()).isEqualTo("test");
	assertThat(e.getId()).isGreaterThan(0);



       
	    }
	
	
	@Test
	public void testDeleteProduct() {
	     empService.deleteEmployeById(13);
	     
	     
	   
	     
	     
	}

}
