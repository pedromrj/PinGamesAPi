package pingamesapi.dto.Read;

import java.util.ArrayList;
import java.util.List;

public class ReadCompra {
	
	private List<ReadGame> games = new ArrayList<ReadGame>();
	
	public double getValorTotal() {
		double soma = 0;
		for (ReadGame game : games) {
			soma = game.getPreco();
		}
		return soma;
	}

	public List<ReadGame> getGames() {
		return games;
	}

	public void setGames(List<ReadGame> games) {
		this.games = games;
	}

}
