package pingamesapi.dto.Read;

import java.util.ArrayList;
import java.util.List;

public class ReadUsuario {
	
	private String nome;
	
	private String cpf;
	
	private String dataNascimento;
	
	private List<ReadGame> biblioteca = new ArrayList<ReadGame>();
	
	private List<ReadCompra> historico = new ArrayList<ReadCompra>();

	
	
	public ReadUsuario(String nome, String cpf, String dataNascimento, List<ReadGame> biblioteca,
			List<ReadCompra> historico) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.biblioteca = biblioteca;
		this.historico = historico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<ReadGame> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<ReadGame> biblioteca) {
		this.biblioteca = biblioteca;
	}

	public List<ReadCompra> getHistorico() {
		return historico;
	}

	public void setHistorico(List<ReadCompra> historico) {
		this.historico = historico;
	}
	
	
}
