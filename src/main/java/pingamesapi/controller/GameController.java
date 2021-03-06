package pingamesapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pingamesapi.domain.Game;
import pingamesapi.dto.PageDTO;
import pingamesapi.dto.Cadastra.CadastraGame;
import pingamesapi.service.GameService;

@Controller
@RequestMapping("/jogos")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@PostMapping
	public ResponseEntity<Game> crgeate(@Valid @RequestBody CadastraGame obj){
		return new ResponseEntity<Game>(gameService.create(obj), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game obj){
		obj.setId(id);
		return new ResponseEntity<Game>(gameService.update(obj), HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Page<Game>> pageGame(Pageable pageable) {	
		return ResponseEntity.ok().body(gameService.pesquisar(pageable));
	}
	
	@GetMapping("/pesquisar")
	public ResponseEntity<List<Game>> findByNameAndGenero(Game game){
		return ResponseEntity.ok().body(gameService.buscarPorParam(game));
	}
}