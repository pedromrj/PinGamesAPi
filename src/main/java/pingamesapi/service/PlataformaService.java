package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Plataforma;
import pingamesapi.repository.PlataformaRepository;

@Service
public class PlataformaService {
	
	@Autowired
	private PlataformaRepository plataformaRepository;
	
	public List<Plataforma> readAll(){
		return plataformaRepository.findAll();
	}

	public Plataforma create(Plataforma obj) {
		return plataformaRepository.save(obj);
	}

	public Plataforma update(Plataforma obj) {
		if(plataformaRepository.existsById(obj.getId())) {
			return plataformaRepository.save(obj);
		}
		return obj;
	}

	public void delete(Long id) {
		if(plataformaRepository.existsById(id)) {
			plataformaRepository.deleteById(id);
		}
	}

	public Plataforma findOne(Long id) {
		return plataformaRepository.findById(id).get();
	}

}
