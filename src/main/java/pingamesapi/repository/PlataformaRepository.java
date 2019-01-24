package pingamesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pingamesapi.domain.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{

}
