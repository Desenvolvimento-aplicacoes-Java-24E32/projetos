package br.edu.infnet.appElberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appElberth.model.domain.Eletronico;
import br.edu.infnet.appElberth.model.service.EletronicoService;

@RestController
public class EletronicoController {

	@Autowired
	private EletronicoService eletronicoService;
	
	@GetMapping(value = "eletronico/listar")
	public Collection<Eletronico> obterLista(){
		return eletronicoService.obterLista();
	}
	
	@GetMapping(value = "eletronico/{id}")
	public Eletronico obterPorId(@PathVariable Integer id) {
		return eletronicoService.obterPorId(id);
	}
	
	@PostMapping(value = "eletronico/incluir")	
	public String incluir(@RequestBody Eletronico eletronico) {
		
		eletronicoService.incluir(eletronico);
		
		return "A inclusão do " + eletronico + " foi realizada com sucesso!!!";
	}
	
	@DeleteMapping(value = "eletronico/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		eletronicoService.excluir(id);
		
		return "A exclusão do id " + id + " foi realizada com sucesso!!!";
	}
}