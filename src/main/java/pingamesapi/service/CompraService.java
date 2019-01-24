package pingamesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Compra;
import pingamesapi.domain.Game;
import pingamesapi.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private UsuarioService usuarioService; 
	
	
	@Autowired
	public CompraRepository compraRepository;
	
	public Compra findOne(Long id) {
		return compraRepository.findById(id).get();
	}

	public Compra create(Compra obj) {
		obj = processamento(obj);
		compraRepository.save(obj);
		return obj;
	}
	
	private Compra processamento(Compra obj) {
		for (Game jogo : obj.getJogo()) {
			Game aux = gameService.findOne(jogo.getId());
			jogo = aux;
			jogo.getCompras().add(obj);
			gameService.update(jogo);
		}
		obj.setUsuario(usuarioService.findOne(obj.getUsuario().getId()));
		obj.getUsuario().getHistorico().add(obj);
		usuarioService.create(obj.getUsuario());
		return obj;
		
	}

}
