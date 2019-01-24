package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Plataforma;
import pingamesapi.dto.CadastraPlataforma;
import pingamesapi.repository.PlataformaRepository;

@Service
public class PlataformaService {
	
	@Autowired
	private PlataformaRepository plataformaRepository;
	
	public List<Plataforma> readAll(){
		return plataformaRepository.findAll();
	}

	public Plataforma create(CadastraPlataforma obj) {
		return plataformaRepository.save(fromDTO(obj));
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
	
	private Plataforma fromDTO(CadastraPlataforma obj) {
		Plataforma plat = new Plataforma();
		plat.setPlataforma(obj.getPlataforma());
		return plat;
	}

}
