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

import pingamesapi.domain.Usuario;
import pingamesapi.dto.CadastraUsuario;
import pingamesapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> findOne(@PathVariable Long id) {
		return new ResponseEntity<Usuario>(usuarioService.findOne(id), HttpStatus.OK);
	}

	@GetMapping(path = "/todas")
	public ResponseEntity<List<Usuario>> readAll() {
		return new ResponseEntity<List<Usuario>>(usuarioService.readAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/novo")
	public ResponseEntity<Usuario> create(@RequestBody CadastraUsuario obj) {
		return new ResponseEntity<Usuario>(usuarioService.create(obj), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}/atualizaca")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
		obj.setId(id);
		return new ResponseEntity<Usuario>(usuarioService.update(obj), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}/deletando")
	public ResponseEntity<Usuario> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.ok().build();
	}
}
