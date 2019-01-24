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

import pingamesapi.domain.Plataforma;
import pingamesapi.dto.CadastraPlataforma;
import pingamesapi.service.PlataformaService;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {
	
	@Autowired
	private PlataformaService plataformaService;
	
	@GetMapping(path = "/todas")
	public ResponseEntity<List<Plataforma>> readAll(){
		return new ResponseEntity<List<Plataforma>>(plataformaService.readAll(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/novo")
	public ResponseEntity<Plataforma> create(@RequestBody CadastraPlataforma obj){
		return new ResponseEntity<Plataforma>(plataformaService.create(obj),HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}/atualizaca")
	public ResponseEntity<Plataforma> update(@PathVariable Long id, @RequestBody Plataforma obj){
		obj.setId(id);
		return new ResponseEntity<Plataforma>(plataformaService.update(obj),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}/deletando")
	public ResponseEntity<Plataforma> delete(@PathVariable Long id){
		plataformaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
