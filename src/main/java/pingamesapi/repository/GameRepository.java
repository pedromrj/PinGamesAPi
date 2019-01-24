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
	
	//List<Game> findByNome(String nome);
	
}
