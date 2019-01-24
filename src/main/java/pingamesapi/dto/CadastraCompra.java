package pingamesapi.dto;

import java.util.ArrayList;
import java.util.List;

public class CadastraCompra {

	private Long id_usuario;

	private List<Long> jogos = new ArrayList<Long>();

	private Integer status;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<Long> getJogos() {
		return jogos;
	}

	public void setJogos(List<Long> jogos) {
		this.jogos = jogos;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
