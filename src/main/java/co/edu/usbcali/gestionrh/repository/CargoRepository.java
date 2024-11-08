package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}