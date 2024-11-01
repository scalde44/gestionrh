package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Vacacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacacionRepository extends JpaRepository<Vacacion, Long> {
}