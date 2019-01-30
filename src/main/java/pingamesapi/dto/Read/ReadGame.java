package pingamesapi.dto.Read;

import pingamesapi.domain.Game;

public class ReadGame {

	private Long idGame;

	private String nomeGame;

	private String generoGame;

	private Short faixaEtariaGame;

	private double precoGame;

	public ReadGame() {

	}

	public ReadGame(Long idGame, String nomeGame, String generoGame, Short faixaEtariaGame, double precoGame) {
		this.idGame = idGame;
		this.nomeGame = nomeGame;
		this.generoGame = generoGame;
		this.faixaEtariaGame = faixaEtariaGame;
		this.precoGame = precoGame;
	}

	public ReadGame(Game game) {
		this.idGame = game.getId();
		this.nomeGame = game.getNome();
		this.faixaEtariaGame = game.getFaixaEtaria();
		this.generoGame = game.getGenero();
		this.precoGame = game.getPreco();
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public String getNomeGame() {
		return nomeGame;
	}

	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}

	public String getGeneroGame() {
		return generoGame;
	}

	public void setGeneroGame(String generoGame) {
		this.generoGame = generoGame;
	}

	public Short getFaixaEtariaGame() {
		return faixaEtariaGame;
	}

	public void setFaixaEtariaGame(Short faixaEtariaGame) {
		this.faixaEtariaGame = faixaEtariaGame;
	}

	public double getPrecoGame() {
		return precoGame;
	}

	public void setPrecoGame(double precoGame) {
		this.precoGame = precoGame;
	}

}
