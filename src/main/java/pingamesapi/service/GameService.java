package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Empresa;
import pingamesapi.domain.Game;
import pingamesapi.domain.Plataforma;
import pingamesapi.dto.Cadastra.CadastraGame;
import pingamesapi.dto.Read.ReadGame;
import pingamesapi.repository.GameRepository;
import pingamesapi.service.exceptions.ObjectNotFoundException;

@Service
public class GameService {
	
	@Autowired
	private PlataformaService plataformaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<ReadGame> readAll(){
		return buildDTO(gameRepository.findAll());
	}

	
	public Game create(CadastraGame obj) {
		return gameRepository.save(fromDTO(obj)); 
	}

	public Game update(Game obj) {
		if(gameRepository.existsById(obj.getId())) {
			return gameRepository.save(obj);
		}
		throw new ObjectNotFoundException("Object não encontrado! id:" + obj.getId() + ", Tipo:" + Game.class.getName());
	}
	
	public Game findOne(Long id) {
		return gameRepository.findById(id).get();
	}

	private Game fromDTO(CadastraGame obj) {
		Game game = new Game();
		game.setNome(obj.getNome());
		game.setDataLancamento(obj.getDataLancamento());
		game.setPreco(obj.getPreco());
		game.setFaixaEtaria(obj.getFaixaEtaria());
		game.setGenero(obj.getGenero());
		game.setDescricao(obj.getDescricao());
		
		if(plataformaService.findOne(obj.getId_plataforma()) == null) {
			throw new ObjectNotFoundException("Plataforma não encontrado! id:" + obj.getId_plataforma() + ", Tipo:" + Game.class.getName());
		}
		
		Plataforma plat = plataformaService.findOne(obj.getId_plataforma());
		plat.getJogos().add(game);
		plataformaService.update(plat);
		game.setPlataforma(plat);

		if(empresaService.findOne(obj.getId_empresa()) == null) {
			throw new ObjectNotFoundException("Empresa não encotrada! id:" + obj.getId_empresa() + ", Tipo:" + game.getClass().getName());
		}
		
		Empresa emp = empresaService.findOne(obj.getId_empresa());
		emp.getJogos().add(game);
		empresaService.update(emp);
		game.setEmpresa(emp);
		return game;
	}

	public List<Game> findGames(String nome) {
		return gameRepository.findAllNomes(nome);
	}
	
	public List<ReadGame> buildDTO(List<Game> gamesDB) {
		List<ReadGame> games = new ArrayList<ReadGame>();
		for (Game game : gamesDB) {
			ReadGame aux = new ReadGame();
			aux.setId(game.getId());
			aux.setNome(game.getNome());
			aux.setGenero(game.getGenero());
			aux.setFaixa(game.getFaixaEtaria());
			games.add(aux);
		}
		return games;
	}


	public Page<ReadGame> pesquisar(Integer page, Integer line) {
		PageRequest pageRequest = PageRequest.of(page,line);
		Page<Game> aux = gameRepository.findAll(pageRequest);
		Page<ReadGame> lista = aux.map(game -> new ReadGame(game));
		return lista;
	}

}
