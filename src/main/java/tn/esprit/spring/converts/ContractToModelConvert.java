package tn.esprit.spring.converts;
import org.springframework.core.convert.converter.Converter;

import tn.esprit.spring.dto.ContratModel;
import tn.esprit.spring.entities.Contrat;
/**
 * 
 * @author Ibrahim
 *
 */
public class ContractToModelConvert implements Converter<Contrat, ContratModel> {
	
	
   /**
    * @description convert contract entity to contract model
    */
	@Override
	public ContratModel convert(Contrat source) {
		 ContratModel target=new ContratModel();
		 target.setRef(source.getReference());
		 target.setStartDate(source.getDateDebut());
		 target.setEmp(source.getEmploye());
		 target.setSal(source.getSalaire());
		 target.setTel(source.getTelephone());
		 target.setType(source.getTypeContrat());
		return target;
	}

}
