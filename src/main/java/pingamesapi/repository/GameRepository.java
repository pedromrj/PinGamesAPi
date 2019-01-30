package pingamesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pingamesapi.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	@Query(
			value = "SELECT * FROM games WHERE game_nome like %:nome% ",
			nativeQuery = true
			)
	List<Game> findAllNomes(@Param("nome") String nome);
	
	@Query(
			value = "SELECT * FROM games WHERE game_genero = :genero",
			nativeQuery = true
			)
	List<Game> findAllByGenero(@Param("genero") String nome);
	
	@Query(
			value = "SELECT * FROM games WHERE (select substring(game_lancamento,5,8) FROM games) = :ano",
			nativeQuery = true
			)
	List<Game> findAllByAno(@Param("ano") String ano);
	
}
