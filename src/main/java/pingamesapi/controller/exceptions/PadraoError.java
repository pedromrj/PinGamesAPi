package pingamesapi.controller.exceptions;

public class PadraoError {

	private Integer status;

	private String descricao;

	private Long timestamp;

	public PadraoError(Integer status, String descricao, Long timestamp) {
		this.status = status;
		this.descricao = descricao;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
