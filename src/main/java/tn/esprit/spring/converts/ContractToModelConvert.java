package tn.esprit.spring.converts;
import org.springframework.core.convert.converter.Converter;

import tn.esprit.spring.entities.Contrat;
public class ContractToModelConvert implements Converter<Contrat, ContratModel> {
	

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
