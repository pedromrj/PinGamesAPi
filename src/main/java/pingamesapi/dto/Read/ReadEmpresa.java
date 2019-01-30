package pingamesapi.dto.Read;

public class ReadEmpresa {
	
	private Long idEmpreas;
	
	private String nomeEmpresa;

	public Long getId() {
		return idEmpreas;
	}

	public void setId(Long id) {
		this.idEmpreas = id;
	}

	public String getNome() {
		return nomeEmpresa;
	}

	public void setNome(String nome) {
		this.nomeEmpresa = nome;
	}

}
