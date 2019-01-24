package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Empresa;
import pingamesapi.dto.CadastraEmpresa;
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

	public Empresa create(CadastraEmpresa obj){
		return empresaRepository.save(fromDTO(obj));
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
	
	private Empresa fromDTO(CadastraEmpresa obj) {
		Empresa emp = new Empresa();
		emp.setNome(obj.getNome());
		emp.setCnpj(obj.getCnpj());
		emp.setFaturamento(obj.getFaturamento());
		return emp;
	}


}
