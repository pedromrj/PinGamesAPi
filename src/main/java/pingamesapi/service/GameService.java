package pingamesapi.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Empresa;
import pingamesapi.domain.Game;
import pingamesapi.domain.Plataforma;
import pingamesapi.dto.PageDTO;
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
		return listBuildDTO(gameRepository.findAll());
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
		if(gameRepository.existsById(id)) {
			return gameRepository.findById(id).get();
		}
		throw new ObjectNotFoundException("Object não encontrado! id:" + id + ", Tipo:" + Game.class.getName());
		
	}

	private Game fromDTO(CadastraGame obj) { 
		Game game = new Game(obj.getNome(),obj.getDataLancamento(),obj.getFaixaEtaria(),obj.getPreco(),obj.getDescricao(),obj.getGenero());
		
		Plataforma plat = plataformaService.findOne(obj.getPlataformaId());
		plat.getJogos().add(game);
		plataformaService.update(plat);
		game.setPlataforma(plat);
		
		Empresa emp = empresaService.findOne(obj.getEmpresaId());
		emp.getJogos().add(game);
		empresaService.update(emp);
		game.setEmpresa(emp);
		return game;
	}

	public List<Game> findGames(String nome) {
		return gameRepository.findAllNomes(nome);
	}
	
	public List<ReadGame> listBuildDTO(List<Game> gamesDB) {
		List<ReadGame> games = new ArrayList<ReadGame>();
		for (Game game : gamesDB) {
			games.add(buildDTO(game));
		}
		return games;
	}
	
	public ReadGame buildDTO(Game game) {
		ModelMapper model = new ModelMapper();
		ReadGame readGame = model.map(game, ReadGame.class);
		return readGame;
	}

	public Page<Game> pesquisar(Pageable pageable) {
		return gameRepository.findAll(pageable); 
		/*
				PageRequest pageRequest = PageRequest.of(page,line);
		Page<Game> aux = gameRepository.findAll(pageRequest);
		Page<ReadGame> lista = aux.map(game -> new ReadGame(game));
		
		return lista;
	*/
	}
	
	public List<Game> buscarPorParam(Game game) {
			ExampleMatcher matcher = ExampleMatcher.matchingAll()
					.withMatcher("nome", match -> match.contains())
					.withMatcher("genero", match -> match.contains())
					.withIgnoreCase()
					.withIgnoreNullValues();
					return gameRepository.findAll(Example.of(game,matcher));
	}
	/*
	public PageDTO page(Integer page, Integer size) {
		List<Game> bd = gameRepository.findAll();
		List<Game> listagem = new ArrayList<Game>();
		for (int i = ((page * size)- size); i < (page* size); i++) {
			listagem.add(bd.get(i));
		}
		int qtdpagina = bd.size()/size;
		int paginaAtual = page;
		int paginaFinal = qtdpagina;
		int proxPagina = qtdpagina > page +1? paginaAtual+1:paginaAtual;
		int paginaAnterior = paginaAtual -1 > 0 ? paginaAtual-1: paginaAtual;
		int qtdItens = listagem.size();
		
		PageDTO pageDTO = new PageDTO(listagem, paginaAtual, paginaFinal, qtdpagina, proxPagina, paginaAnterior, qtdItens);
		return pageDTO;
		
		
		
	}
	*/
}
