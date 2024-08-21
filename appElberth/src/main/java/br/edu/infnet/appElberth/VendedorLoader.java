package br.edu.infnet.appElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appElberth.model.domain.Alimenticio;
import br.edu.infnet.appElberth.model.domain.Eletronico;
import br.edu.infnet.appElberth.model.domain.Endereco;
import br.edu.infnet.appElberth.model.domain.Vendedor;
import br.edu.infnet.appElberth.model.service.EnderecoService;
import br.edu.infnet.appElberth.model.service.VendedorService;

@Component
@Order(1)
public class VendedorLoader implements ApplicationRunner {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/vendedor.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		Vendedor vendedor = null;
		
		while(linha != null) {
			
			campos = linha.split(";");

			switch (campos[0].toUpperCase()) {
			case "V":

				Endereco endereco = enderecoService.obterPorCep(campos[4]);
				
				vendedor = new Vendedor();
				vendedor.setCpf(campos[1]);
				vendedor.setEmail(campos[2]);
				vendedor.setNome(campos[3]);
				vendedor.setEndereco(endereco);
				
				vendedorService.incluir(vendedor);
				
				break;

			case "A":
				Alimenticio alimenticio = new Alimenticio();
				alimenticio.setCodigo(Integer.valueOf(campos[1]));
				alimenticio.setDescricao(campos[2]);
				alimenticio.setEstoque(Boolean.valueOf(campos[3]));
				alimenticio.setPreco(Float.valueOf(campos[4]));
				alimenticio.setCaracteristica(campos[5]);
				alimenticio.setOrganico(Boolean.valueOf(campos[6]));
				
				vendedor.getProdutos().add(alimenticio);
				
				break;
				
			case "E":
				Eletronico eletronico = new Eletronico();
				eletronico.setCodigo(Integer.valueOf(campos[1]));
				eletronico.setDescricao(campos[2]);
				eletronico.setEstoque(Boolean.valueOf(campos[3]));
				eletronico.setPreco(Float.valueOf(campos[4]));
				eletronico.setMarca(campos[5]);
				eletronico.setGarantiaMeses(Integer.valueOf(campos[6]));
				
				vendedor.getProdutos().add(eletronico);

				break;

			default:
				break;
			}
			
			linha = leitura.readLine();
		}
		
		for(Vendedor v : vendedorService.obterLista()) {
			System.out.println("[VENDEDOR] " + v);			
		}
		
		String cpf = "123123123123";
		Vendedor v1 = vendedorService.obterPorCpf(cpf);
		System.err.println("[VENDEDOR] " + v1);
		
		leitura.close();
	}
}