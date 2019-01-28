package pingamesapi.dto.Read;

import pingamesapi.domain.Game;

public class ReadGame {
	
	private Long id;
	
	private String nome;
	
	private String genero;
	
	private Short faixa;
	
	private double preco;
	
	public ReadGame() {
		
	}

	public ReadGame(Game game) {
		this.id = game.getId();
		this.nome = game.getNome();
		this.genero = game.getGenero();
		this.faixa = game.getFaixaEtaria();
		this.preco = game.getPreco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Short getFaixa() {
		return faixa;
	}

	public void setFaixa(Short faixa) {
		this.faixa = faixa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
