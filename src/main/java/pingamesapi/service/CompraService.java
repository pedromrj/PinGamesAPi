package pingamesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pingamesapi.domain.Compra;
import pingamesapi.domain.Game;
import pingamesapi.domain.enums.TipoCompra;
import pingamesapi.dto.CadastraCompra;
import pingamesapi.repository.CompraRepository;

@Service
public class CompraService {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	public CompraRepository compraRepository;
	
	public Compra findOne(Long id) throws Exception {
		if(compraRepository.existsById(id)) {
			return compraRepository.findById(id).get();
		}
		throw new Exception("ID INVALIDO");
	}

	public Compra create(CadastraCompra obj) {
		Compra buy = fromDTO(obj);
		buy = processamento(buy);
		return compraRepository.save(buy);
	}
	

	private Compra processamento(Compra obj) {
		if(obj.getStatus() == TipoCompra.QUITADO) {
			for (Game jogo : obj.getJogo()) {
				Game aux = gameService.findOne(jogo.getId());
				jogo = aux;
				jogo.getCompras().add(obj);
				gameService.update(jogo);
			}
			obj.setUsuario(usuarioService.findOne(obj.getUsuario().getId()));
			obj.getUsuario().getHistorico().add(obj);
			usuarioService.update(obj.getUsuario());
		}
		return obj;
	}
	
	public void update(Compra obj) {
		Compra buy = processamento(obj);
		compraRepository.save(buy);
	}
	

	private Compra fromDTO(CadastraCompra obj) {
		Compra buy = new Compra();
		buy.setUsuario(usuarioService.findOne(obj.getId_usuario()));
		List<Game> jogos = new ArrayList<Game>();
		for (Long id : obj.getJogos()) {
			jogos.add(gameService.findOne(id));
		}
		buy.setStatus(TipoCompra.toEnum(obj.getStatus()));
		return buy;
	}

}
