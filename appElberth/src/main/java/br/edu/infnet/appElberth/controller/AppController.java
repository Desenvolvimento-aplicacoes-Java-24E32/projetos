package br.edu.infnet.appElberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appElberth.model.service.AlimenticioService;
import br.edu.infnet.appElberth.model.service.EletronicoService;
import br.edu.infnet.appElberth.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private AlimenticioService alimenticioService;
	@Autowired
	private EletronicoService eletronicoService;
	
	@GetMapping(value = "/")
	public String telaHome(Model model){

		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", 0);
		model.addAttribute("qtdeAlimenticio", alimenticioService.obterQtde());
		model.addAttribute("qtdeEletronico", eletronicoService.obterQtde());
		
		return "home";
	}
	
	@GetMapping(value = "/vendedor/listagem")
	public String listarVendedor(Model model) {

		model.addAttribute("listagem", vendedorService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/produto/listagem")
	public String listarProduto(Model model) {

		model.addAttribute("listagem", null);
		
		return telaHome(model);
	}

	@GetMapping(value = "/alimenticio/listagem")
	public String listarAlimenticio(Model model) {

		model.addAttribute("listagem", alimenticioService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/eletronico/listagem")
	public String listarEletronico(Model model) {

		model.addAttribute("listagem", eletronicoService.obterLista());
		
		return telaHome(model);
	}
}