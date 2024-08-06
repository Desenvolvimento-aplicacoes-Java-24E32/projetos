package br.edu.infnet.appElberth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping(value = "/")
	public String exibirMensagemAlow() {
		return "Olá... você acabou de entrar no AppElberth";
	}
	
	@GetMapping(value = "/home")
	public String exibirHome() {
		return "Elberth Lins Costa de Moraes";
	}
}
