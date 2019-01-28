package pingamesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Biblioteca;
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

}
