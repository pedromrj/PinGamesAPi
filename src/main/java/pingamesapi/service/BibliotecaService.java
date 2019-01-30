package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Biblioteca;
import pingamesapi.domain.Game;
import pingamesapi.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	public Biblioteca findOne(Long id) {
		return bibliotecaRepository.findById(id).get();
	}

	public Biblioteca create(Biblioteca obj) {
		return bibliotecaRepository.save(obj);	
	}

	public Biblioteca update(Biblioteca obj) {
		return bibliotecaRepository.save(obj);
	}
	
	public boolean verificacaoDeJogos(List<Game> game , Long id) {
		Biblioteca lib = bibliotecaRepository.findById(id).get();
		for (Game jogo : game) {
			for (Biblioteca lib2 : jogo.getJogos()) {
				if(lib.getId().equals(lib2.getId())) {
					return true;
				}
			}
		}
		return false;
	}

}
