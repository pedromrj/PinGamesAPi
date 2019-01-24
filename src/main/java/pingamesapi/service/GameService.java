package pingamesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Empresa;
import pingamesapi.domain.Game;
import pingamesapi.domain.Plataforma;
import pingamesapi.dto.CadastraGame;
import pingamesapi.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private PlataformaService plataformaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> readAll(){
		return gameRepository.findAll();
	}

	public Game create(CadastraGame obj) {
		return gameRepository.save(fromDTO(obj)); 
	}

	public Game update(Game obj) {
		Game game = gameRepository.findById(obj.getId()).get();
		processar(obj,game);
		return gameRepository.save(obj);
	}

	private void processar(Game obj, Game game) {
		
	}

	public void delete(Long id) {
		if(gameRepository.existsById(id)) {
			gameRepository.deleteById(id);
		}
	}
	
	public Game findOne(Long id) {
		return gameRepository.findById(id).get();
	}
	
	private Plataforma getPlataforma(Long id) {
		for (Plataforma plat : plataformaService.readAll()) {
			if(plat.getId() == id) {
				return plat;
			}
		}
		return null;
	}

	private Game fromDTO(CadastraGame obj) {
		Game game = new Game();
		game.setNome(obj.getNome());
		game.setDataLancamento(obj.getDataLancamento());
		game.setPreco(obj.getPreco());
		game.setFaixaEtaria(obj.getFaixaEtaria());
		game.setGenero(obj.getGenero());
		game.setDescricao(obj.getDescricao());
		
		Plataforma plat = getPlataforma(obj.getId_plataforma());
		plat.getJogos().add(game);
		plataformaService.update(plat);
		game.setPlataforma(plat);
		
		Empresa emp = empresaService.findOne(obj.getId_empresa());
		emp.getJogos().add(game);
		empresaService.update(emp);
		game.setEmpresa(emp);
		return game;
	}
}
