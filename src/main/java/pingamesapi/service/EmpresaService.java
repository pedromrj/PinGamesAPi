package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.controller.exceptions.ErrorValidacao;
import pingamesapi.controller.exceptions.ValidacaoException;
import pingamesapi.domain.Empresa;
import pingamesapi.dto.Cadastra.CadastraEmpresa;
import pingamesapi.dto.Read.ReadEmpresa;
import pingamesapi.repository.EmpresaRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {
	private static final int[] PESO_CNPJ = new int[] {6,5,4,3,2,9,8,7,6,5,4,3,2};
	public static final Integer DIVISOR = 11;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa findOne(Long id){
		return empresaRepository.findById(id).get();
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
		Empresa emp = new Empresa();
		emp.setNome(obj.getNome());
		emp.setCnpj(obj.getCnpj());
		emp.setFaturamento(obj.getFaturamento());
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
	
	private boolean validCnpj(String cnpj) {
		if(cnpj.length() != 14) {
			return false;
		}
		int J;
		int K;
		int soma = 0;
		int cont = 0;
		char[] aux = cnpj.toCharArray();
		for (int i = 1; i <= 12; i++) {
			soma+= Integer.parseInt(String.valueOf(aux[cont]))*PESO_CNPJ[i];
			cont++;
		}
		if(soma%DIVISOR == 0 || soma%DIVISOR == 1) {
			J = 0;
		} else {
			J = DIVISOR-(soma%DIVISOR);
		}
		
		cont = 0;
		soma = 0;
		for (int i = 0; i <= 12; i++) {
			if(i == 12) {
				soma += J * PESO_CNPJ[12];
			} else {
				soma += PESO_CNPJ[i]*Integer.parseInt(String.valueOf(aux[cont]));
			}
			cont++;
		}
		
		if(soma%DIVISOR == 0 || soma%DIVISOR == 1) {
			K = 0;
		} else {
			K = DIVISOR-(soma%DIVISOR);
		}
		
		if(J == Integer.parseInt(String.valueOf(aux[12])) && K == Integer.parseInt(String.valueOf(aux[13]))) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean ValidEmp(CadastraEmpresa empDTO){
		List<ErrorValidacao> erros = new ArrayList<ErrorValidacao>();
		if(heInteiro(empDTO.getCnpj())) {
			erros.add(new ErrorValidacao("CNPJ", "CNPJ POSSUI LETRAS"));
		}
		if(!validCnpj(empDTO.getCnpj())) {
			erros.add(new ErrorValidacao("CNPJ", "CNPJ INVALIDO !!"));
		}
		
		if(erros.size() != 0) {
			throw new ValidacaoException(erros, "ERRO DE PARAMETRO!!");
		}
		return true;
	}
}