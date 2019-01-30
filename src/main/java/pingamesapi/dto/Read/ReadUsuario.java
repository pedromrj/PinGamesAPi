package pingamesapi.dto.Read;

import java.util.ArrayList;
import java.util.List;

public class ReadUsuario {
	
	private String nomeUsuario;
	
	private String cpfUsuario;
	
	private String dataNascimentoUsuario;
	
	private List<ReadGame> bibliotecaUsuario = new ArrayList<ReadGame>();
	
	private List<ReadCompra> historicoUsuario = new ArrayList<ReadCompra>();
	
	public ReadUsuario() {
		
	}

	public ReadUsuario(String nomeUsuario, String cpfUsuario, String dataNascimentoUsuario,
			List<ReadGame> bibliotecaUsuario, List<ReadCompra> historicoUsuario) {
		this.nomeUsuario = nomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.dataNascimentoUsuario = dataNascimentoUsuario;
		this.bibliotecaUsuario = bibliotecaUsuario;
		this.historicoUsuario = historicoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getDataNascimentoUsuario() {
		return dataNascimentoUsuario;
	}

	public void setDataNascimentoUsuario(String dataNascimentoUsuario) {
		this.dataNascimentoUsuario = dataNascimentoUsuario;
	}

	public List<ReadGame> getBibliotecaUsuario() {
		return bibliotecaUsuario;
	}

	public void setBibliotecaUsuario(List<ReadGame> bibliotecaUsuario) {
		this.bibliotecaUsuario = bibliotecaUsuario;
	}

	public List<ReadCompra> getHistoricoUsuario() {
		return historicoUsuario;
	}

	public void setHistoricoUsuario(List<ReadCompra> historicoUsuario) {
		this.historicoUsuario = historicoUsuario;
	}

	
	
	
}
