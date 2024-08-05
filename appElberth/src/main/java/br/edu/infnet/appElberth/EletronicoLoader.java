package br.edu.infnet.appElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appElberth.model.domain.Eletronico;

@Component
public class EletronicoLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/eletronico.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			Eletronico eletronico = new Eletronico();
			eletronico.setCodigo(Integer.valueOf(campos[0]));
			eletronico.setDescricao(campos[1]);
			eletronico.setEstoque(Boolean.valueOf(campos[2]));
			eletronico.setPreco(Float.valueOf(campos[3]));
			eletronico.setMarca(campos[4]);
			eletronico.setGarantiaMeses(Integer.valueOf(campos[5]));

			System.out.println("[ELETRÔNICO] " + eletronico);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}
