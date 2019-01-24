package pingamesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pingamesapi.domain.Game;
import pingamesapi.dto.CadastraGame;
import pingamesapi.service.GameService;

@Controller
@RequestMapping("/jogos")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(path = "/todos")
	public ResponseEntity<List<Game>> readAll(){
		return new ResponseEntity<List<Game>>(gameService.readAll(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/novo")
	public ResponseEntity<Game> create(@RequestBody CadastraGame obj){
		return new ResponseEntity<Game>(gameService.create(obj), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}/atualizacao")
	public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game obj){
		obj.setId(id);
		return new ResponseEntity<Game>(gameService.update(obj), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}/deletando")
	public ResponseEntity<Game> update(@PathVariable Long id) {
		gameService.delete(id);
		return ResponseEntity.ok().build();
	}
}
