package br.edu.infnet.appElberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appElberth.model.domain.Alimenticio;

@Repository
public interface AlimenticioRepository extends CrudRepository<Alimenticio, Integer> {

}
