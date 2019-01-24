package pingamesapi.service;

import java.util.List;

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

	public List<Biblioteca> readAll() {
		return bibliotecaRepository.findAll();
	}

	public Biblioteca create(Biblioteca obj) {
		return bibliotecaRepository.save(obj);
	}

	public Biblioteca update(Biblioteca obj) {
		// LOGICA
		return null;
	}

	public void delete(Long id) {
		bibliotecaRepository.deleteById(id);	
	}

}
