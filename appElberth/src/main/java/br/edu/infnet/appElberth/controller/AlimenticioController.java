package br.edu.infnet.appElberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appElberth.model.domain.Alimenticio;
import br.edu.infnet.appElberth.model.service.AlimenticioService;

@RestController
public class AlimenticioController {

	@Autowired
	private AlimenticioService alimenticioService;
	
	@GetMapping(value = "alimenticio/listar")
	public Iterable<Alimenticio> obterLista(){
		return alimenticioService.obterLista();
	}
	
	@GetMapping(value = "alimenticio/{id}")
	public Alimenticio obterPorId(@PathVariable Integer id) {
		return alimenticioService.obterPorId(id);
	}
	
	@PostMapping(value = "alimenticio/incluir")	
	public String incluir(@RequestBody Alimenticio alimenticio) {
		
		alimenticioService.incluir(alimenticio);
		
		return "A inclusão do " + alimenticio + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "alimenticio/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		alimenticioService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}