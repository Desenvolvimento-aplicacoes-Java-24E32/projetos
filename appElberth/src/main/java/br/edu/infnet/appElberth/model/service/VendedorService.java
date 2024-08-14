package br.edu.infnet.appElberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Vendedor;
import br.edu.infnet.appElberth.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public void incluir(Vendedor vendedor) {
		vendedorRepository.save(vendedor);
	}
	
	public Iterable<Vendedor> obterLista(){
		
		return vendedorRepository.findAll();
	}
	
	public Vendedor obterPorId(Integer id) {
		return vendedorRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}

	public long obterQtde() {
		return vendedorRepository.count();
	}
}