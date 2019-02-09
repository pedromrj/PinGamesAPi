package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotEmpty;

public class CadastraPlataforma {
	
	@NotEmpty
	private String plataforma;

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	

}
