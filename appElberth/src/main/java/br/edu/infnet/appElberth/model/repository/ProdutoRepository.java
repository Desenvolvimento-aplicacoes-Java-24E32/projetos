package br.edu.infnet.appElberth.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appElberth.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	Collection<Produto> findByVendedorId(Integer id);

	Collection<Produto> findAll(Sort orderBy);
}
