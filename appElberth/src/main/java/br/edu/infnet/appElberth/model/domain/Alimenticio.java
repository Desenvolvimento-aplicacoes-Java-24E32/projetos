package br.edu.infnet.appElberth.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TAlimenticio")
public class Alimenticio extends Produto {

	private boolean organico;
	@Size(min = 3, max = 10, message = "É necessário que o campo CARACTERISTICA tenha entre 3 e 10.")
	private String caracteristica;
	
	@Override
	public String toString() {
		
		return String.format("%s;%s;%s", 
				super.toString(), 
				organico ? "orgânico=sim" : "organico=não", 
				caracteristica
			);
	}

	public boolean isOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
}
