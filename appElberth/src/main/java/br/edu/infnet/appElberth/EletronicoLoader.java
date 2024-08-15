package br.edu.infnet.appElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appElberth.model.domain.Eletronico;
import br.edu.infnet.appElberth.model.domain.Vendedor;
import br.edu.infnet.appElberth.model.service.EletronicoService;

@Component
public class EletronicoLoader implements ApplicationRunner {
	
	@Autowired
	private EletronicoService eletronicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/eletronico.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[6]));			
			
			Eletronico eletronico = new Eletronico();
			eletronico.setCodigo(Integer.valueOf(campos[0]));
			eletronico.setDescricao(campos[1]);
			eletronico.setEstoque(Boolean.valueOf(campos[2]));
			eletronico.setPreco(Float.valueOf(campos[3]));
			eletronico.setMarca(campos[4]);
			eletronico.setGarantiaMeses(Integer.valueOf(campos[5]));
			
			eletronico.setVendedor(vendedor);
			
			eletronicoService.incluir(eletronico);
			
			linha = leitura.readLine();
		}
		
		for(Eletronico e : eletronicoService.obterLista()) {			
			System.out.println("[ELETRÔNICO] " + e);
		}
		
		leitura.close();
	}
}
