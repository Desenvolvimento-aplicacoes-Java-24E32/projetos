package br.edu.infnet.appElberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}