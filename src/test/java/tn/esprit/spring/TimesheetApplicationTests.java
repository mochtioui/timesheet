package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.TimesheetServiceImpl;
import static org.junit.Assert.assertEquals;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.AfterAll;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests {
	
	private static final Logger logger= LogManager.getLogger(TimesheetApplicationTests.class);
	
	@Autowired
	TimesheetServiceImpl tim ; 

	@Test
	public void testAjoutEmploye() {
		String date = "January 2, 2010";
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date1 = null;
		try {
			date1 = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String datee = "January 3, 2010";
		DateFormat format1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date datee1 = null;
		try {
			datee1 = format1.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		Timesheet e = new Timesheet();
		tim.ajouterTimesheet(1, 1, date1, datee1);
		logger.info("you have added a new timesheet !");
		logger.info("the employee you just added had as an ID  !");

 }
	 }