package br.edu.infnet.appElberth.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appElberth.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
	Vendedor findByCpf(String cpf);

	Collection<Vendedor> findAll(Sort orderBy);
}