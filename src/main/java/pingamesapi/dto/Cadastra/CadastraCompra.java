package pingamesapi.dto.Cadastra;

import java.util.ArrayList;
import java.util.List;

public class CadastraCompra {

	private Long usuarioId;

	private List<Long> jogos = new ArrayList<Long>();

	private Integer status;
	
	public CadastraCompra() {
		
	}

	public CadastraCompra(Long usuarioIdUsuario, List<Long> jogosGame, Integer statusCompra) {
		super();
		this.usuarioId = usuarioIdUsuario;
		this.jogos = jogosGame;
		this.status = statusCompra;
	}

	public Long getUsuarioIdUsuario() {
		return usuarioId;
	}

	public void setUsuarioIdUsuario(Long usuarioIdUsuario) {
		this.usuarioId = usuarioIdUsuario;
	}

	public List<Long> getJogosGame() {
		return jogos;
	}

	public void setJogosGame(List<Long> jogosGame) {
		this.jogos = jogosGame;
	}

	public Integer getStatusCompra() {
		return status;
	}

	public void setStatusCompra(Integer statusCompra) {
		this.status = statusCompra;
	}

}
