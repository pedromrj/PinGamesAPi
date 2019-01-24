package pingamesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pingamesapi.domain.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long>{

}
