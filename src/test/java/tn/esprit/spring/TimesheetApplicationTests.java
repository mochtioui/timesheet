package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@SpringBootTest
class TimesheetApplicationTests {
	
	@Autowired
	ContratRepository contratRepository;
	
	@Autowired
	EmployeRepository employeRepository;

	@Test
	void contextLoads() {
	}

}
