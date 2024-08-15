package br.edu.infnet.appElberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appElberth.model.domain.Eletronico;

@Repository
public interface EletronicoRepository extends CrudRepository<Eletronico, Integer> {

}
