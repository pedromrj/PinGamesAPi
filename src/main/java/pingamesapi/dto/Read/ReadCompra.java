package pingamesapi.dto.Read;

import java.util.ArrayList;
import java.util.List;

public class ReadCompra {
	
	private List<ReadGame> gamesGame = new ArrayList<ReadGame>();
	
	public double getValorTotal() {
		double soma = 0;
		for (ReadGame game : gamesGame) {
			soma = game.getPrecoGame();
		}
		return soma;
	}

	public List<ReadGame> getGames() {
		return gamesGame;
	}

	public void setGames(List<ReadGame> games) {
		this.gamesGame = games;
	}

}
