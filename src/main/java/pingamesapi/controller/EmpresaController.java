package pingamesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pingamesapi.domain.Empresa;
import pingamesapi.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(path = "/todos")
	public ResponseEntity<List<Empresa>> readAll(){
		return new ResponseEntity<List<Empresa>>(empresaService.readAll(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/novo")
	public ResponseEntity<Empresa> create(@RequestBody Empresa obj){
		return new ResponseEntity<Empresa>(empresaService.create(obj), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}/atualizacao")
	public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa obj){
		obj.setId(id);
		try {
			return new ResponseEntity<Empresa>(empresaService.update(obj), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping(path = "/{id}/deletando")
	public ResponseEntity<Empresa> update(@PathVariable Long id) {
		try {
			empresaService.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
}
