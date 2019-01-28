package pingamesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pingamesapi.domain.Empresa;
import pingamesapi.dto.Cadastra.CadastraEmpresa;
import pingamesapi.dto.Read.ReadEmpresa;
import pingamesapi.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Empresa> findOne(@PathVariable Long id) {
		return new ResponseEntity<Empresa>(empresaService.findOne(id),HttpStatus.OK);
	}
	
	@GetMapping(path = "/todos")
	public ResponseEntity<List<ReadEmpresa>> readAll(){
		return new ResponseEntity<List<ReadEmpresa>>(empresaService.readAll(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/novo")
	public ResponseEntity<Empresa> create(@RequestBody CadastraEmpresa obj){
		return new ResponseEntity<Empresa>(empresaService.create(obj), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}/atualizacao")
	public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa obj){
		return new ResponseEntity<Empresa>(empresaService.update(obj), HttpStatus.OK);
	}
}
