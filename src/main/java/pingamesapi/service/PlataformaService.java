package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Plataforma;
import pingamesapi.dto.Cadastra.CadastraPlataforma;
import pingamesapi.dto.Read.ReadPlataforma;
import pingamesapi.repository.PlataformaRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;

@Service
public class PlataformaService {

	@Autowired
	private PlataformaRepository plataformaRepository;

	public List<ReadPlataforma> readAll() {
		return buildListDTO(plataformaRepository.findAll());
	}

	public Plataforma create(CadastraPlataforma obj) {
		return plataformaRepository.save(fromDTO(obj));
	}

	public Plataforma update(Plataforma obj) {
		if (plataformaRepository.existsById(obj.getId())) {
			return plataformaRepository.save(obj);
		}
		throw new ObjectNotFoundException(
				"Empresa não encotrada! id:" + obj.getId() + ", Tipo:" + Plataforma.class.getName());
	}

	public Plataforma findOne(Long id) {
		if (plataformaRepository.existsById(id)) {
			return plataformaRepository.findById(id).get();
		}
		throw new ObjectNotFoundException("Empresa não encotrada! id:" + id + ", Tipo:" + Plataforma.class.getName());
	}

	private Plataforma fromDTO(CadastraPlataforma obj) {
		ModelMapper modelMapper = new ModelMapper();
		Plataforma plataforma = modelMapper.map(obj, Plataforma.class);
		return plataforma;
	}

	private ReadPlataforma buildDTO(Plataforma plat) {
		ModelMapper model = new ModelMapper();
		ReadPlataforma plata = model.map(plat, ReadPlataforma.class);
		return plata;
	}

	private List<ReadPlataforma> buildListDTO(List<Plataforma> platBD) {
		List<ReadPlataforma> plataformas = new ArrayList<ReadPlataforma>();
		for (Plataforma plataforma : platBD) {
			plataformas.add(buildDTO(plataforma));
		}
		return plataformas;
	}

}
