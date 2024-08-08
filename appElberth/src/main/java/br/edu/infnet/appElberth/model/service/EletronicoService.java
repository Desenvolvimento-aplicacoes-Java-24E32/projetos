package br.edu.infnet.appElberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appElberth.model.domain.Eletronico;

@Service
public class EletronicoService {

	private Map<Integer, Eletronico> mapa = new HashMap<Integer, Eletronico>();
	private Integer id = 0;			
	
	public void incluir(Eletronico eletronico) {
		eletronico.setId(++id);
		
		mapa.put(eletronico.getId(), eletronico);
	}
	
	public Collection<Eletronico> obterLista(){
		return mapa.values();
	}
	
	public Eletronico obterPorId(Integer id) {
		return mapa.get(id);
	}
	
	public void excluir(Integer id) {
		mapa.remove(id);
	}
}