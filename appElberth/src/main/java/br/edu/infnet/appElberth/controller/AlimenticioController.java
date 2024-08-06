package br.edu.infnet.appElberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appElberth.model.domain.Alimenticio;
import br.edu.infnet.appElberth.model.service.AlimenticioService;

@RestController
public class AlimenticioController {

	@Autowired
	private AlimenticioService alimenticioService;
	
	@GetMapping(value = "alimenticio/listar")
	public Collection<Alimenticio> obterLista(){
		return alimenticioService.obterLista();
	}
}