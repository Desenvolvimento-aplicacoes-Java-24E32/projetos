package br.edu.infnet.appElberth.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Produto;
import br.edu.infnet.appElberth.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Iterable<Produto> obterLista(){
		return produtoRepository.findAll();
	}

	public long obterQtde() {
		return produtoRepository.count();
	}
	
}