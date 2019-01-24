package pingamesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pingamesapi.domain.Biblioteca;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

}
