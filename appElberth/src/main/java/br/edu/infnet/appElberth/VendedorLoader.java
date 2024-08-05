package br.edu.infnet.appElberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appElberth.model.domain.Vendedor;

@Component
public class VendedorLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/vendedor.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] campos = null;
		
		while(linha != null) {
			
			campos = linha.split(";");

			Vendedor vendedor = new Vendedor();
			vendedor.setCpf(campos[0]);
			vendedor.setEmail(campos[1]);
			vendedor.setNome(campos[2]);
			
			System.out.println("[VENDEDOR] " + vendedor);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}