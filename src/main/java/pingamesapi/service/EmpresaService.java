package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Empresa;
import pingamesapi.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa findOne(Long id){
		return empresaRepository.findById(id).get();
	}

	public List<Empresa> readAll() {
		return empresaRepository.findAll();
	}

	public Empresa create(Empresa obj){
		return empresaRepository.save(obj);
	}

	public Empresa update(Empresa obj) {
		return empresaRepository.save(obj);
	}

	public void delete(Long id) throws Exception {
		if (empresaRepository.existsById(id)) {
			empresaRepository.deleteById(id);
		}
		throw new Exception("NAO ENCONTRADO!!");
	}

}
