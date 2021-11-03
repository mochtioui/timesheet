package tn.esprit.spring.converts;

import org.springframework.core.convert.converter.Converter;

import tn.esprit.spring.entities.Contrat;

public class ContractToEntityConvert implements Converter<ContratModel, Contrat> {

	@Override
	public Contrat convert(ContratModel source) {
		Contrat target=new Contrat();
		target.setReference(source.getRef());
		target.setDateDebut(source.getStartDate());
		target.setEmploye(source.getEmp());
		target.setSalaire(source.getSal());
		target.setTelephone(source.getTel());
		target.setTypeContrat(source.getTel());
		return target;
	}

}
