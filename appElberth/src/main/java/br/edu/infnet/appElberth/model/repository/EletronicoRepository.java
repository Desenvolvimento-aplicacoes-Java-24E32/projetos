package br.edu.infnet.appElberth.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appElberth.model.domain.Eletronico;

@Repository
public interface EletronicoRepository extends CrudRepository<Eletronico, Integer> {
	Collection<Eletronico> findByMarcaContaining(String marca);

	Collection<Eletronico> findAll(Sort orderBy);
}
