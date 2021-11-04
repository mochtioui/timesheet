package tn.esprit.spring;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests    {

	
IEmployeService  empService ;
	
	@Test
	public void contextLoads()  {
		boolean actif = true ;
	Employe e = new Employe ("khaoula" , "khemiri" ,"khaoula.khmiri@esprit.tn" , "khaoula" , actif , Role.ADMINISTRATEUR) ;	
		
	empService.addOrUpdateEmploye(e);	
		
	}

}
