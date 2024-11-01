package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Profesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesionRepository extends JpaRepository<Profesion, Long> {
}