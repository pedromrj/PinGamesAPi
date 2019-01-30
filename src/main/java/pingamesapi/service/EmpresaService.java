package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.controller.exceptions.ErrorValidacao;
import pingamesapi.domain.Empresa;
import pingamesapi.dto.Cadastra.CadastraEmpresa;
import pingamesapi.dto.Read.ReadEmpresa;
import pingamesapi.repository.EmpresaRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;
import pingamesapi.service.exceptions.ValidacaoException;
import pingamesapi.service.utils.CpfAndCnpj;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa findOne(Long id){
		if(empresaRepository.existsById(id)) {
			return empresaRepository.findById(id).get();
		}
		throw new ObjectNotFoundException("Empresa não encotrada! id:" + id + ", Tipo:" + Empresa.class.getName());
	}

	public List<ReadEmpresa> readAll() {
		return buildDTO(empresaRepository.findAll());
	}

	public Empresa create(CadastraEmpresa obj){
		ValidEmp(obj);
		return empresaRepository.save(fromDTO(obj));
	}

	
	public Empresa update(Empresa obj) {
		if(empresaRepository.existsById(obj.getId())) {
			return empresaRepository.save(obj);
		}
		throw new ObjectNotFoundException("Empresa não encotrada! id:" + obj.getId() + ", Tipo:" + Empresa.class.getName());
	}
	
	private Empresa fromDTO(CadastraEmpresa obj) {
		ModelMapper model = new ModelMapper();
		Empresa emp = model.map(obj,Empresa.class);
		return emp;
	}

	private List<ReadEmpresa> buildDTO(List<Empresa> empBD) {
		List<ReadEmpresa> emp = new ArrayList<ReadEmpresa>();
		for (Empresa empresas : empBD) {
			ReadEmpresa aux = new ReadEmpresa();
			aux.setId(empresas.getId());
			aux.setNome(empresas.getNome());
			emp.add(aux);
		}
		return emp;
	}
	
	private boolean heInteiro(String cpf) {
		char[] letra = cpf.toCharArray();
		for (int i = 0; i < letra.length; i++) {
			if(Character.isDigit(letra[i])) {
				return false;
			}
		}
		return true;
	}
	
	private boolean ValidEmp(CadastraEmpresa empDTO){
		List<ErrorValidacao> erros = new ArrayList<ErrorValidacao>();
		if(heInteiro(empDTO.getCnpj())) {
			erros.add(new ErrorValidacao("CNPJ", "CNPJ POSSUI LETRAS"));
		}
		if(!CpfAndCnpj.validCnpj(empDTO.getCnpj())) {
			erros.add(new ErrorValidacao("CNPJ", "CNPJ INVALIDO !!"));
		}
		
		if(erros.size() != 0) {
			throw new ValidacaoException(erros, "ERRO DE PARAMETRO!!");
		}
		return true;
	}
}