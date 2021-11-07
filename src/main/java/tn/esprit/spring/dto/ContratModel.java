package tn.esprit.spring.dto;

import java.util.Date;
import tn.esprit.spring.entities.Employe;

/**
 * 
 * @author Ibrahim
 * @description contract model class to avoid dto 
 *
 */
public class ContratModel {


   /**
    * @description attribute of contract model    
    */
	private int ref;	
	private Date startDate;
	private  String type;
	private float tel;
	private Employe emp;
	private float sal;

	/**
	 * @description getters and setters
	 */
	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getTel() {
		return tel;
	}

	public void setTel(float tel) {
		this.tel = tel;
	}

	public Employe getEmp() {
		return emp;
	}

	public void setEmp(Employe emp) {
		this.emp = emp;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}
	public ContratModel() {
		super();
	}

   /**
    * @desciption constructors
    */
	public ContratModel(int ref, Date startDate, String type, float tel, Employe emp, float sal) {
		super();
		this.ref = ref;
		this.startDate = startDate;
		this.type = type;
		this.tel = tel;
		this.emp = emp;
		this.sal = sal;
	}

	public ContratModel(Date startDate, String type, float tel, Employe emp, float sal) {
		super();
		this.startDate = startDate;
		this.type = type;
		this.tel = tel;
		this.emp = emp;
		this.sal = sal;
	}




	
}
