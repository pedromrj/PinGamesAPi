package pingamesapi.dto.Cadastra;

import javax.validation.constraints.NotBlank;

public class CadastraPlataforma {
	
	@NotBlank
	private String plataforma;

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	

}
