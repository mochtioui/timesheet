package tn.esprit.spring.converts;

import org.springframework.core.convert.converter.Converter;

import tn.esprit.spring.dto.ContratModel;
import tn.esprit.spring.entities.Contrat;

/**
 * 
 * @author Ibrahim
 *
 */
public class ContractToEntityConvert implements Converter<ContratModel, Contrat> {

	/**
	 * @description convert  contract model to contract entity
	 */
	@Override
	public Contrat convert(ContratModel source) {
		Contrat target=new Contrat();
		target.setReference(source.getRef());
		target.setDateDebut(source.getStartDate());
		target.setEmploye(source.getEmp());
		target.setSalaire(source.getSal());
		target.setTelephone(source.getTel());
		target.setTypeContrat(source.getType());
		return target;
	}

}
