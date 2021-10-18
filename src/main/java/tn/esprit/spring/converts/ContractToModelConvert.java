package tn.esprit.spring.converts;
import org.springframework.core.convert.converter.Converter;

import tn.esprit.spring.dto.ContratModel;
import tn.esprit.spring.entities.Contrat;
public class ContractToModelConvert implements Converter<Contrat, ContratModel> {
	

	@Override
	public ContratModel convert(Contrat source) {
		 ContratModel target=new ContratModel();
		 target.setReference(source.getReference());
		 target.setDateDebut(source.getDateDebut());
		 target.setEmploye(source.getEmploye());
		 target.setSalaire(source.getSalaire());
		 target.setTelephone(source.getTelephone());
		 target.setTypeContrat(source.getTypeContrat());
		// TODO Auto-generated method stub
		return target;
	}

}
