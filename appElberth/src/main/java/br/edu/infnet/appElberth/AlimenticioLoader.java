package br.edu.infnet.appElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appElberth.model.domain.Alimenticio;
import br.edu.infnet.appElberth.model.service.AlimenticioService;

@Component
public class AlimenticioLoader implements ApplicationRunner {

	@Autowired
	private AlimenticioService alimenticioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/alimenticio.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			Alimenticio alimenticio = new Alimenticio();
			alimenticio.setCodigo(Integer.valueOf(campos[0]));
			alimenticio.setDescricao(campos[1]);
			alimenticio.setEstoque(Boolean.valueOf(campos[2]));
			alimenticio.setPreco(Float.valueOf(campos[3]));
			alimenticio.setCaracteristica(campos[4]);
			alimenticio.setOrganico(Boolean.valueOf(campos[5]));

			alimenticioService.incluir(alimenticio);
			
			linha = leitura.readLine();
		}
		
		for(Alimenticio a : alimenticioService.obterLista()) {
			System.out.println("[ALIMENTÍCIO] " + a);
		}
		
		leitura.close();
	}
}
