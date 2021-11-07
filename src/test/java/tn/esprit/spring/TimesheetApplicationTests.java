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
		l.info("you have added " +e.getNom() +" as a new employee !");
		l.info("the employee you just added had  " +e.getId() +" as an ID  !");

		assertThat(e.getNom()).isEqualTo("test");
		assertThat(e.getPassword()).isEqualTo("test");
	assertThat(e.getId()).isGreaterThan(0);



       
	    }
	
	
	/*@Test
	public void testDeleteEmployee() {
	     empService.deleteEmployeById(13);
	l.info("you have deleted an employee  !");


	}*/
	
	@Test
	public void testUpdatePasswordEmployee() {
	     empService.mettreAjourPasswordByEmployeId( "testpass",14);
	l.info("you have updated  an employee's password  !");
 

	}
	
	

}
