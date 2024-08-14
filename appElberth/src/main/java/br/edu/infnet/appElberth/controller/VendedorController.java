package br.edu.infnet.appElberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appElberth.model.domain.Vendedor;
import br.edu.infnet.appElberth.model.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "vendedor/listar")
	public Iterable<Vendedor> obterLista(){
		return vendedorService.obterLista();
	}
	
	@GetMapping(value = "vendedor/{id}")
	public Vendedor obterPorId(@PathVariable Integer id) {
		return vendedorService.obterPorId(id);
	}
	
	@PostMapping(value = "vendedor/incluir")	
	public String incluir(@RequestBody Vendedor vendedor) {
		
		vendedorService.incluir(vendedor);
		
		return "A inclusão do " + vendedor + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "vendedor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		vendedorService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}